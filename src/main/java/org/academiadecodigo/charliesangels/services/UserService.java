package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.exception.UserNotFoundException;
import org.academiadecodigo.charliesangels.models.Poll;
import org.academiadecodigo.charliesangels.models.User;

public interface UserService {

    User getUser(String username);

    User saveUser(User user);

    void deleteUser(String username) throws UserNotFoundException;

    Integer getPollId(String username);

}
