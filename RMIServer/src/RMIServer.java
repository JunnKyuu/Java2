import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            ILogin login = new Login();
            
            LocateRegistry.createRegistry(1100);
            Naming.rebind("login", login);
            
            System.out.println("Server is ready...");
        } catch (Exception e) {
            System.err.println("Server Exception" + e.getMessage());
            e.printStackTrace();
        } 
        // 이 부분도 skeleton으로 빼서 만들기 
    }
}
