package service;

import domain.User;

import java.util.List;

public interface UserService {
    /**
     *
     * @return
     */
    public List<User> findAll();
    public void add(User user);
    public void del(int id);
    public User findById(int id);
    public void update(User user);

}
