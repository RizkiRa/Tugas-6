/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.event;

import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import edu.MRizkiRamadhan.latihanmvcjdbc.model.PelangganModel;

/* Muhamad Rizki Ramadhan 
   10116539
   PBO-12
*/
/**
 *
 * @author ASUS
 */
public interface PelangganListener {
    public void OnChange(PelangganModel model);
    public void OnInsert(pelanggan pelanggan);
    public void OnDelete();
    public void OnUpdate(pelanggan pelanggan);

    

    

    

    
    
    
}
