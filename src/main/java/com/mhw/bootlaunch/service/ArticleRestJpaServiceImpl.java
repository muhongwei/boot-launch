package com.mhw.bootlaunch.service;

import com.mhw.bootlaunch.jpa.testdb.Article;
import com.mhw.bootlaunch.jpa.testdb.ArticleRepository;
import com.mhw.bootlaunch.jpa.testdb2.Message;
import com.mhw.bootlaunch.jpa.testdb2.MessageRepository;
import com.mhw.bootlaunch.model.ArticleVO;
import com.mhw.bootlaunch.utils.DozerUtils;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ArticleRestJpaServiceImpl implements ArticleRestService{

    @Resource
    private ArticleRepository articleRepository;
    @Resource
    private MessageRepository messageRepository;

    @Resource
    private Mapper dozerMapper;

    @Transactional
    @Override
    public ArticleVO saveArticle( ArticleVO article) {

        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
        Message message = new Message();
        message.setName("kobe");
        message.setContent("退役了");
        messageRepository.save(message);
        int a = 2 / 0;
        return  article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(ArticleVO article) {
        Article articlePO = dozerMapper.map(article,Article.class);
        articleRepository.save(articlePO);
    }

    @Override
    public ArticleVO getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return dozerMapper.map(article.get(),ArticleVO.class);
    }

    @Override
    public List<ArticleVO> getAll() {
        List<Article> articleLis = articleRepository.findAll();

        return DozerUtils.mapList(articleLis,ArticleVO.class);

    }
}