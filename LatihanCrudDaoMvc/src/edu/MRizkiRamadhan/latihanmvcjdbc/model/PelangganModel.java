/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.model;

import edu.MRizkiRamadhan.latihanmvcjdbc.database.KingsBarbershoDatabase;
import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import edu.MRizkiRamadhan.latihanmvcjdbc.error.PelangganException;
import edu.MRizkiRamadhan.latihanmvcjdbc.event.PelangganListener;
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
public class PelangganModel{
    private int id;
    private String nama;
    private String alamat;
    private String telepon;
    private String email;
    
    private PelangganListener listener;

    public PelangganListener getListener() {
        return listener;
    }

    public void setListener(PelangganListener listener) {
        this.listener = listener;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        fireOnChange();
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
        fireOnChange();
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
        fireOnChange();
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
        fireOnChange();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        fireOnChange();
    }
    protected void fireOnChange(){  
        if (listener!=null){
            listener.OnChange(this);
        }
    } 
    
    protected void fireOnInsert(pelanggan pelanggan){  
        if (listener!=null){
            listener.OnInsert(pelanggan);
        }
    }
    protected void fireOnDelete(){  
        if (listener!=null){
            listener.OnDelete();
        }
    }
    protected void fireOnUpdate(pelanggan pelanggan){  
        if (listener!=null){
            listener.OnUpdate(pelanggan);
        }
    }
    public void insertPelanggan() throws SQLException, PelangganException{
       
        PelangganDAO dao = KingsBarbershoDatabase.getPelangganDAO();
        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        
        dao.insertPelanggan(pelanggan);
        fireOnInsert(pelanggan);
        
    }
    
    public void updatePelanggan() throws SQLException, PelangganException{
       
        PelangganDAO dao = KingsBarbershoDatabase.getPelangganDAO();
        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama(nama);
        pelanggan.setAlamat(alamat);
        pelanggan.setTelepon(telepon);
        pelanggan.setEmail(email);
        pelanggan.setId(id);
        
        dao.updatePelanggan(pelanggan);
        fireOnUpdate(pelanggan);
    }
    
    public void deletePelanggan() throws SQLException, PelangganException{
        PelangganDAO dao = KingsBarbershoDatabase.getPelangganDAO();
        dao.deletePelanggan(id);
        fireOnDelete ();
        
       
    }
     public void resetPelanggan(){
         setId(0);
         setNama("");
         setAlamat("");
         setTelepon("");
         setEmail("");
         
         
     }

    
    
}
