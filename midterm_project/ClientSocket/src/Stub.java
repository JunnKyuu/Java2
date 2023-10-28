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
	
	public ArrayList<String> request(String objectName, String methodName, String args) {
	    try {
	        // 서버에 연결
	        Socket socket = new Socket(serverIP, serverPort);
	        System.out.println("서버가 연결되었습니다.");

	        // 서버와 데이터를 주고받기 위한 입력 및 출력 스트림 생성
	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

	        // 서버로 메세지 전송
	        out.println(objectName);
	        out.println(methodName);
	        out.println(args);

	        System.out.println("서버로 보낸 요청: " + objectName + methodName + args);

	        // 서버로부터 응답 받기
	        ArrayList<String> userInfoList = new ArrayList<>();
	        String userInfo;
	        while ((userInfo = in.readLine()) != null) {
	            userInfoList.add(userInfo);
	        }
	        System.out.println("서버로 부터 받은 응답: " + userInfoList);

	        // Socket 연결 종료
	        socket.close();
	        return userInfoList;
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
}