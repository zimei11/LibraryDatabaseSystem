package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/book")
public class BookServlet extends HttpServlet
{
    BookService service;

    @Override
    public void init() throws ServletException
    {
        service=new BookServiceImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Context context = new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("email",user.getMail());
        context.setVariable("nickname",user.getNickname());
        context.setVariable("book_list",service.getBookList());
        ThymeleafUtil.process("book.html",context,resp.getWriter());

    }
}
