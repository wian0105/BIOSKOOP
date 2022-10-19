/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controller;
import java.sql.*;
import com.view.input_Film;
/**
 *
 * @author USER
 */
public interface controller_input {
    public void Simpan(input_Film inpt) throws SQLException;
    public void Ubah(input_Film inpt) throws SQLException;
    public void Hapus(input_Film inpt) throws SQLException; 
    public void Baru(input_Film inpt) throws SQLException; 
    public void Tampil(input_Film inpt) throws SQLException; 
    public void KlikTable(input_Film inpt) throws SQLException; 
}
