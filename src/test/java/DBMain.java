import org.testng.annotations.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBMain extends DBConfiguration {

    @Test
    public void getTableData() throws SQLException {
        connection = this.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from user");
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String email = resultSet.getString(3);
            System.out.println(id + "" + name + "" + email);

        }
    }

    //To create table
    @Test
    public void createTable(){
        try {
            connection = this.getConnection();
            pstmt = connection.prepareStatement(Create_Table);
            pstmt.execute(Create_Table);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test

    public  void insertIntoTable(){
       try
    {
        pstmt = connection.prepareStatement(Insert_Query);
        pstmt.setString(1, "meghna");
        pstmt.setString(2, "b");
        int affectedRows = pstmt.executeUpdate();
    }

        catch (Exception e) {
        e.printStackTrace();
    }
      }




//To update the table
//    @Test
//    public void insertIntoTable() throws SQLException {
//        connection = this.getConnection();
//        Statement statement = connection.createStatement();
//        statement.execute(Insert_Row);
//        statement.execute(Insert_Row2);
//        statement.execute(Insert_Row3);
//    }


    @Test
    public void updateTable() {
        try {
            connection = this.getConnection();
            String update = "UPDATE Employee SET firstName = 'pooja' WHERE id = 2";
            pstmt= connection.prepareStatement(UPDATE_TAble);
            pstmt.execute(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //To delete the row
    @Test
    public void deleteRow() {
        try {
            connection = this.getConnection();
            String delete = "DELETE FROM Contacts " + "WHERE id = 1 ";
            pstmt = connection.prepareStatement(delete);
            pstmt.execute(delete);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

