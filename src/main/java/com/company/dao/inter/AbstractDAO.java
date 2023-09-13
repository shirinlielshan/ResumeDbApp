/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ghost
 */
public class AbstractDAO {//data access object
    public static Connection connect() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "root";
        String password = "12345";
        Connection conn = DriverManager.getConnection(url,username,password);
        return conn;
    } 
}
