/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import com.controller.controller_makanan;
import com.koneksi.koneksi_bioskop;
import com.view.input_makanan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class model_makanan implements controller_makanan{

    @Override
    public void Simpan(input_makanan inpt) throws SQLException {
        try {
        Connection con = koneksi_bioskop.getcon();
        String sql = "Insert Into makanan Values (?,?,?,?,?)";
        PreparedStatement prepare = con.prepareStatement(sql);
        prepare.setString(1, inpt.txtNo.getText());
        prepare.setString(2, (String) inpt.cbMakanan.getSelectedItem());
        prepare.setString(3, (String) inpt.cbMinuman.getSelectedItem());
        prepare.setString(4, inpt.txtHarga.getText());
        prepare.setString(5, inpt.txtPesan.getText());
        prepare.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Berhasil Di Simpan");
        prepare.close();
        Baru(inpt);
    
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            Tampil(inpt);
            inpt.setLebarKolom();
        }
    }

    @Override
    public void Ubah(input_makanan inpt) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "UPDATE makanan SET Makanan=?, Minuman=?, " + "Harga=?, pesan=? WHERE No=?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, sql);
        } catch (Exception e) {
        }
    }

    @Override
    public void Hapus(input_makanan inpt) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "DELETE FROM siswa WHERE NIS =?";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, inpt.txtNo.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            prepare.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }finally {
            Tampil(inpt);
            inpt.setLebarKolom();
            Baru(inpt);
        }
    }

    @Override
    public void Baru(input_makanan inpt) throws SQLException {
        inpt.txtNo.setText("");
        inpt.cbMakanan.setSelectedIndex(0);
        inpt.cbMinuman.setSelectedIndex(0);
        inpt.txtHarga.setText("");
        inpt.txtPesan.setText("");
    }

    @Override
    public void Tampil(input_makanan inpt) throws SQLException {
        inpt.tblMakanan.getDataVector().removeAllElements();
        inpt.tblMakanan.fireTableDataChanged();
        try {
            Connection con = koneksi_bioskop.getcon();
            Statement stt = con.createStatement();
            
            
            String sql = "SELECT * FROM inpt ORDER BY NO ASC";
            ResultSet res = stt.executeQuery(sql);
            while (res.next()){
                Object[] ob = new Object[8];
                ob[0] = res.getString(1);
                ob[1] = res.getString(2);
                ob[2] = res.getString(3);
                ob[3] = res.getString(4);
                inpt.tblMakanan.addRow(ob);
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void KlikTable(input_makanan inpt) throws SQLException {
        try {
            int pilih = inpt.tblMakanan.getSelectedRow();
            if (pilih == -1){
                return;
            }
                    inpt.txtNo.setText(inpt.tblMakanan.getValueAt(pilih, 0).toString());
                    inpt.cbMakanan.setSelectedItem(inpt.tblMakanan.getValueAt(pilih, 1).toString());
                    inpt.cbMinuman.setSelectedItem(inpt.tblMakanan.getValueAt(pilih, 2).toString());
                    inpt.txtHarga.setText(inpt.tblMakanan.getValueAt(pilih, 3).toString());
                    inpt.txtPesan.setText(inpt.tblMakanan.getValueAt(pilih, 4).toString());
                    
        } catch (Exception e) {
            
        }
        
    }
    
}
