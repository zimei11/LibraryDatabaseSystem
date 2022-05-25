package com.book.servlet.manage;

import com.book.service.BookService;
import com.book.service.impl.BookServiceImpl;
import com.book.utils.ThymeleafUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.thymeleaf.context.Context;
import java.io.IOException;

@WebServlet("/add-borrow")
public class AddBorrowServlet extends HttpServlet
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
        ThymeleafUtil.process("add-borrow.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String mail=req.getParameter("reader");
        int book_id=Integer.parseInt(req.getParameter("book"));
        service.addBorrow(mail,book_id);
        resp.sendRedirect("index#dropdownMenuButton-customer");
    }
}
