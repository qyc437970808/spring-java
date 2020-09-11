package com.bia.web.service;

public class Animals {
    String name;
    int Age;
    public void setAge(int Age) {
        this.Age = Age;
    }
    public void setName(String name){
        this.name=name;
    }
    public int getAge(){
        return this.Age;
    }
    public String getName(){
        return this.name;
    }
}
