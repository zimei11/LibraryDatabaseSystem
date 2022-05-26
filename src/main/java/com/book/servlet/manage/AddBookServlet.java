package com.book.servlet.manage;

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
import java.util.Date;

@WebServlet("/add-book")
public class AddBookServlet extends HttpServlet
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
        ThymeleafUtil.process("add-book.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name=req.getParameter("name");
        String ISBN=req.getParameter("ISBN");
        String type=req.getParameter("type");
        String author=req.getParameter("author");
        String publisher=req.getParameter("publisher");

        //float price=Float.parseFloat(req.getParameter("price"));
        int bookshelf_id=Integer.parseInt(req.getParameter("bookshelf_id"));
        //int state=Integer.parseInt(req.getParameter("state"));
        service.addBook(name, ISBN, type, author, publisher,   bookshelf_id);
        resp.sendRedirect("book");
    }
}
