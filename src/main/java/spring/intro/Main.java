package spring.intro;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.intro.config.AppConfig;
import spring.intro.model.User;
import spring.intro.service.UserService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User user = new User("oleh@ukr.net", "9807");
        userService.add(user);

        List<User> list = userService.listUsers();
        list.forEach(System.out::println);
    }
}
