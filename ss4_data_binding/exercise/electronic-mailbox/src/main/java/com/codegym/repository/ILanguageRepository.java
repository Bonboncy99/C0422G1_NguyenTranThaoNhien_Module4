package com.codegym.repository;

import com.codegym.model.Language;

import java.util.List;
import java.util.Map;

public interface ILanguageRepository {
    List<Language> findAll();
}
