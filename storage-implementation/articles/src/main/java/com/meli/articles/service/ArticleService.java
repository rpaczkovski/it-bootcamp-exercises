package com.meli.articles.service;

import com.meli.articles.domain.Article;

import java.util.List;

public interface ArticleService {
    void insert(Article article);
    List<Article> findAll();
    List<Article> findByTitle(String title);
}
