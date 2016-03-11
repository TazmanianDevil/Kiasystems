package ru.kiasystems.controller;

import ru.kiasystems.logic.beans.ThemeBean;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import ru.kiasystems.model.entity.Theme;

import java.io.PrintWriter;
import java.util.List;
@WebServlet("/list")
public class MainServlet extends HttpServlet {
    @Inject
    @EJB
    private ThemeBean themeBean;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //out.print("themBean state " + themeBean.getThemeById(2) + "</br>");
        List<Theme> themes = themeBean.getAllThemes();
        out.print(themes);
//        request.setAttribute("themes", themes);
//        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
