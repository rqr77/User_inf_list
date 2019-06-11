package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    public List<User> findAll();
    public void add(User user);
    public void del(int id);
    public User findById(int id);
    public void update(User user);
}
