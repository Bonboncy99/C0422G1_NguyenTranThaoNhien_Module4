package com.example.service.impl;
import com.example.model.Year;
import com.example.repository.IYearRepository;
import com.example.service.IYearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class YearService implements IYearService {

    @Autowired
    private IYearRepository iYearRepository;
    @Override
    public List<Year> findAll() {
        return this.iYearRepository.findAll();
    }
}
