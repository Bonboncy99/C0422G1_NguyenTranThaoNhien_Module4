package com.codegym.service;

import com.codegym.model.Language;
import com.codegym.model.PageSize;

import java.util.List;

public interface IPageSizeService {
    List<PageSize> findAll();
}
