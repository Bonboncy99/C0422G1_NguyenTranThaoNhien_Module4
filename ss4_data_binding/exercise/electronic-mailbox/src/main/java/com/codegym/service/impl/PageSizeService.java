package com.codegym.service.impl;

import com.codegym.model.Language;
import com.codegym.model.PageSize;
import com.codegym.repository.ILanguageRepository;
import com.codegym.repository.IPageSizeRepository;
import com.codegym.service.ILanguageService;
import com.codegym.service.IPageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageSizeService implements IPageSizeService {
    @Autowired
    private IPageSizeRepository iPageSizeRepository;

    @Override
    public List<PageSize> findAll() {
        return iPageSizeRepository.findAll();
    }
}
