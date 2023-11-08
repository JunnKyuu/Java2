import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Login extends UnicastRemoteObject implements ILogin {
	private static final long serialVersionUID = 1L;
	
    public Login() throws RemoteException { 
    	super(); 
    }
    
    public String login() throws RemoteException { 
    	return null; 
    }
}
