package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;

import java.util.Set;

/**
 * Created by Oleksandr on 15.12.15.
 */
public class LoggedUser {
    protected int id;
    protected Set<Role> roles;
    protected boolean enabled;

    public int getId(){
        return id;
    }


}
