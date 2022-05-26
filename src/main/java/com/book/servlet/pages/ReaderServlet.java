package com.book.servlet.pages;

import com.book.entity.User;
import com.book.service.ReaderService;
import com.book.service.impl.ReaderServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reader")
public class ReaderServlet extends HttpServlet
{
    ReaderService service;

    @Override
    public void init() throws ServletException
    {
        service=new ReaderServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Context context = new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("nickname",user.getNickname());
        context.setVariable("reader_list",service.getReaderList());
        ThymeleafUtil.process("reader.html",context,resp.getWriter());


    }
}
