package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {

    User findByCar(String model, int series);

    List<User> listUsers();

    void add(User user);
}
