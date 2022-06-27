package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {

    User findByCar(String model, int series);

    List<User> listUsers();

    void add(User user);
}
