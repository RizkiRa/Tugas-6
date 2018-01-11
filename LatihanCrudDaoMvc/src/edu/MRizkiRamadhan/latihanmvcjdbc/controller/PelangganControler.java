/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.controller;

import edu.MRizkiRamadhan.latihanmvcjdbc.model.PelangganModel;
import edu.MRizkiRamadhan.latihanmvcjdbc.view.pelangganView;
import javax.swing.JOptionPane;

/* Muhamad Rizki Ramadhan 
   10116539
   PBO-12
*/
/**
 *
 * @author ASUS
 */
public class PelangganControler {
    private PelangganModel model;
    
    public void setModel(PelangganModel model){
        this.model = model;
    }
    public void resetPelanggan(pelangganView view){
        model.resetPelanggan();
    }
    public void insertPelanggan(pelangganView view){
        String nama = view.getTxtnama().getText();
        String alamat = view.getTxtalamat().getText();
        String telepon = view.getTxttelepon().getText();
        String email = view.getTxtemail().getText();
        
        if (nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "NAMA TIDAK BOLEH KOSONG");
        }else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "NAMA TIDAK BOLEH LEBIH DARI 255 KARAKTER");
        }else if (telepon.length()>12){
            JOptionPane.showMessageDialog(view, "NOMOR TELEPON TIDAK BOLEH LEBIH DARI 12");
        }else if (!email.contains("@")){
            JOptionPane.showMessageDialog(view, "EMAIL TIDAK VALID");
        }else {
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.insertPelanggan();
                JOptionPane.showMessageDialog(view,"pelanggan berhasil ditambahkan");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi errordi database dengan pesan",throwable.getMessage()});
            }
        }
            
        
    }
    public void updatePelanggan(pelangganView view){
        if (view.getTBpelanggan().getSelectedRowCount()==0){
            
            JOptionPane.showMessageDialog(view, "SILAHKAN PILIH BARIS DATA YANG AKAN DI UBAH");
            return;
        }
        
        Integer id = Integer.parseInt(view.getTxtid().getText());
        
        String nama = view.getTxtnama().getText();
        String alamat = view.getTxtalamat().getText();
        String telepon = view.getTxttelepon().getText();
        String email = view.getTxtemail().getText();
        
        if (nama.trim().equals("")){
            JOptionPane.showMessageDialog(view, "NAMA TIDAK BOLEH KOSONG");
        }else if (nama.length()>255){
            JOptionPane.showMessageDialog(view, "NAMA TIDAK BOLEH LEBIH DARI 255 KARAKTER");
        }else if (telepon.length()>12){
            JOptionPane.showMessageDialog(view, "NOMOR TELEPON TIDAK BOLEH LEBIH DARI 12");
        }else if (!email.contains("@")){
            JOptionPane.showMessageDialog(view, "EMAIL TIDAK VALID");
        }else {
            model.setId(id);
            model.setNama(nama);
            model.setAlamat(alamat);
            model.setTelepon(telepon);
            model.setEmail(email);
            
            try {
                model.updatePelanggan();
                JOptionPane.showMessageDialog(view,"pelanggan berhasil di ubah");
                model.resetPelanggan();
            } catch (Throwable throwable) {
                JOptionPane.showMessageDialog(view, new Object[]{"terjadi errordi database dengan pesan",throwable.getMessage()});
            }
        }
        
    }
    public void deletePelanggan(pelangganView view){
        if (view.getTBpelanggan().getSelectedRowCount()==0){
            
            JOptionPane.showMessageDialog(view, "SILAHKAN PILIH BARIS DATA YANG AKAN DI HAPUS");
            return;
        }
        if (JOptionPane.showConfirmDialog(view, "anda yakin akan menghapus ?")== JOptionPane.OK_OPTION){
            Integer id = Integer.parseInt(view.getTxtid().getText());
            model.setId(id);
        }
        try {
            model.deletePelanggan();
            JOptionPane.showMessageDialog(view, "Pelanggan Berhasil Di hapus");
            model.resetPelanggan();
        } catch (Throwable throwable) {
            JOptionPane.showMessageDialog(view, new Object[]{"terjadi erorr di database dengan pesan ", throwable.getMessage()});
        }
        
    }
}
