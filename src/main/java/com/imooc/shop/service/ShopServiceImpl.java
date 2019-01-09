package com.imooc.shop.service;

import com.imooc.shop.bean.ArticleType;
import com.imooc.shop.repository.ArticleTypeMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: dtvikey
 * @Date: 09/01/19 下午 02:55
 * @Version 1.0
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService{
    // 得到数据访问层对象
    @Resource
    private ArticleTypeMapper articleTypeMapper;


    public List<ArticleType> getArticleTypes() {
        return articleTypeMapper.getArticleTypes();
    }
}
