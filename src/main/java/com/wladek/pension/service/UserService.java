package com.wladek.pension.service;

import com.wladek.pension.domain.User;

/**
 * @author wladek
 */
public interface UserService {

    User addNewUser(User user);

    void login(User user);
}
