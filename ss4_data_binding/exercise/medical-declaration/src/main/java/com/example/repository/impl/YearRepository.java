package com.example.repository.impl;
import com.example.model.Year;
import com.example.repository.IYearRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class YearRepository implements IYearRepository {
    private static List<Year>yearList = new ArrayList<>();
    static {
        for (int i = 1950; i <= 2050; i++) {
            yearList.add(new Year(""+i));
        }
    }
    @Override
    public List<Year> findAll() {
        return yearList;
    }
}
