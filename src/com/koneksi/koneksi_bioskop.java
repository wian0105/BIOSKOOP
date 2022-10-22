/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.koneksi;

import java.sql.*;

/**
 *
 * @author USER
 */
public class koneksi_bioskop {   
    private static Connection con;
    public static Connection getcon() {
            if (con == null) {
                try {
                    String url = "jdbc:mysql://192.168.43.58/biaoskop";
                    String username = "test";
                    String password = "123";
                    DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                    con = DriverManager.getConnection(url, username , password);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        return con;
}
}
