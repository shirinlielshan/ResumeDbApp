/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.inter;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author ghost
 */
public interface UserDaoInter {
     
    List<User> getAllUsers();
    User getById(int i);
    boolean addUser(User u);
    boolean updateUser(User u);
    boolean removeUser();

    }
