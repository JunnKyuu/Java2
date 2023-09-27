import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SMain {

	private void run() {
		final int PORT = 12345;
		
		try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("서버가 시작되었습니다. 클라이언트의 연결을 기다립니다... (PORT : " + PORT + ")");
            
            while(true) {
            	Socket clientSocket = serverSocket.accept();
                System.out.println("클라이언트가 연결되었습니다.");
                
//              여기를 작업자에게 줄 수 있다.
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientMessage = null;
                while((clientMessage= in.readLine()) != null) {
    	            System.out.println("클라이언트로부터 받은 메시지: " + clientMessage);
    	            out.println("서버에서 보낸 응답 : " +  "클라이언트가 보낸 메세지인 '" + clientMessage + "'를 받았습니다!");
                }
              
                in.close();
                out.close();
                clientSocket.close();
//                
            }
//            serverSocket.close();        
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		SMain main = new SMain();
		main.run();
	}
}
