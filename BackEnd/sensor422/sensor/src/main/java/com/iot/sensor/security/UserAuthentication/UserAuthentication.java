package com.iot.sensor.security.UserAuthentication;

import com.iot.sensor.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.security.auth.Subject;
import java.util.Collection;

public class UserAuthentication implements Authentication {
    private boolean authenticated;
    private User user;
    private Collection<? extends GrantedAuthority> authorities;


    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getDetails() {
        return user;
    }

    @Override
    public  Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return user;
    }

    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    @Override
    public void setAuthenticated(boolean var1) {
        this.authenticated = var1;
    }
}
