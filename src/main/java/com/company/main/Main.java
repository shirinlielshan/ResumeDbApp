package com.company.main;

import com.company.dao.impl.*;
import com.company.dao.inter.*;
import com.company.entity.User;

public class Main {
    public static void main(String[] args){
        UserDaoInter userDao = new UserDaoImpl();
        SkillDaoInter skillDao = new SkillDaoImpl();
        
        
        User user = new User("Nurlan", "Beshirli", "nurlan.beshirli@gmail.com", "994771234455");
        System.out.println(userDao.getAllUsers());
        
    }

}