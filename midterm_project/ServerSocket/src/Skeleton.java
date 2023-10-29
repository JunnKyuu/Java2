import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Skeleton {
	private final int port;
	HashMap<String, Object> objectMap;
	
	public Skeleton() {	
		this.port = 12345;
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("CLogin", new CLogin()); 
	}
	
	public void process() {
		try {
            ServerSocket serverSocket = new ServerSocket(port);
    		System.out.println("--------------- 클라이언트와 서버 연결 ---------------\n");
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다... (PORT : " + port + ")");
      
            while(true) {
            	Socket clientSocket = serverSocket.accept();  
                System.out.println("클라이언트가 연결되었습니다.\n" + "주소: " + clientSocket.getInetAddress());

                Session session = new Session(clientSocket, objectMap);
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
	            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
	            
				String objectName = in.readLine();
				String methodName = in.readLine();
				String args = in.readLine();
			    out.println(objectName + " " + methodName + " " + args);
			    			    
			    Object object = this.objectMap.get(objectName);
			    Method method = object.getClass().getMethod(methodName, String.class);
			    String result = (String) method.invoke(object, (Object)args);			    
			    out.println(result);
			    			    
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
