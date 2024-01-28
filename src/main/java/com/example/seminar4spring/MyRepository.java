package com.example.seminar4spring;


import java.util.ArrayList;
public class MyRepository {
    private  ArrayList<User> users = new ArrayList<>();
    private Long maxId;
    public MyRepository() {
        this.maxId = 0L;
    }
    public ArrayList<User> complete(){
        String[] names = {"Ivan","Petr","Sergey","Andrey","Olga","Elena","Victoria","Nina"};
        String[] emails = {"ivan@mail.ru","petr@gmail.ru","sergey@yandex.ru","andrey@bk.ru"
                ,"olga@mail.ru","elena@gmail.ru","victoria@yandex.ru","nina@bk.ru"};
        int[] ages = {21,20,19,18,25,24,23,22};
        for (int i = 0; i < names.length; i++) {
            this.maxId = maxId+1;
            this.users.add(new User(maxId,names[i], emails[i], ages[i]));
        }
    return this.users;
    }
    public User getUserFromId(Long id){
        return users.stream().filter(it -> it.getId().equals(id)).findFirst().orElse(null);
    }

    public Long getMaxId() {
        return maxId;
    }

    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

}
