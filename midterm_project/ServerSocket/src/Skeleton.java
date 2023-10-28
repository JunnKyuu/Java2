import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Skeleton {
	private final int port;
	HashMap<String, Object> objectMap;
	
	public Skeleton() {
		// 여기도 동적으로 만들어야함 
		// 재사용 가능하게, 지금은 CLogin용도로만 사용이 가능함		
		this.port = 12345;
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("cLogin", new CLogin()); 
		// 여기에 원래 코드의 기능에 대한 C들을 다 등록해놓고
		// C에 대해 interface로 다 빼고 Client에서 Stub을 만들면 돌아감 
		// -> 직접 여기에 코드를 작성해도 되고, 파일에 작성해서 읽게 만들어도 됨
	}
	
	public void process() {
		try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다... (PORT : " + port + ")");
      
            while(true) {
            	Socket clientSocket = serverSocket.accept(); // 작업자  
                System.out.println("클라이언트가 연결되었습니다." + clientSocket.getInetAddress());

                Session session = new Session(clientSocket, objectMap); // session을 만들어서 담당 
                session.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public class Session extends Thread {
		private Socket clientSocket;
		private HashMap<String, Object> objectMap;
		
		public Session(Socket clientSocket, HashMap<String, Object> objectMap) {
			this.clientSocket = clientSocket;
			this.objectMap = objectMap;
		}

		public void run() {
			try {
	            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
	            
				String objectName = reader.readLine();
				String methodName = reader.readLine();
				String args = reader.readLine();
			    writer.println(objectName + methodName + args);
			    
			    Object object = this.objectMap.get(objectName);
			    ArrayList<String> result = (ArrayList<String>)object.getClass().getMethod(methodName).invoke(object); 
			    // parameter는 아직 못함 String Array로 날리기  d
			    
			    writer.println(result);
			    
			    
			    clientSocket.close();
	            System.out.println("클라이언트와 연결이 끊어졌습니다 : " + clientSocket.getInetAddress());
	            System.out.println("-----------------------------------------------------------------------");
	            
	            // 여기서 sleep을 20초 걸고 
	            // 2~3번 돌려보면 thread가 생성되었는지 알 수 있음
	            // 실행되면 thread가 만들어진 것 	
			} catch (IllegalAccessException | IllegalArgumentException 
					| InvocationTargetException
					| NoSuchMethodException | SecurityException | IOException e) {
					e.printStackTrace();
			}			
		}
	} 
}
