package com.example.testeve.service;

import com.example.testeve.entity.User;
import com.example.testeve.view.DataView;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author 雨天留恋
 */
@Service
public class UserServiceImpl {

    public DataView<User> getUser() {
        ArrayList<String> courses = new ArrayList<>(8);
        courses.add("语文");
        User john = User.builder().id(1111).name("John").course("数学").list(courses).build();

        return DataView.<User>builder().data(john).build();
    }


}
