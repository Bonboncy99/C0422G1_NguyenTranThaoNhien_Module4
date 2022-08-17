package com.example.repository.impl;
import com.example.model.Month;
import com.example.repository.IMonthRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MonthRepository implements IMonthRepository {
    private static List<Month>monthList = new ArrayList<>();
    static {
        for (int i = 1; i <= 12; i++) {
            monthList.add(new Month(""+i));
        }
    }
    @Override
    public List<Month> findAll() {
        return monthList;
    }
}
