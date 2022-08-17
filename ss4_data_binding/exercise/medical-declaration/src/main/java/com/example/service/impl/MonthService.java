package com.example.service.impl;
import com.example.model.Month;
import com.example.repository.IMonthRepository;
import com.example.service.IMonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MonthService implements IMonthService {
   @Autowired
   private IMonthRepository iMonthRepository;
    @Override
    public List<Month> findAll() {
        return this.iMonthRepository.findAll();
    }
}
