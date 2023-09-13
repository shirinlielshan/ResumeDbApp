/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserDaoInter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghost
 */
public class UserDaoImpl extends AbstractDAO implements UserDaoInter {

    
    @Override
    public List<User> getAllUsers() {
        List<User> resultList = new ArrayList<>();
        String query = "select * from users;";
        try(Statement stmt = connect().createStatement();){
            ResultSet resultSet = stmt.executeQuery(query);

            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Email = resultSet.getString("Email");
                String PhoneNumber = resultSet.getString("PhoneNumber");
                String Address = resultSet.getString("Address");
                String ProfileDescription = resultSet.getString("ProfileDescription");
                Date Birthdate = resultSet.getDate("Birthdate");
                int country = resultSet.getInt("country");
                resultList.add(new User(Id,FirstName, LastName, Email, PhoneNumber, Address, ProfileDescription, Birthdate, country));
            }
            connect().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public User getById(int i) {
        User u = null;
        String query = "select * from users where id = ?;";
        try(PreparedStatement pstmt = connect().prepareStatement(query);){
            pstmt.setInt(1, i);
            ResultSet resultSet = pstmt.executeQuery();
            while(resultSet.next()){
                int Id = resultSet.getInt("Id");
                String FirstName = resultSet.getString("FirstName");
                String LastName = resultSet.getString("LastName");
                String Email = resultSet.getString("Email");
                String PhoneNumber = resultSet.getString("PhoneNumber");
                String Address = resultSet.getString("Address");
                String ProfileDescription = resultSet.getString("ProfileDescription");
                Date Birthdate = resultSet.getDate("Birthdate");
                int country = resultSet.getInt("country");
                u = new User(Id,FirstName, LastName, Email, PhoneNumber, Address, ProfileDescription, Birthdate, country);
            }
            connect().close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }

    @Override
    public boolean addUser(User u) {
        String query = "INSERT INTO users(FirstName, LastName, Email, PhoneNumber) VALUES(?, ?, ?, ?);";
        try(PreparedStatement pstmt = connect().prepareStatement(query);){
            pstmt.setString(1, u.getFirstname());
            pstmt.setString(2, u.getLastname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());
            return pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean updateUser(User u) {
        try(PreparedStatement pstmt = connect().prepareStatement("UPDATE users SET FirstName = ?, LastName = ?, Email = ?, PhoneNumber = ?, Address = ?, ProfileDescription = ?, Birthdate = ?, Country = ? WHERE ID = ?;")){
            pstmt.setString(1, u.getFirstname());
            pstmt.setString(2, u.getLastname());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getPhone());
            pstmt.setString(5, u.getAddress());
            pstmt.setString(6, u.getProfileDescription());
            if(u.getBirthDate() != null){
                pstmt.setDate(7, u.getBirthDate());
            }
            else{
                pstmt.setDate(7, null);
            }
            
            pstmt.setInt(8, u.getCountry());
            
            pstmt.setInt(9, u.getId());
            return pstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeUser() {
        try(Statement stmt = connect().createStatement()){
            String query = "DELETE FROM users WHERE ID = 1;";
            return stmt.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
