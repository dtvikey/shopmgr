package com.imooc.shop.repository;

import com.imooc.shop.bean.ArticleType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * ArticleTypeMapper 数据访问类
 */
public interface ArticleTypeMapper {

    @Select("select * from ec_article_type")
    List<ArticleType> getArticleTypes();

}