package com.codegym.repository.impl;

import com.codegym.model.MailBox;
import com.codegym.repository.IMailBoxRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MailBoxRepository implements IMailBoxRepository {
    private static Map<Integer,MailBox>integerMailBoxMap = new HashMap<>();
    @Override
    public List<MailBox> findAll() {
        return null;
    }

    @Override
    public void addMailBox(MailBox mailBox) {
        integerMailBoxMap.put(mailBox.getId(), mailBox);
    }

    @Override
    public MailBox view(int id) {
        return integerMailBoxMap.get(id);
    }
}
