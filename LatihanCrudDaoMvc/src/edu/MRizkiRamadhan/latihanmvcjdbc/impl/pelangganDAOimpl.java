/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.impl;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import edu.MRizkiRamadhan.latihanmvcjdbc.error.PelangganException;
import edu.MRizkiRamadhan.latihanmvcjdbc.service.PelangganDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/* Muhamad Rizki Ramadhan 
   10116539
   PBO-12
*/

/**
 *
 * @author ASUS
 */
public class pelangganDAOimpl implements PelangganDAO {
    private Connection connection;
    
    private final String insertPelanggan = "Insert into pelanggan (nama,alamat,telepon,email)values (?,?,?,?)";
    
    private final String updatePelanggan = "update pelanggan set nama=?,alamat=?,telepon=?,email=? where id=?";
    
    private final String deletePelanggan = "delete from pelanggan where id=?";
    
    private final String getById = "Select * from pelanggan where id=? ";
    
    private final String getByEmail = "Select * from pelanggan where email=? ";
    
    private final String selectAll = "Select * from  pelanggan";
    
    public pelangganDAOimpl(Connection connection) {
        this.connection = connection;
    }
    

    @Override
    public void insertPelanggan(pelanggan pelanggan) throws PelangganException {
        PreparedStatement Statment = null;
        
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.prepareStatement(insertPelanggan, Statment.RETURN_GENERATED_KEYS);
            Statment.setString(1, pelanggan.getNama());
            Statment.setString(2, pelanggan.getAlamat());
            Statment.setString(3, pelanggan.getTelepon());
            Statment.setString(4, pelanggan.getEmail());
            Statment.executeUpdate();
            
            ResultSet result = Statment.getGeneratedKeys();
            if(result.next()){
                pelanggan.setId(result.getInt(1));
            }
            
            connection.commit();
            
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
    }

    @Override
    public void updatePelanggan(pelanggan pelanggan) throws PelangganException {
       PreparedStatement Statment = null;
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.prepareStatement(updatePelanggan);
            Statment.setString(1, pelanggan.getNama());
            Statment.setString(2, pelanggan.getAlamat());
            Statment.setString(3, pelanggan.getTelepon());
            Statment.setString(4, pelanggan.getEmail());
            Statment.setInt(5, pelanggan.getId());
            Statment.executeUpdate();
            connection.commit();
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
    }

    @Override
    public void deletePelanggan(Integer ID) throws PelangganException {
         PreparedStatement Statment = null;
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.prepareStatement(deletePelanggan);
            Statment.setInt(1, ID);
            Statment.executeUpdate();
            connection.commit();
            
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
    }

    @Override
    public pelanggan getPelanggan(Integer ID) throws PelangganException {
        PreparedStatement Statment = null;
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.prepareStatement(getById);
            Statment.setInt(1, ID);
            ResultSet result = Statment.executeQuery();
            pelanggan pelanggan = null;
            
            if (result.next()){
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
            }else{
                throw new PelangganException("pelanggan dengan id="+ID+" tidak ditemukan ");
                
            }
            connection.commit();
            return pelanggan;    
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
    
        }

    @Override
    public pelanggan getPelanggan(String email) throws PelangganException {
        PreparedStatement Statment = null;
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.prepareStatement(getByEmail);
            Statment.setString(1, email);
            ResultSet result = Statment.executeQuery();
            pelanggan pelanggan = null;
            
            if (result.next()){
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                
            }else{
                throw new PelangganException("pelanggan dengan email="+email+" tidak ditemukan ");
                
            }
            connection.commit();
            return pelanggan;    
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
      
    }

    @Override
    public List<pelanggan> selectAllPelanggan() throws PelangganException {
        Statement Statment = null;
        List<pelanggan> list = new ArrayList<pelanggan>();
        try {
            connection.setAutoCommit(false);
            Statment = (PreparedStatement) connection.createStatement();
            
            ResultSet result = Statment.executeQuery(selectAll);
            pelanggan pelanggan = null;
            
            while (result.next()){
                pelanggan = new pelanggan();
                pelanggan.setId(result.getInt("ID"));
                pelanggan.setNama(result.getString("NAMA"));
                pelanggan.setAlamat(result.getString("ALAMAT"));
                pelanggan.setTelepon(result.getString("TELEPON"));
                pelanggan.setEmail(result.getString("EMAIL"));
                list.add(pelanggan);
                
            }
            connection.commit();
            return list;    
        }catch (SQLException e){
            try {
                connection.rollback();
            } catch (Exception ex) {
            }
            
            throw new PelangganException(e.getMessage());
            
        }finally{
            try {
                connection.setAutoCommit(true);
            } catch (Exception ex) {
            }
            if (Statment != null)
            try{
                Statment.close();
                
            }catch (SQLException e){
                
            }
            
        }
    }}


   
    
    
        
