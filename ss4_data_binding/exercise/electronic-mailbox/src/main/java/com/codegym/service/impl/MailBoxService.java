package com.codegym.service.impl;

import com.codegym.model.MailBox;
import com.codegym.repository.IMailBoxRepository;
import com.codegym.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailBoxService implements IMailBoxService {
    @Autowired
    private IMailBoxRepository iMailBoxRepository;
    @Override
    public void addMailBox(MailBox mailBox) {
        this.iMailBoxRepository.addMailBox(mailBox);
    }

    @Override
    public MailBox view(int id) {
        return this.iMailBoxRepository.view(id);
    }
}
