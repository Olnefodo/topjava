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

    public User (String name, String email, String password, Role role, Role... roles){
        super(name);
        this.email = email;
        this.password = password;
        this.enabled = true;
        this.authorities = EnumSet.of(role, roles);
    }



}
