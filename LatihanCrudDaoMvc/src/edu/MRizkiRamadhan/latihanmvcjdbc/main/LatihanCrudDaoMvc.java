/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.main;

import edu.MRizkiRamadhan.latihanmvcjdbc.database.KingsBarbershoDatabase;
import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import edu.MRizkiRamadhan.latihanmvcjdbc.error.PelangganException;
import edu.MRizkiRamadhan.latihanmvcjdbc.service.PelangganDAO;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class LatihanCrudDaoMvc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, PelangganException{
        // TODO code application logic here
        PelangganDAO dao = KingsBarbershoDatabase.getPelangganDAO();
        pelanggan pelanggan = new pelanggan();
        pelanggan.setNama("MUHAMAD RIZKI RAMADHAN");
        pelanggan.setAlamat("BUMI ASRI");
        pelanggan.setTelepon("085721XXXX");
        pelanggan.setEmail("Rizkiramadhan350@gmail.com");
        
        dao.insertPelanggan(pelanggan);
        
        
    }
    
}
