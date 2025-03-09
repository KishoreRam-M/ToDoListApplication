package com.Project.ToDoApplication.Security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class UserPrinciple implements UserDetails
{
    private  String name;
    private  String password;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public String getPassword() {
        return  getUsername();
    }

    @Override
    public String getUsername() {
        return getPassword();
    }
    public  UserPrinciple(Users user)
    {
        this.password=getPassword();
        this.name=getUsername();
    }
}
