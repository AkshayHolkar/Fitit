package com.example.user.fitit;

public class User {
    String userId;
    String name;
    int age;
    int height;
    public User(){

    }

    public User(String userId, String name, int age, int height) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.height = height;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }
}
