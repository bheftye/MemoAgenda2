/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fmat.proyectoMemo.struts.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Genny Andrea Centeno Metri 
 * @author Brent Heftye S��nchez
 * @author Maya Itzel Villanueva Borja
 * 
 */
public abstract class DAOBase {

    protected Connection connection;
    
    private final String HOST = "localhost";
    private final String DATABASE = "memoagenda";
    private final String USER = "root";
    private final String PASSWORD = "heftye92";
    private final String PORT = "3306";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String CONNECTION_STRING = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
//jdbc:mysql://localhost:3306/online_reserv
    protected DAOBase() {
        establishConnection();
    }

    protected void closeConnection() {
        if (connection != null) {
            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    protected int getGeneratedID(PreparedStatement statement) {
        int id = 0;
        try {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    protected int getGeneratedId(Statement statement){
    	int id = 0;
        try {
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    private void establishConnection() {
        connection = null;
        loadDriver();
        try {
            connection = DriverManager.getConnection(CONNECTION_STRING, USER, PASSWORD);
        } catch (SQLException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadDriver() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
