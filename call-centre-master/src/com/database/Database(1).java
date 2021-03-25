package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import com.database.Provider;
import java.sql.SQLException;

public class Database implements Provider {

    static Connection con = null;

    /**
     * This method is used to get Connection.
     *
     *
     * @return 
     */
    public static Connection getConnection(){
        try {

            if (con == null || con.isClosed()) {
                Class.forName( DRIVER_NAME);
                con = DriverManager.getConnection(HOST_NAME + DATABASE_NAME, USER_NAME, PASSWORD);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace(System.err);
        }
        return con;
    }

    /**
     * This method is used to close connection.
     *
     *
     */
    public static void closeConnection(Connection con) {
        try {
            con.close();
//		  System.out.println("Connection is close...");
        } catch (SQLException ex) {
            System.out.println("Exception : closeConnection() : Database.java : " + ex.getMessage());
        }
    }

}
