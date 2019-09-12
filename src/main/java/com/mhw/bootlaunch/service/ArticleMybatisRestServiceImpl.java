package com.mhw.bootlaunch.service;

import com.mhw.bootlaunch.generator.testdb.Article;
import com.mhw.bootlaunch.generator.testdb.ArticleMapper;
import com.mhw.bootlaunch.generator.testdb2.Message;
import com.mhw.bootlaunch.generator.testdb2.MessageMapper;
import com.mhw.bootlaunch.model.ArticleVO;
import com.mhw.bootlaunch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class ArticleMybatisRestServiceImpl implements ArticleRestService{

    @Resource
    protected Mapper dozerMapper;

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private MessageMapper messageMapper;


    @Override
    public ArticleVO saveArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article, Article.class);
        articleMapper.insert(articlePO);
        Message message = new Message();
        message.setName("curry");
        message.setContent("cool");
        messageMapper.insert(message);
        return null;
    }

    @Override
    public void deleteArticle(Long id) {
        articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleMapper.updateByPrimaryKeySelective(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        return dozerMapper.map(articleMapper.selectByPrimaryKey(id),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articles = articleMapper.selectByExample(null);
        return DozerUtils.mapList(articles,ArticleVO.class);

    }
}