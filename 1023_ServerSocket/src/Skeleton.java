import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Skeleton {
	private final int port;
	HashMap<String, Object> objectMap;
	
	public Skeleton() {
		// 여기도 동적으로 만들어야함 
		this.port = 12345;
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("cLogin", new CLogin());
	}
	
	public void process() {
		try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다... (PORT : " + port + ")");
      
            while(true) {
            	Socket clientSocket = serverSocket.accept(); // 작업자  
                System.out.println("클라이언트가 연결되었습니다." + clientSocket.getInetAddress());

                Session session = new Session(clientSocket, objectMap); // session을 만들어서 담당 
                session.process();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public class Session {
		private Socket clientSocket;
		private HashMap<String, Object> objectMap;
		
		public Session(Socket clientSocket, HashMap<String, Object> objectMap) {
			this.clientSocket = clientSocket;
			this.objectMap = objectMap;
		}

		public void process() {
			try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
	            
				String objectName = reader.readLine();
				String methodName = reader.readLine();
				String args = reader.readLine();
			    writer.println("서버에서 보낸 응답 : " + objectName + methodName + args);
	
			    Object object = this.objectMap.get(objectName);
			    String result = (String)object.getClass().getMethod(args, null).invoke(object, null);
			    writer.println(result);
			    clientSocket.close();
	            System.out.println("클라이언트와 연결이 끊어졌습니다 : " + clientSocket.getInetAddress());
	            System.out.println("-----------------------------------------------------------------------");
			} catch (IllegalAccessException | IllegalArgumentException 
					| InvocationTargetException
					| NoSuchMethodException | SecurityException | IOException e) {
					e.printStackTrace();
			}
		}
	} 
}
