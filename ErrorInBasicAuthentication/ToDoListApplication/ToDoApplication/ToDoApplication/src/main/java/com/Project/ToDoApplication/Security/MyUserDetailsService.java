package com.Project.ToDoApplication.Security;

import com.Project.ToDoApplication.Security.model.Users;
import com.Project.ToDoApplication.Security.model.UserPrinciple;
import com.Project.ToDoApplication.Security.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user != null) {
            System.out.println("User Doesnot exists...");
            return null;
        } else {
            return new UserPrinciple(user);
        }


    }

    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    public Users toRegister(Users user) {
        user.setPassword(bCryptPasswordEncoder().encode(user.getPassword()));
        return repo.save(user);
    }
}
