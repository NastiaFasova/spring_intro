package spring.intro.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.intro.dao.UserDao;
import spring.intro.model.User;
import spring.intro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public User get(Long userId) {
        return userDao.get(userId);
    }
}
