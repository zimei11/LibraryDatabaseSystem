package com.book.servlet.auth;

import com.book.entity.User;
import com.book.service.UserService;
import com.book.service.impl.UserServiceImpl;
import com.book.utils.ThymeleafUtil;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/auth-login")
public class LoginServlet extends HttpServlet
{
    UserService service;
    @Override
    public void init() throws ServletException
    {
        service=new UserServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Context context=new Context();
        if(req.getSession().getAttribute("login-failure")!=null)
        {
            context.setVariable("failure",true);
            req.getSession().removeAttribute("login-failure");
        }
        if(req.getSession().getAttribute(("user"))!=null)
        {
            resp.sendRedirect("index");
            return ;
        }
        ThymeleafUtil.process("auth-login.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username=req.getParameter("username");
        String password=req.getParameter("password");
        if(service.auth(username,password, req.getSession()))
        {
            //resp.getWriter().write("恭喜你登录成功了，真不瓤!");
            resp.sendRedirect("index");
        }else
        {
            req.getSession().setAttribute("login-failure",new Object());
            this.doGet(req,resp);
        }
    }
}
