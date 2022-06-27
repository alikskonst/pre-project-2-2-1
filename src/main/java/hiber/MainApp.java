package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws SQLException {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        CarService carService = context.getBean(CarService.class);

        Car car1 = carService.save(new Car("model1", 1));
        Car car2 = carService.save(new Car("model2", 2));
        Car car3 = carService.save(new Car("model3", 3));

        User user1 = new User("user1", "lastname1", "user1@mail.ru");
        user1.setCar(car1);
        userService.add(user1);

        User user2 = new User("user2", "lastname2", "user2@mail.ru");
        user2.setCar(car2);
        userService.add(user2);

        User user3 = new User("user3", "lastname3", "user3@mail.ru");
        user3.setCar(car3);
        userService.add(user3);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel() + "/" + user.getCar().getSeries());
            System.out.println();
        }

        context.close();
    }
}
