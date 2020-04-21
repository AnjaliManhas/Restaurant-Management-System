package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static java.lang.Class.forName;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static final String JBDCDriver= "com.mysql.jdbc.Driver";
    static final String DB_URL= "jdbc:mysql://localhost/cab?";
    static final String USER = "root";
    static final String PASS = "root1234@1234";
    public void writeDiningDetailsInDb( String diningId, int capacity, float price, String shape)
            throws Exception {
        try{
            forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
            String SQL= "insert into  restaurant.dining values (default, ?, ?, ?)";
            preparedStatement= connect.prepareStatement(SQL);
            preparedStatement.setInt(1, capacity);
            preparedStatement.setFloat(2, price);
            preparedStatement.setString(3, shape);

            preparedStatement.executeUpdate();

        }
        catch (Exception e) {
            throw e;
        }
        finally {
            connect.close();

        }
    }
    public void writeWaiterDetailsInDb( String waiterId, String waiterName, String waiterPhoneNumber)
            throws Exception {
        try{
            forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
            String SQL= "insert into  restaurant.waiter values (default, ?, ?)";
            preparedStatement= connect.prepareStatement(SQL);
            preparedStatement.setString(1, waiterName);
            preparedStatement.setString(2, waiterPhoneNumber);

            preparedStatement.executeUpdate();

        }
        catch (Exception e) {
            throw e;
        }
        finally {
            connect.close();

        }
    }
    public void mapDiningWaiterIdInDb( String diningID,String waiterID ) throws Exception{
        try{

                forName("com.mysql.jdbc.Driver");
                System.out.println("Connecting to database...");
                connect = DriverManager.getConnection(DB_URL,USER,PASS);
                String SQL= "insert into  restaurant.map values (?, ?)";
                preparedStatement= connect.prepareStatement(SQL);
                preparedStatement.setString(1, diningID);
                preparedStatement.setString(2, waiterID);

                preparedStatement.executeUpdate();
            }
             catch (Exception e) {
                throw e;
            }
        finally {
                connect.close();

            }
    }
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
