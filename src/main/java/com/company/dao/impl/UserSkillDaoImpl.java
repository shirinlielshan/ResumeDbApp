/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.dao.impl;

import com.company.entity.User;
import com.company.dao.inter.AbstractDAO;
import static com.company.dao.inter.AbstractDAO.connect;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.UserSkill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ghost
 */
public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

    public UserSkill getUserSkill(ResultSet rs) throws SQLException {

        int id = rs.getInt("id");

        int userId = rs.getInt("user_id");
        int skill_id = rs.getInt("skill_id");
        String skill_name = rs.getString("skill_name");
        
        int power = rs.getInt("power");
        UserSkill us = new UserSkill(id, new User(userId), new Skill(skill_id, skill_name), power);
        return us;

    }

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> list = new ArrayList<>();
        Connection conn;
        try {
            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("SELECT "
                    + " us.id as id,"
                    + " u.id user_id,"
                    + " us.skill_id,s.name AS skill_name ,"
                    + " us.power "
                    + " FROM "
                    + " user_skill us "
                    + " LEFT JOIN users u ON us.user_id = u.id "
                    + " LEFT JOIN skill s ON us.skill_id = s.id "
                    + " WHERE us.user_id = ? ");
            stmt.setInt(1, id);
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {

                UserSkill us = getUserSkill(rs);
                list.add(us);

            }
        } catch (Exception ex) {

        }
        return list;
    }

    public boolean insertUserSkill(UserSkill u) {
        Connection conn;
        boolean b = true;
        try {
            conn = connect();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO user_skill (skill_id , user_id ,power) VALUES (? , ? ,  ? ) ;");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    public boolean updateUserSkill(UserSkill u) {
        Connection conn;
        boolean b = true;
        try {
            conn = connect();
            PreparedStatement stmt = conn.prepareStatement("UPDATE user_skill SET skill_id = ? , user_id =? ,power =?  WHERE id = ? ;");

            stmt.setInt(1, u.getSkill().getId());
            stmt.setInt(2, u.getUser().getId());
            stmt.setInt(3, u.getPower());

            stmt.setInt(4, u.getId());

            b = stmt.execute();

        } catch (Exception ex) {
            System.err.println(ex);
            b = false;
        }
        return b;
    }

    @Override
    public boolean removeUserSkill(int id) {
        Connection conn;
        try {
            conn = connect();

            PreparedStatement stmt = conn.prepareStatement("DELETE FROM user_skill  WHERE ID=?;");
            stmt.setInt(1, id);
            System.out.println("id :" + String.valueOf(id));
            return stmt.execute();

        } catch (Exception ex) {
            System.out.println(ex);
            return false;
        }
    }
}
