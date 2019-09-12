package com.mhw.bootlaunch.controller;

import com.mhw.bootlaunch.model.ArticleVO;
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
    public ArticleVO hello(){
//        Article article = new Article(1L, "mhw");
        ArticleVO article1 = ArticleVO.builder().id(2L).author("mhw").build();
        log.info("测试一下" + article1);
        return article1;
    }
}
