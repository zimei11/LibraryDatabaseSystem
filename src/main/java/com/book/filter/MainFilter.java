package com.book.filter;

import com.book.entity.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class MainFilter extends HttpFilter
{
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        String url = req.getRequestURL().toString();
        if (!url.contains("/static/") && !url.endsWith("auth-login"))
        {
            HttpSession session=req.getSession();
            User user = (User)session.getAttribute("user");
            if(user==null)
            {
                res.sendRedirect("auth-login");
                return;
            }

        }
        chain.doFilter(req, res);

    }

}

