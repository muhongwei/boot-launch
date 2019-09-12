package com.mhw.bootlaunch.jpa;

import com.mhw.bootlaunch.dao.Article;
import com.mhw.bootlaunch.dao.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;
    
    @Test
    public void userTest() {
        List<Article> articles = articleRepository.findByAuthor("mhw");
        System.out.println(articles);
    }

}