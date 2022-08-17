package com.codegym.service;

import com.codegym.model.MailBox;

public interface IMailBoxService {
    void addMailBox(MailBox mailBox);
    MailBox view(int id);
}
