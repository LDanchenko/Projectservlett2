package servlets;

import classes.Database;
import classes.Logistic;
import sun.rmi.runtime.Log;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

@WebServlet("/database")
public class Servlet1 extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String statusId = (request.getParameter("status").toString());

                request.setAttribute("status", statusId);

                listCategory(request, response, statusId);
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response, String status)
            throws ServletException, IOException {

          Statement statement = Database.connect();

            ArrayList<Logistic> logistics = Database.selectSBytatus(statement, status);
        request.setAttribute("logistics", logistics);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement statement = Database.connect();
        ArrayList<Logistic> logistics = Database.select(statement);
        request.setAttribute("logistics", logistics);
        ArrayList<String> status = Database.selectStatus(statement);
        request.setAttribute("status", status);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }





    }
