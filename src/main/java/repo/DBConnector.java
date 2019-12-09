package repo;

import java.sql.*;

/**
 * This class handles the connection and queries for DataBase.
 */
public class DBConnector {

    public final static String PORT = "3306";
    public final static String DB_NAME = "LibraryCatalog";
    public final static String USER = "root";
    public final static String PASS = "";
    public final static String HOST = "localhost";

    private static DBConnector instance;
    private static Connection connection;

    private DBConnector() {
        try {
            String url = String.format("jdbc:mysql://%s:%s/%s", HOST, PORT, DB_NAME);
            connection = DriverManager.getConnection(url, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBConnector getInstance() {
        if (instance == null)
            return new DBConnector();
        return null;
    }

    ///insert update
    public int executeUpdate(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    ///select
    public ResultSet executeQuery(String query){
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
