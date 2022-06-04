package com.book.service.impl;

import com.book.dao.MessageMapper;
import com.book.entity.Message;
import com.book.service.MessageService;
import com.book.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MessageServiceImpl implements MessageService
{
    @Override
    public List<Message> getMessageList()
    {
        try(SqlSession sqlSession= MybatisUtil.getSession())
        {
            MessageMapper mapper=sqlSession.getMapper(MessageMapper.class);
            return mapper.getMessageList();
        }
    }

    @Override
    public void addMessage(String content,String mail)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            MessageMapper mapper=sqlSession.getMapper(MessageMapper.class);
            mapper.addMessage(content,mail);
        }
    }

    @Override
    public void deleteMessage(int mid)
    {
        try(SqlSession sqlSession=MybatisUtil.getSession())
        {
            MessageMapper mapper=sqlSession.getMapper((MessageMapper.class));
            mapper.deleteMessage(mid);
        }
    }
}
