package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.exception.UserNotFoundException;
import org.academiadecodigo.charliesangels.models.Poll;
import org.academiadecodigo.charliesangels.models.User;

public interface UserService {

    /**
     *
     * @param id
     * @return
     */
    User getUser(Integer id);

    /**
     *
     * @param user
     */
    User saveUser(User user);

    /**
     *
     * @param id
     */
    void deleteUser(Integer id) throws UserNotFoundException;

    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);

    /**
     *
     * @param id of user
     * @return id of the poll
     */
    Integer getPollId(Integer id);

}
