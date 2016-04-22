package ru.kiasystems.logic.spring.beans.dao;

import ru.kiasystems.model.entity.Theme;

import java.util.List;

public interface ThemeService {
    List<Theme> findAll();
    Theme findById(Long id);
    Theme findByTitle(String title);
    Theme save(Theme theme);
    void delete(Theme theme);
    void delete(Long id);
}
