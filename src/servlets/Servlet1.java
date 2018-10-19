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
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet("/database")
public class Servlet1 extends javax.servlet.http.HttpServlet {
    private static final long serialVersionUID = 1L;
    AtomicInteger atomicInteger = new AtomicInteger(0); // initialize it with a value or empty

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atomicInteger.addAndGet(1);
        int theValue = atomicInteger.get(); // this is how you get it
        String button = request.getParameter("button");

        if ("button1".equals(button)) {
            String statusId = (request.getParameter("status").toString());
            request.setAttribute("status", statusId);
            Statement statement = Database.connect();
            ArrayList<Logistic> logistics = Database.selectByStatus(statement, statusId);
            request.setAttribute("logistics", logistics);
            ArrayList<String> status = Database.selectStatus(statement);
            request.setAttribute("status", status);
            request.setAttribute("count", theValue);



            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
        else if ("button2".equals(button)) {
            Statement statement = Database.connect();
            ArrayList<Logistic> logistics = Database.sort(statement);
            request.setAttribute("logistics", logistics);
            ArrayList<String> status = Database.selectStatus(statement);
            request.setAttribute("status", status);
            request.setAttribute("count", theValue);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);

        }
    }


    protected void sort(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atomicInteger.addAndGet(1);
        int theValue = atomicInteger.get(); // this is how you get it
        String statusId = (request.getParameter("status").toString());
        request.setAttribute("status", statusId);
        Statement statement = Database.connect();
        ArrayList<Logistic> logistics = Database.selectByStatus(statement, statusId);
        request.setAttribute("logistics", logistics);
        ArrayList<String> status = Database.selectStatus(statement);
        request.setAttribute("status", status);
        request.setAttribute("count", theValue);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        atomicInteger.addAndGet(1);
        int theValue = atomicInteger.get(); // this is how you get it


        Statement statement = Database.connect();
        ArrayList<Logistic> logistics = Database.select(statement);
        request.setAttribute("logistics", logistics);

        ArrayList<String> status = Database.selectStatus(statement);
        request.setAttribute("status", status);
        request.setAttribute("count", theValue);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }





    }
