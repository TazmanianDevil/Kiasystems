package ru.kiasystems.model.restful.entities;

import ru.kiasystems.model.entity.Theme;

import java.io.Serializable;
import java.util.List;

public class Themes implements Serializable{
    private List<Theme> themes;

    public Themes(){}

    public Themes(List<Theme> themes){this.themes = themes;}

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
}
