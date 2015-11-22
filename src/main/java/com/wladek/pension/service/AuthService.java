package com.wladek.pension.service;

import com.wladek.pension.domain.User;
import com.wladek.pension.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wladek
 */
@Service("authService")
@Transactional
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String loginIdOrEmail) throws UsernameNotFoundException {
        User user = userRepository.findByLoginId(loginIdOrEmail);
        if(user != null) {
            return new UserDetailsImpl(user);
        }
        user = userRepository.findByEmail(loginIdOrEmail);
        if(user != null) {
            return new UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException(loginIdOrEmail);
    }

}
