package com.codegym.service.impl;

import com.codegym.model.Language;
import com.codegym.repository.ILanguageRepository;
import com.codegym.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService implements ILanguageService {
    @Autowired
    private ILanguageRepository iLanguageRepository;

    @Override
    public List<Language> findAll() {
        return iLanguageRepository.findAll();
    }
}
