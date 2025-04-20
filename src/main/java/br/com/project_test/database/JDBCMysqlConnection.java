package br.com.project_test.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCMysqlConnection {
    private static final String url = "jdbc:mysql://localhost:3306/event_manager";
    private static final String user = "root";
    private static final String password = "Urubu@100";

    public static Connection connection() throws SQLException{
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        }catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
