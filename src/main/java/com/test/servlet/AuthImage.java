package com.test.servlet;

import com.test.util.VerifyCodeUtils;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/checkcode.AuthImage")
public class AuthImage extends HttpServlet implements Servlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        //生成随机字串 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session 
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("verCode");
        request.getSession().setAttribute("verCode", verifyCode.toLowerCase());
/*        HttpSession session = request.getSession();
        session.setAttribute("verCode", verifyCode.toLowerCase());*/
        //生成图片 
        int w = 100, h = 30;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);

    }
}