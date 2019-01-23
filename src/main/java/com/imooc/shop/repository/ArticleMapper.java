package com.imooc.shop.repository;


import com.imooc.shop.bean.Article;
import com.imooc.shop.utils.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ArticleMapper 数据访问类
 */
public interface ArticleMapper {


    List<Article> searchArticles(@Param("typeCode") String typeCode,
                                 @Param("secondType") String secondType,
                                 @Param("title") String title,
                                 @Param("pager") Pager pager);

}