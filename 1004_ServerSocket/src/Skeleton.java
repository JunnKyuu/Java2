import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Skeleton {
	HashMap<String, Object> objectMap;
	
	public Skeleton() {
		this.objectMap = new HashMap<String, Object>();
		this.objectMap.put("control", new Control());
	}
	
	public void process() {
		final int PORT = 12345;
		
		try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            
            while(true) {
                System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다... (PORT : " + PORT + ")");
            	Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다." + clientSocket.getInetAddress());
                
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String objectName = null;
                String methodName = null;
                String args = null;
                
                while((objectName = reader.readLine()) != null) {
                	methodName = reader.readLine();
                	args = reader.readLine();
    	            writer.println("서버에서 보낸 응답 : " + objectName + methodName + args);

    	            Object object = this.objectMap.get(objectName);
    	            
    	            writer.println("test");
                }
                
                clientSocket.close();
                System.out.println("클라이언트와 연결이 끊어졌습니다 : " + clientSocket.getInetAddress());
                System.out.println("-----------------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
