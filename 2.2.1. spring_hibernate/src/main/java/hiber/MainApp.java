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

      userService.add(new User("Diego", "Maradona", "Diego@gmail.com", new Car("Porsche", 924)));
      userService.add(new User("Lionel", "Messi", "Leo@gmail.com", new Car("Ferrari", 335)));
      userService.add(new User("Paolo", "Maldini", "Maldini@milan.com", new Car("Maserati", 3200)));
      userService.add(new User("Gianluigi", "Buffon", "Buff@gmail.com", new Car("Fiat", 500)));


      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car model = " + user.getCar().getModel());
         System.out.println("Car series = " + user.getCar().getSeries());
         System.out.println();
      }

      context.close();
   }
}
