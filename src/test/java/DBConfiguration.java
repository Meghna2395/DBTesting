import org.testng.annotations.BeforeTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConfiguration {
    public static Connection connection;
    PreparedStatement pstmt = null;

    String Insert_Query = "INSERT INTO Employee (firstName,lastName) VALUES (?,?)";
    String UPDATE_TAble  =  "SELECT id, name, lastName FROM Employee";
    String Create_Table = " CREATE TABLE Employee\n" +
        "           ( id INT(11) NOT NULL AUTO_INCREMENT,\n" +
        "    firstName VARCHAR(30) NOT NULL,\n" +
        "   lastName VARCHAR(25),\n" +
        "    CONSTRAINT Employee_pk PRIMARY KEY (id)\n" +
        ")"  ;







    @BeforeTest
    public Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/spotify","root","root");
        System.out.println("Successfully established the connection:" +connection );
        return connection;
    }
}
