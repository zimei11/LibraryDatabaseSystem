package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.OtherService;
import com.book.service.impl.BookServiceImpl;
import com.book.service.impl.OtherServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet
{
    BookService service;
    OtherService service1;

    @Override
    public void init() throws ServletException
    {
        service=new BookServiceImpl();
        service1=new OtherServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Context context=new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("email",user.getMail());
        context.setVariable("borrow_list",service.getBorrowList());
        context.setVariable("book_rank",service1.getViewList());
        ThymeleafUtil.process("index.html",context,resp.getWriter());

    }
}
