import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CLogin implements ICLogin {	
	
	public ArrayList<String> getUserInfo() {
		Socket clientSocket = new Socket();
	    DBConnection dbConnection = new DBConnection();
	    
	    ArrayList<String> dataList = new ArrayList<String>();
	    String sql = "SELECT * FROM User";
	    
	    Connection connection = dbConnection.getConnection();
	    java.sql.Statement statement = null;
	    ResultSet result = null;
	    
	    try {
	        statement = connection.createStatement();
	        result = statement.executeQuery(sql);
	        while(result.next()) {
	            String studentId = result.getString("studentId");
	            String name = result.getString("name");
	            String department = result.getString("department");
	            String userPassword = result.getString("userPassword");
	            
	            String answer = "studentId : " + studentId + "\n"
	                          + "name : " + name + "\n"
	                          + "department : " + department + "\n"
	                          + "userPassword : " + userPassword + "\n";
	            
	            dataList.add(answer);
	            
	            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
	            objectOutputStream.writeObject(dataList);
	            objectOutputStream.close();
	        }
	    } 
	    catch (Exception e) { 
	        System.out.println(e.getMessage()); 
	    } 
	    finally {
	        try { 
	            result.close(); 
	            statement.close(); 
	            connection.close(); 
	        } 
	        catch(Exception e) { 
	            e.printStackTrace(); 
	        }
	    }
	    
	    System.out.println("***Select Success***");
	    System.out.println(dataList);
	    return dataList;
	}

}