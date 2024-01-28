package com.example.seminar4spring;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyService {
    private final MyRepository myRepository = new MyRepository();
    private final UserNotification notification = new UserNotification();
    public List<User> getList(){
        notification.getLog("Возвращен список пользователей");
        return myRepository.getUsers();
    }
    public List<User> sortByAge(){
        notification.getLog("Возвращен отсортированный по возрасту список пользователей");

        return myRepository.getUsers().stream()
                .sorted(Comparator.comparingInt(User::getAge)).collect(Collectors.toList());
    }
    public List<User> filterByAge(int age){
        notification.getLog("Возвращен отфильтрованный по возрасту(старше "+age+") список пользователей");
        return myRepository.getUsers().stream()
                .filter(it ->it.getAge()>age).collect(Collectors.toList());
    }
    public Double getMiddleAge(){
        notification.getLog("Возвращен средний возраст пользователей");
        return myRepository.getUsers().stream()
                .mapToInt(it->it.getAge())
                .average().orElse(0);
    }
    public User createUser(String name, String email, int age){
        User user = new User(myRepository.getMaxId()+1, name, email, age);
        myRepository.getUsers().add(user);
        myRepository.setMaxId(myRepository.getMaxId()+1);
        notification.getLog("Возвращен созданный пользователь :\n    "+user.toMyString());
        return user;
    }
    public List<User> complete(){
        notification.getLog("Возвращен созданный \"шаблонный\" список пользователей");
        return myRepository.complete();
    }
    public List<String> getNotes(){
        notification.getLog("Возвращен список совершенных действий");
        return notification.getNotifications();
    }
    public User getUserFromId(Long id){
        notification.getLog("В динамическую стр.HTML возвращен пользователь с ID : "+id);
        return myRepository.getUserFromId(id);
    }

}
