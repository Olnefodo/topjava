package ru.javawebinar.topjava.model;

/**
 * Created by Oleksandr on 15.12.15.
 */
public class NamedEntity extends BaseEntity{
    protected String name;
    public NamedEntity(){}
    protected NamedEntity(String name){ this.name = name; }
    protected void setName(String name){ this.name = name; }
    public String getName(){return this.name;}

    @Override
    public String toString(){return name;}
}
