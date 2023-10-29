import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CLogin implements ICLogin {	
	public void login(String args) throws SQLException {
		String[] argsArray = args.split(" ");
		String studentId = argsArray[0];
		String userPassword = argsArray[1];
		System.out.print(studentId + userPassword);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/OOP_LMS", "root", "leejunkyu87");
			System.out.println("\n***Mysql 연결이 성공했습니다.***\n");
			
			String sql = "SELECT studentId, userPassword FROM User WHERE studentId = ? AND userPassword = ?";
	        PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, studentId);
	        preparedStatement.setString(2, userPassword);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        if (resultSet.next()) System.out.println("***회원정보 조회 성공***\n로그인에 성공했습니다.");
	        else System.out.println("***회원정보 조회 실패***\n로그인에 실패했습니다.");
		} 
		catch (ClassNotFoundException e) { System.out.println("Mysql Driver Error"); e.printStackTrace();} 
		catch (SQLException e) { System.out.println("Mysql Connection Error"); e.printStackTrace(); }

		
	}
}