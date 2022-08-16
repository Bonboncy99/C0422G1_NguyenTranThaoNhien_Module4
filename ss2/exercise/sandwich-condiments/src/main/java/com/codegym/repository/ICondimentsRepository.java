package com.codegym.repository;

import com.codegym.model.Condiment;

import java.util.List;

public interface ICondimentsRepository {
    List<Condiment> findAll();

}
