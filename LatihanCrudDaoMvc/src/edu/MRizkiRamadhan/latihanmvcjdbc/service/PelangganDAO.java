/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.service;

import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import edu.MRizkiRamadhan.latihanmvcjdbc.error.PelangganException;
import java.util.List;

/* Muhamad Rizki Ramadhan 
   10116539
   PBO-12
*/

/**
 *
 * @author ASUS
 */
public interface PelangganDAO {
    public void insertPelanggan(pelanggan pelanggan) throws PelangganException;
    
    public void updatePelanggan(pelanggan pelanggan) throws PelangganException;
    
    public void deletePelanggan(Integer ID) throws PelangganException;
    
    public pelanggan getPelanggan(Integer ID) throws PelangganException;
    
    public pelanggan getPelanggan(String email) throws PelangganException;
    
    public List<pelanggan> selectAllPelanggan() throws PelangganException;
    
    
    
}
