package com.book.servlet.manage;

import com.book.entity.Reader;
import com.book.service.ReaderService;
import com.book.service.impl.ReaderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-reader")
public class DeleteReaderServlet extends HttpServlet
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
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String mail=req.getParameter("mail");
        service.deleteReader(mail);
        resp.sendRedirect("reader");
    }
}
