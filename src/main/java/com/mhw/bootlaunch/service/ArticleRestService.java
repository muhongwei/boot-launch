package com.mhw.bootlaunch.service;

import com.mhw.bootlaunch.model.Article;

import java.util.List;

public interface ArticleRestService {

    Article saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}