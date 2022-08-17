package com.codegym.repository.impl;

import com.codegym.model.Language;
import com.codegym.repository.ILanguageRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LanguageRepository implements ILanguageRepository {
    static Map<Integer, Language> integerLanguageMap;
    static {
        integerLanguageMap = new HashMap<>();
        integerLanguageMap.put(1,new Language(1,"English"));
        integerLanguageMap.put(2,new Language(2,"Vietnamese"));
        integerLanguageMap.put(3,new Language(3,"Japanese"));
        integerLanguageMap.put(4,new Language(4,"Chinese"));
    }

    @Override
    public List<Language> findAll() {
        return new ArrayList<>(integerLanguageMap.values());
    }
}
