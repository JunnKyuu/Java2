import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CMain {

	private void run() {
		final String SERVER_IP = "localhost";
		final int SERVER_PORT = 12345;
		
		try {
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            System.out.println("서버에 연결되었습니다!!");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "안녕하세요!!";
            out.println(message);
            System.out.println("서버로 보낸 메세지 : " + message);

            String serverResponse = in.readLine();
            System.out.println(serverResponse);

            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args) {
		CMain main = new CMain();
		main.run();
	}

}
