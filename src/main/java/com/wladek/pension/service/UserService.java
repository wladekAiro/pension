package com.wladek.pension.service;

import com.wladek.pension.domain.User;

import java.util.List;

/**
 * @author wladek
 */
public interface UserService {

    User addNewUser(User user);

    void login(User user);

    public List<User> findAll();
}
