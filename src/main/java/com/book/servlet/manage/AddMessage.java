package com.book.servlet.manage;

import com.book.entity.User;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-message")
public class AddMessage extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Context context = new Context();
        User user=(User)req.getSession().getAttribute("user");
        context.setVariable("email",user.getMail());
        context.setVariable("nickname",user.getNickname());
        ThymeleafUtil.process("add-message.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        try
        {
            Thread.sleep (2000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }
        resp.sendRedirect("add-message");
    }
}
