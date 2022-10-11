/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.controller.controller_bioskop;
import com.view.Form_Bioskop;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class model_bioskop implements controller_bioskop{ 

    @Override
    public void simpan(Form_Bioskop bioskop) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "Insert Into siswa Values (?,?,?,?,?";
            PreparedStatement prepare = con.preparedStatement(sql);
            prepare.setString(1, bioskop.cbFilm.getSelectedItem());
            prepare.setString(2, bioskop.txtbangku.getText();
            prepare.setString(3, bioskop.chbFb1.getSelectedItem());
            prepare.setString(4, bioskop.chbFb2.getSelectedItem());
            prepare.setString(5, bioskop.txtharga.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil diSimpan");
            prepare.close();
            Baru(Bioskop);
        } catch (Exception e) {
            System.out.println (e);
        } finally {
            Tampil(Bioskop);
            siswa.setLebarKolom();
        }
    }
    
}
