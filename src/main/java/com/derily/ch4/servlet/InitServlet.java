package com.derily.ch4.servlet;

import com.derily.ch4.db.connection.DatabaseConnectionFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InitServlet",value = "/initServlet",loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID=1L;
    public InitServlet(){
        super();
    }
    public void init(ServletConfig config) throws ServletException{
        try {
            DatabaseConnectionFactory.getConnectionFactory().init();
        }catch (IOException e){
            config.getServletContext().log(e.getLocalizedMessage(),e);
        }
    }
}
