/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.database;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import edu.MRizkiRamadhan.latihanmvcjdbc.impl.pelangganDAOimpl;
import edu.MRizkiRamadhan.latihanmvcjdbc.service.PelangganDAO;
import java.sql.SQLException;

/* Muhamad Rizki Ramadhan 
   10116539
   PBO-12
*/

/**
 *
 * @author ASUS
 */
public class KingsBarbershoDatabase {
    private static Connection connection;
    private static PelangganDAO pelangganDAO;
    
    
    public static Connection getConnection() throws  SQLException{
        if (connection==null) {
            
            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/kingsbarbershop");
            datasource.setUser("root");
            datasource.setPassword("");
            connection = (Connection) datasource.getConnection();
            
            
            
        }
        
        return connection;
    }
    public static PelangganDAO getPelangganDAO() throws SQLException{
        if(pelangganDAO==null){
            pelangganDAO = new pelangganDAOimpl(getConnection());
        }
        return pelangganDAO;
    }
    
    
    
}
