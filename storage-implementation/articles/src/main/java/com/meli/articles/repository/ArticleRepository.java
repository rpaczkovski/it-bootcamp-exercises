package com.meli.articles.repository;

import com.meli.articles.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, String> {
    List<Article> findByTitle(String title);
}
