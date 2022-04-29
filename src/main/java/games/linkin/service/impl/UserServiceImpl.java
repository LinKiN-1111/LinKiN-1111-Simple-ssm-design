package games.linkin.service.impl;

import games.linkin.dao.UserDao;
import games.linkin.pojo.User;
import games.linkin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public User selectUser(User user) {
        User userResult = userDao.selectUser(user);
        return userResult;
    }
}
