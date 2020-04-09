package org.academiadecodigo.charliesangels.services;

import org.academiadecodigo.charliesangels.models.User;
import org.academiadecodigo.charliesangels.utils.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogginServiceImpl implements LogginService{

    private UserService userService;
    private User accessingUser;

    /**
     * Get userService
     *
     * @return userService
     */
    public UserService getUserService() {
        return userService;
    }

    /**
     * set the userService
     * @param userService
     */
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public boolean authenticate(String username, String password) {

        User user = userService.getUserByUsername(username);

        if(user == null) {
            return false;
        }
        if(!user.getPassword().equals(Security.getHash(password))) {
            return false;
        }

        accessingUser = user;
        return true;
    }

    /**
     * Get actual accessingCustomer
     *
     * @return
     */
    @Override
    public User getAccessingUser() {
        return accessingUser;
    }
}
