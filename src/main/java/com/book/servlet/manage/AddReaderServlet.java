package com.book.servlet.manage;

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

@WebServlet("/add-reader")
public class AddReaderServlet extends HttpServlet
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
        context.setVariable("email",user.getMail());
        context.setVariable("nickname",user.getNickname());
        ThymeleafUtil.process("add-reader.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String mail=req.getParameter("mail");
        String password=req.getParameter("password");
        String sex=req.getParameter("sex");
        String name=req.getParameter("name");
        String phone=req.getParameter("phone");
        String state=req.getParameter("state");
        service.addReader(mail,password,name,sex,phone,state);
        resp.sendRedirect("reader");
    }
}
