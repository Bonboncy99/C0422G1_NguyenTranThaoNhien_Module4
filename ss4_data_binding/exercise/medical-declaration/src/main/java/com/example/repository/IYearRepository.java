package com.example.repository;
import com.example.model.Year;
import java.util.List;

public interface IYearRepository {
    List<Year> findAll();
}
