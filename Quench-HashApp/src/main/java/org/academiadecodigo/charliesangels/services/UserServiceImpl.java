package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.dao.UserDao;
import org.academiadecodigo.charliesangels.exception.UserNotFoundException;
import org.academiadecodigo.charliesangels.models.Poll;
import org.academiadecodigo.charliesangels.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUser(Integer id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User saveUser(User user) {
        return userDao.saveOrUpdate(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) throws UserNotFoundException {
        User user = userDao.findById(id);

        if(user == null) {
            throw new UserNotFoundException();
        }

        userDao.delete(id);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public Integer getPollId(Integer id) {
        return userDao.findById(id).getPoll().getId();
    }
}
