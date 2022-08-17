package com.codegym.repository;

import com.codegym.model.MailBox;
import com.codegym.model.PageSize;

import java.util.List;

public interface IMailBoxRepository {
    List<MailBox> findAll();
    void addMailBox(MailBox mailBox);

    MailBox view(int id);
}
