import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ILogin extends Remote {
    String login() throws RemoteException;
}
