package com.meli.articles.service;

import com.meli.articles.domain.Article;
import com.meli.articles.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    private ArticleRepository repository;

    @Override
    public void insert(Article article) {
        repository.save(article);
    }

    @Override
    public List<Article> findAll() {
        List<Article> articles = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(articles::add);
        return articles;
    }

    @Override
    public List<Article> findByTitle(String title) {
        return repository.findByTitle(title);
    }

}
