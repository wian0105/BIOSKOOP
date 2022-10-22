a/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.controller.controller_bioskop;
import com.koneksi.koneksi_bioskop;
import com.view.Form_Bioskop;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class model_bioskop implements controller_bioskop{ 

    @Override
    public void simpan(Form_Bioskop bioskop) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "Insert Into siswa Values (?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, (String) bioskop.cbFilm.getSelectedItem());
            prepare.setString(2, bioskop.txtbangku.getText());
            bioskop.chbFb1 = new JCheckBox("PopCorn");
            bioskop.chbFb2 = new JCheckBox("Coffe");
            prepare.setString(5, bioskop.txtharga.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            prepare.close();
            baru(bioskop);
        } catch (Exception e) {
            System.out.println (e);
        } finally {
            Tampil(bioskop);
            siswa.setLebarKolom();
        }
    }
    
}