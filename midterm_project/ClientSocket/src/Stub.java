import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Stub {
	private String serverIP = "localhost";
	private int serverPort = 12345;
	
	public Stub(String serverIP, int serverPort) {
		this.serverIP = serverIP;
		this.serverPort = serverPort;
	}
	
	public void request(String objectName, String methodName, String[] args) {
	    try {
	        Socket socket = new Socket(serverIP, serverPort);
	        System.out.println("서버가 연결되었습니다.");

	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	        String argsAsString = String.join(" ", args);
	        
	        out.println(objectName);
	        out.println(methodName);
	        out.println(argsAsString);
	        System.out.println("서버로 보낸 요청: " + objectName + methodName + args);
	        
	        String response = in.readLine();
	        System.out.println("서버에서 받은 응답: " + response);
	        
	        in.close(); out.close(); socket.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}