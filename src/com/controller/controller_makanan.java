/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.controller;
import java.sql.*;
import com.view.input_makanan;
/**
 *
 * @author USER
 */
public interface controller_makanan {
    public void Simpan(input_makanan inpt) throws SQLException;
    public void Ubah(input_makanan inpt) throws SQLException;
    public void Hapus(input_makanan inpt) throws SQLException; 
    public void Baru(input_makanan inpt) throws SQLException; 
    public void Tampil(input_makanan inpt) throws SQLException; 
    public void KlikTable(input_makanan inpt) throws SQLException; 
}
