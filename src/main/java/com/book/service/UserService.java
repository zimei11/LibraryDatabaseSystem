package com.book.service;

import javax.servlet.http.HttpSession;

public interface UserService {
    boolean auth(String username, String password, HttpSession session);
}

