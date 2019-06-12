package com.test.dao.impl;

import com.test.dao.UserDao;
import com.test.domain.User;
import com.test.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate mytemplate =new JdbcTemplate(JDBCUtils.getDs());
    @Override
    public List<User> findAll() {
        String sql ="select * from userinf";
        List<User> list = mytemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public void add(User user) {

        String sql ="insert into userinf values(null,?,?,?,?,?,?, null,null)";
        mytemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress()
        ,user.getQq(),user.getEmail());
    }

    @Override
    public void del(int id) {
        String sql ="delete from userinf where id=?";
        mytemplate.update(sql,id);
    }

    @Override
    public User findById(int id) {
        String sql ="select * from userinf where id=?";
        return mytemplate.queryForObject(sql,  new BeanPropertyRowMapper<User>(User.class),id);
    }

    @Override
    public void update(User user) {
        String sql ="update userinf set name=?,gender=?,age=?,address=?,qq=?,email=? where id =?";
        mytemplate.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }
}
