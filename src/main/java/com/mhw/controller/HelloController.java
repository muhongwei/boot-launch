package com.mhw.controller;

import com.mhw.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author MuHongwei
 * @date 2019/9/10
 */
@RestController
@Slf4j
public class HelloController {
    //private static final Logger log = LoggerFactory.getLogger(HelloController.class);
    @RequestMapping("/hello")
    public Article hello(){
        Article article = new Article(1L, "mhw");
        Article article1 = Article.builder().id(2L).author("mhw").build();
        log.info("测试一下" + article1);
        return article1;
    }
}
