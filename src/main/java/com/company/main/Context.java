package com.company.main;

import com.company.dao.impl.*;
import com.company.dao.inter.*;

public class Context {
    public static UserDaoInter instanceOfUserDao(){
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceOfUserSkill(){
        return new UserSkillDaoImpl();
    }
    public static CountryDaoInter instanceOfCountryDao(){
        return new CountryDaoImpl();
    }

    public static SkillDaoInter instanceOfSkillDao(){
        return new SkillDaoImpl();
    }
}