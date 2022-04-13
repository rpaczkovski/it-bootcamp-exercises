package com.meli.articles.dao;

import com.meli.articles.domain.Article;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleDAO {
    private ElasticsearchRestTemplate elasticsearchTemplate;

    public List<Article> findAllWithRegex() {
                Query searchQuery = new NativeSearchQueryBuilder()
                .withFilter(QueryBuilders.regexpQuery("title", ".*"))
                .build();

        SearchHits<Article> results = elasticsearchTemplate.search(searchQuery, Article.class, IndexCoordinates.of("articles"));
        List<Article> articles = results.stream().map(result -> result.getContent()).collect(Collectors.toList());

        return articles;
    }

}
