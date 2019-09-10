package com.mhw.bootlaunch.controller;

import com.mhw.bootlaunch.model.AjaxResponse;
import com.mhw.bootlaunch.model.Article;
import com.mhw.bootlaunch.service.ArticleRestService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;


@Slf4j
@Controller
@RequestMapping("/rest")
public class ArticleRestController {
    @Resource
    private ArticleRestService articleRestService;

    @ApiOperation(value = "添加文章", notes = "添加新的文章", tags = "Article",httpMethod = "POST")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    //@RequestMapping(value = "/article", method = POST, produces = "application/json")
    @PostMapping("/article")
    public @ResponseBody
    AjaxResponse saveArticle(@RequestBody Article article) {
    /*public @ResponseBody  AjaxResponse saveArticle(@RequestParam String  id,
                                                   @RequestParam String  author) {*/

        log.info("saveArticle：{}",article);
        log.info("articleRestService return :" + articleRestService.saveArticle(article));

        return  AjaxResponse.success(article);
    }
    @ApiOperation(value = "删除文章", notes = "删除文章", tags = "Article",httpMethod = "DELETE")
    @ApiResponses({
            @ApiResponse(code=200,message="成功",response=AjaxResponse.class),
            @ApiResponse(code=400,message="用户输入错误",response=AjaxResponse.class),
            @ApiResponse(code=500,message="系统内部错误",response=AjaxResponse.class)
    })
    //@RequestMapping(value = "/article/{id}", method = DELETE, produces = "application/json")
    @DeleteMapping("/article/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable Long id) {

        log.info("deleteArticle：{}",id);

        return AjaxResponse.success(id);
    }
 
    //@RequestMapping(value = "/article/{id}", method = PUT, produces = "application/json")
    @PutMapping("/article/{id}")
    public @ResponseBody AjaxResponse updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);

        log.info("updateArticle：{}",article);

        return AjaxResponse.success(article);
    }
 
    //@RequestMapping(value = "/article/{id}", method = GET, produces = "application/json")
    @GetMapping( "/article/{id}")
    public @ResponseBody  AjaxResponse getArticle(@PathVariable Long id) {

        Article article1 = Article.builder().id(1L).author("zimug").content("spring boot 2.深入浅出").createTime(new Date()).title("t1").build();
        return AjaxResponse.success(article1);
    }
}