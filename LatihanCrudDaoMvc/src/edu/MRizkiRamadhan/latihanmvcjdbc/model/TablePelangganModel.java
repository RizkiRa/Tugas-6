/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.MRizkiRamadhan.latihanmvcjdbc.model;

import edu.MRizkiRamadhan.latihanmvcjdbc.entity.pelanggan;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class TablePelangganModel extends AbstractTableModel {
    private List<pelanggan> list = new ArrayList<pelanggan>();
    
    public void setList(List<pelanggan> list){
        this.list=list;
    }

    @Override
    public int getRowCount() {
       return list.size();
    }

    @Override
    public int getColumnCount() {
       return 5;
    }

    public boolean add(pelanggan e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount()-1,getRowCount()-1);
        }
    }

    public pelanggan get(int index) {
        return list.get(index);
    }

    public pelanggan set(int index, pelanggan element) {
        try {
            return list.set(index, element);
            
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public pelanggan remove(int index) {
        try {
            return list.remove(index);
        } finally {
            fireTableRowsDeleted(index, index);
        }
        
        
        
    }
    
    

    @Override
    public String getColumnName(int column) {
        switch (column){
                case 0:
                    return "id";
                case 1:
                    return "nama";
                case 2:
                    return "alamat";
                case 3:
                    return "telepon";
                case 4:
                    return "email";
                default:
                    return null;
    
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getAlamat();
            case 3:
                return list.get(rowIndex).getTelepon();
            case 4:
                return list.get(rowIndex).getEmail();
            default:
                return null;
            
        }
    }
    
    
}
