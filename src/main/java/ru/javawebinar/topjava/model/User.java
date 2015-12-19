package ru.javawebinar.topjava.model;

import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by Oleksandr on 15.12.15.
 */
public class User extends NamedEntity {

    private String email;

    private String password;

    private boolean enabled = true;

    private Date registered = new Date();

    private Set<Role> authorities;

    public User(){}

    public User (Integer id, String name, String email, String password, Role role){
        super(name);
        this.id = id;
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.authorities.add(role);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User (" +
                "name=" + name +
                ", email=" + email +
                ", password=" + password +
                ", enabled=" + enabled +
                ", registered=" + registered +
                ')';
    }

}
