package spring.intro.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.intro.dto.UserResponseDto;
import spring.intro.model.User;
import spring.intro.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/inject")
    public String injectUser() {
        User bob = new User();
        bob.setEmail("bob");
        bob.setPassword("1111");
        userService.add(bob);

        User alice = new User();
        alice.setEmail("alice");
        alice.setPassword("1111");
        userService.add(alice);

        User john = new User();
        john.setEmail("john");
        john.setPassword("1111");
        userService.add(john);

        User frank = new User();
        frank.setEmail("frank");
        frank.setPassword("1111");
        userService.add(frank);
        return "Four users were successfully injected";
    }

    @GetMapping("/{userId}")
    public UserResponseDto get(@PathVariable Long userId) {
        User user = userService.get(userId);
        return getDto(user);
    }

    @GetMapping("/")
    public List<UserResponseDto> getAll() {
        List<User> users = userService.listUsers();
        List<UserResponseDto> usersDto = new ArrayList<>();
        for (User user : users) {
            usersDto.add(getDto(user));
        }
        return usersDto;
    }

    public UserResponseDto getDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
