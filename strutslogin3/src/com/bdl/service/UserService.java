package com.bdl.service;

import com.bdl.domain.Users;
import com.bdl.utils.SqlHelper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by bdl19 on 2017/5/17.
 */
public class UserService {
    public boolean checkUser(Users users) {
        SqlHelper sh = new SqlHelper();
        Connection conn = sh.getConn();
        try {
            if(conn.isClosed()){
                System.out.println("11111111111111111111111111111111111111111111111111111111111111111111");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList result = new ArrayList();
        String sql = "select * from users where user_name='"+users.getUser_name()+"' and user_pwd='"+users.getUser_pwd()+"'";
        System.out.println(sql);

        try {
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery(sql);
            while(set.next()){
                Users user = new Users();
                user.setUser_name(set.getString("user_name"));
                result.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (result.size() == 1) {
            return true;
        }

        return false;
    }
}
