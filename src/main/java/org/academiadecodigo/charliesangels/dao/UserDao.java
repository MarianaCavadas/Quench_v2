package org.academiadecodigo.charliesangels.dao;

import org.academiadecodigo.charliesangels.models.User;

public interface UserDao extends Dao<User> {

    User findByUsername(String userName);

}
