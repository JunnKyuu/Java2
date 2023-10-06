import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Stub {
	private String serverIP = "localhost";
	private int serverPort = 12345;
	
	public Stub(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public String request(String objectName, String methodName, String args) {
		
		try {
            Socket socket = new Socket(serverIP, serverPort);
            System.out.println("서버가 연결되었습니다.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println(objectName);            
            out.println(methodName);
            out.println(args);
    
            System.out.println("서버로 보낸 메세지 : " + objectName + methodName + args);

            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            String userInfo = in.readLine();
            System.out.println("서버로 부터 받은 메세지 : " + userInfo);
            
            socket.close();
            
            return userInfo;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
}