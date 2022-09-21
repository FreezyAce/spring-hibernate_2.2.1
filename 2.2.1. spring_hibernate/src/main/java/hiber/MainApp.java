package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("nissan", 322);
      Car car2 = new Car("lada", 228);
      Car car3 = new Car("renno", 122);
      Car car4 = new Car("mersedes", 777);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }

//      List<Car> cars = userService.listCar();
//      for (Car car : cars) {
//         System.out.println(car.toString());
//      }

      System.out.println(userService.getUserByModelAndSeries("nissan", 322).toString());

      context.close();
   }
}
