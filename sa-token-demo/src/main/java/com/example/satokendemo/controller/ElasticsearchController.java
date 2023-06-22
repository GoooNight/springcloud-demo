package com.example.satokendemo.controller;

import com.example.satokendemo.entity.Book;
import com.example.satokendemo.service.BooKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 雨天留恋
 * @date 2023-06-12 19:32
 */
@RestController
public class ElasticsearchController {

    @Autowired
    private BooKService booKService;

    @PostMapping("save")
    public Book save(@RequestBody Book book) {
        return booKService.save(book);
    }

    @GetMapping("search")
    public Book searchWithId(String id) {
        return booKService.searchById(id);
    }

}
