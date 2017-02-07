/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.technique;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SaddeM
 */
public class DataSource {
    
    
    Properties properties;
    private String url;
    private String login;
    private String password;
    private Connection connection;
    private static DataSource instance;

    private DataSource() {
        if (connection == null) {
            properties = new Properties();
            try {
                properties.load(new FileInputStream(new File("configuration.properties")));
                url = properties.getProperty("url");
                login = properties.getProperty("utilisateur");
                password = properties.getProperty("pwd");
                connection = DriverManager.getConnection(url, login, password);
                System.out.println("Connection effectuée ZDOM");
            } catch (SQLException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(DataSource.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DataSource getInstance() {
        if (instance == null) {
            instance = new DataSource();
        }
        return instance;
    }
    
}
