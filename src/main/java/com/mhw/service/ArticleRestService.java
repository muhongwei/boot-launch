package com.mhw.service;

import com.mhw.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ArticleRestService {

    public String saveArticle( Article article) {

        log.info("saveArticle：{}",article);

        return  "测试";
    }
}