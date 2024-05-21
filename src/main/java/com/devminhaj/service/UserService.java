package com.devminhaj.service;

import com.devminhaj.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//as this is a service class, we can create a singleton object of this using @Service
@Service
public class UserService {
    private List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(user);
    }

    public List<User> getUserList(){
        return userList;
    }
}
