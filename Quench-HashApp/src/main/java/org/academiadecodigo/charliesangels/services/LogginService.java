package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.User;

public interface LogginService {

    /**
     *
     * @param username
     * @param password
     * @return
     */
    boolean authenticate(String username, String password);

    /**
     *
     * @return
     */
    User getAccessingUser();
}
