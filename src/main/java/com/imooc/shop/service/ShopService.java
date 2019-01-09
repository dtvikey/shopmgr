package com.imooc.shop.service;

import com.imooc.shop.bean.ArticleType;

import java.util.List;
import java.util.Map;

/**
 * @Author: dtvikey
 * @Date: 09/01/19 下午 02:54
 * @Version 1.0
 */
public interface ShopService {
    List<ArticleType> getArticleTypes();
    Map<String,Object> login(String loginName, String passWord);

}
