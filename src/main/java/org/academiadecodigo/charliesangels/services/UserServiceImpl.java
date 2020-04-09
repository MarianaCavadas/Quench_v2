package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.exception.UserNotFoundException;
import org.academiadecodigo.charliesangels.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService{

    private Map<String, User> users = new HashMap<>();

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public User getUser(String username) {
        return users.get(username);
    }

    @Override
    public User saveUser(User user) {
        String username = user.getUsername();
        return users.put(username, user);
    }

    @Override
    public void deleteUser(String username) throws UserNotFoundException {
        User user = users.get(username);

        if(user == null) {
            throw new UserNotFoundException();
        }
        users.remove(username, user);
    }

    @Override
    public Integer getPollId(String username) {
        User user = users.get(username);
        return user.getPoll().getId();
    }
}
