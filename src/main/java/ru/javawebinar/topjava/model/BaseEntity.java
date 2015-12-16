package ru.javawebinar.topjava.model;

/**
 * Created by Oleksandr on 15.12.15.
 */
public class BaseEntity {
    protected Integer id;
    public void setId(Integer id) {this.id = id;}

    public Integer getId() {
        return id;
    }
    public void setId(int id){ this.id = id; }
    public boolean isNew(){
        return (this.id == null);
    }
}
