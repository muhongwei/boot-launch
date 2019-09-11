package com.mhw.bootlaunch.service;

import com.mhw.bootlaunch.dao.ArticleJDBCDAO;
import com.mhw.bootlaunch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleRestJDBCServiceImpl implements ArticleRestService{


    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Transactional
    @Override
    public Article saveArticle(Article article) {

        log.info("saveArticle：{}",article);
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);
        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id, primaryJdbcTemplate);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateById(article, primaryJdbcTemplate);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id, primaryJdbcTemplate);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(primaryJdbcTemplate);
    }
}