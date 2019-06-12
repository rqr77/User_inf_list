package com.test.servlet;



import com.test.domain.User;
import com.test.service.UserService;
import com.test.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userdata =new UserServiceImpl();
        List<User> list=userdata.findAll();
        System.out.println(list);
  /*      request.setCharacterEncoding("text/html;charset=utf-8");*/
        request.setAttribute("users",list);
        request.getRequestDispatcher("/list.jsp").forward(request,response);




    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
