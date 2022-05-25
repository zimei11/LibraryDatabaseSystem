package com.book.service.impl;

import com.book.dao.BookMapper;
import com.book.dao.UserMapper;
import com.book.entity.Borrow;
import com.book.entity.User;
import com.book.entity.Book;
import com.book.service.BookService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookServiceImpl implements BookService
{
    @Override
    public List<Borrow> getBorrowList()
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            BookMapper mapper=sqlSession.getMapper((BookMapper.class));
            return mapper.getBorrowList();
        }
    }

    @Override
    public void returnBook(String id)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            BookMapper mapper=sqlSession.getMapper((BookMapper.class));
            mapper.updateBorrow(id);
        }
    }

    @Override
    public void addBorrow(String mail,int book_id)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            BookMapper mapper=sqlSession.getMapper(BookMapper.class);
            mapper.addBorrow(mail,book_id);
        }
    }

    @Override
    public List<Book> getBookList()
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            BookMapper mapper=sqlSession.getMapper((BookMapper.class));
            return mapper.getBookList();
        }
    }

    @Override
    public void deleteBook(int bid)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            BookMapper mapper=sqlSession.getMapper((BookMapper.class));
            mapper.deleteBook(bid);
        }
    }

    //看哪本书被节约了，过滤一下
//    @Override
//    public List<Book> getActiveBookList()
//    {
//        Set<Integer> set=new HashSet<>();
//        this.getBorrowList().forEach(borrow->set.add(borrow.getBook_id()));
//        try(SqlSession sqlSession=MybatisUtil.getSession())
//        {
//            BookMapper mapper=sqlSession.getMapper((BookMapper.class));
//            mapper.getBookList()
//                    .stream()
//                    .filter(book->!set.contains(book.get))
//        }
//    }
}
