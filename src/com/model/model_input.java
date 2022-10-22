/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

import com.controller.controller_input;
import com.koneksi.koneksi_bioskop;
import com.view.input_Film;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class model_input implements controller_input{

    @Override
    public void Simpan(input_Film inpt) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "INSERT INTO film VALUES(?,?,?)";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, inpt.txtKdFilm.getText());
            stt.setString(2, inpt.txtJudul.getText());
            stt.setString(3, inpt.txtHarga.getText());
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di input");
            stt.close();
            Baru(inpt);
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Tampil(inpt);
            inpt.setLebarKolom();
        }
    }

    @Override
    public void Ubah(input_Film inpt) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "UPDATE film SET judul=?, harga=? WHERE kode_film=?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(3, inpt.txtKdFilm.getText());
            stt.setString(1, inpt.txtJudul.getText());
            stt.setString(2, inpt.txtHarga.getText());
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di ubah");
            stt.close();
            Baru(inpt);
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Tampil(inpt);
            inpt.setLebarKolom();
        }
    }

    @Override
    public void Hapus(input_Film inpt) throws SQLException {
        try {
            Connection con = koneksi_bioskop.getcon();
            String sql = "DELETE FROM film WHERE kode_film=?";
            PreparedStatement stt = con.prepareStatement(sql);
            stt.setString(1, inpt.txtKdFilm.getText());
            stt.executeUpdate();
            JOptionPane.showMessageDialog(null, "data berhasil di hapus");
            stt.close();
            Baru(inpt);
        } catch (Exception e) {
            System.out.println(e);
        } finally{
            Tampil(inpt);
            inpt.setLebarKolom();
        }
    }

    @Override
    public void Baru(input_Film inpt) throws SQLException {
        inpt.txtKdFilm.setText("");
        inpt.txtJudul.setText("");
        inpt.txtHarga.setText("");
    }

    @Override
    public void Tampil(input_Film inpt) throws SQLException {
        inpt.tblmodel.getDataVector().removeAllElements();
        inpt.tblmodel.fireTableDataChanged();
        try {
            Connection con = koneksi_bioskop.getcon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM film ORDER BY kode_film ASC";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {                
                Object[] ob = new Object[5];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                inpt.tblmodel.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void KlikTable(input_Film inpt) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
