package com.example.service.impl;

import com.example.model.Day;
import com.example.repository.IDayRepository;
import com.example.service.IDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DayService implements IDayService {
    @Autowired
    private IDayRepository iDayRepository;

    @Override
    public List<Day> findAll() {
        return this.iDayRepository.findAll();
    }
}
