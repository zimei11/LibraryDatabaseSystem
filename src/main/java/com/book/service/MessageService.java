package com.book.service;

import com.book.entity.Message;

import java.util.List;

public interface MessageService
{
    List<Message> getMessageList();

    void addMessage(String content,String mail);
}
