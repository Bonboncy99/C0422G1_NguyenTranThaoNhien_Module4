package com.example.repository.impl;

import com.example.model.Day;
import com.example.repository.IDayRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DayRepository implements IDayRepository {
    private static List<Day>dayList = new ArrayList<>();
    static {
        for (int i = 1; i <= 31; i++) {
            dayList.add(new Day(""+i));
        }
    }
    @Override
    public List<Day> findAll() {
        return dayList;
    }
}
