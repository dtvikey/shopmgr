package com.imooc.shop.repository;


import com.imooc.shop.bean.Article;

import java.util.List;

/**
 * ArticleMapper 数据访问类
 */
public interface ArticleMapper {


    List<Article> searchArticles();

}