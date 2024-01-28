package com.example.seminar4spring;


public class User {
    private  final Long id;
    private  final int age;
    private  final String name;
    private  final String email;

    public User(Long id, String name, String email, int age) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
    }

    public String toMyString(){
        return "ID:"+this.id+" Имя:"+this.name+" почта:"+this.email+" Возр.:"+this.age;
    }
    public int getAge() {
        return age;
    }
    public Long getId() {
        return id;

    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }


}
