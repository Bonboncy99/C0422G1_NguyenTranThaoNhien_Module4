package com.codegym.repository.impl;

import com.codegym.model.Language;
import com.codegym.model.PageSize;
import com.codegym.repository.ILanguageRepository;
import com.codegym.repository.IPageSizeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PageSizeRepository implements IPageSizeRepository {
    static Map<Integer, PageSize> integerPageSizeMap;
    static {
        integerPageSizeMap = new HashMap<>();
        integerPageSizeMap.put(1,new PageSize(1,5));
        integerPageSizeMap.put(2,new PageSize(2,10));
        integerPageSizeMap.put(3,new PageSize(3,15));
        integerPageSizeMap.put(4,new PageSize(4,25));
        integerPageSizeMap.put(5,new PageSize(5,50));
        integerPageSizeMap.put(6,new PageSize(6,100));
    }

    @Override
    public List<PageSize> findAll() {
        return new ArrayList<>(integerPageSizeMap.values());
    }
}
