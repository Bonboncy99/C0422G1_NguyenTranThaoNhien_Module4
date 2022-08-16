package com.codegym.service;

import com.codegym.model.Condiment;

import java.util.List;

public interface ICondimentsService {
    List<Condiment> findAll();
}
