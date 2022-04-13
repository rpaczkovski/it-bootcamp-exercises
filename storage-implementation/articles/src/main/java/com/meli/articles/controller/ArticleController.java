package com.meli.articles.controller;

import com.meli.articles.domain.Article;
import com.meli.articles.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArticleController {

    private ArticleService service;

    @PostMapping
    private @ResponseBody String save(@RequestBody Article request) {
        service.insert(request);
        return "The article was created";
    }

    @GetMapping
    private List<Article> getAll(@RequestParam(required = false) String title) {
        if(title != null) {
            return service.findByTitle(title);
        }
        return service.findAll();
    }



}
