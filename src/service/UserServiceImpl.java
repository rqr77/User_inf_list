package service;

import dao.Userdata;
import domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private Userdata userdata=new Userdata();
    @Override
    public List<User> findAll() {
        //完成dao层

        return userdata.findAll();
    }

    @Override
    public void add(User user) {
        userdata.add(user);
    }
    @Override
    public void del(int id) {
        userdata.del(id);
    }
    @Override
    public User findById(int id) {
        return userdata.findById(id);
    }
    public void update(User user){
        userdata.update(user);
    }

}
