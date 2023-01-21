import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private String username="root";
    private String password=".";// Bu kısma VT' şifrenizi gireceksiniz.
    private String dbURL="jdbc:mysql://localhost:3306/sakila?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbURL,username,password);
    }

    public void  ShowErrorMessage(SQLException exception){
        System.out.println("loglandi:"+exception.getMessage());
        System.out.println("Error code:"+exception.getErrorCode());
    }
}
