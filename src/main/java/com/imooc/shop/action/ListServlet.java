package com.imooc.shop.action;

import com.imooc.shop.bean.Article;
import com.imooc.shop.bean.ArticleType;
import com.imooc.shop.service.ShopService;
import com.imooc.shop.utils.Pager;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@MultipartConfig // 申明这个Servlet是要接收大文件对象的
@WebServlet("/list")
public class ListServlet extends HttpServlet {

    // 定义业务层对象
    private ShopService shopService;

    private HttpServletRequest request;
    private HttpServletResponse response ;

    @Override
    public void init() throws ServletException {
        super.init();
        // 获取sping的容器。然后从容器中得到业务层对象
        ServletContext servletContext = this.getServletContext() ;
        WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        shopService = (ShopService) context.getBean("shopService");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{

            this.request = req;
            this.response = resp;

           String method = req.getParameter("method");
           switch (method){
               case "getAll":
                   getAll();
                   break;
           }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getAll() throws ServletException, IOException {
        //接收一级类型编号查询
        String typeCode = request.getParameter("typeCode");

        //根据一级类型查询对应的二级类型
        if(!StringUtils.isEmpty(typeCode)){
            List<ArticleType> secondTypes = shopService.loadSecondTypes(typeCode);
            request.setAttribute("secondTypes",secondTypes);
        }

        //1.查询所有的一级类型数据
        List<ArticleType> firstArticleTypes = shopService.loadFirstArticleTypes();
        //2.查询所有的商品信息
        List<Article> articles = shopService.searchArticles(typeCode);
        request.setAttribute("firstArticleTypes",firstArticleTypes);
        request.setAttribute("articles",articles);
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }


}