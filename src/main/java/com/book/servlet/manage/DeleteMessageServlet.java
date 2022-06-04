package com.book.servlet.manage;

import com.book.service.MessageService;
import com.book.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-message")
public class DeleteMessageServlet extends HttpServlet
{
    MessageService service;

    @Override
    public void init() throws ServletException
    {
        service=new MessageServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        int mid=Integer.parseInt(req.getParameter("mid"));
        service.deleteMessage(mid);
        resp.sendRedirect("message");
    }
}
