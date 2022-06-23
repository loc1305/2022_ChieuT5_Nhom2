package com.example.projectcnpm.controller;

import com.example.projectcnpm.mail.Mail;
import com.example.projectcnpm.modal.Account;
import com.example.projectcnpm.random.Random;
import com.example.projectcnpm.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ForgotPasswordControler", value = "/forgotpassword")
public class ForgotPasswordController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        Account a = AccountService.getInstance().checkAccountExist(username,email);
        String subject = "Forgot Password";


        if(a!=null){
            String newPass = Random.randomPassword();
            AccountService.getInstance().changePassword(a,newPass);
            String content = "Your password is " + newPass;
            Mail.sendMail(email,subject,content);
            request.setAttribute("message", "Your password has been sent. Please check in your email and login again.");
            request.setAttribute("success","success");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);
        }else{
            request.setAttribute("message", "Username and email do not match. Please check again!!");
            request.setAttribute("success","");
            request.getRequestDispatcher("forgotpassword.jsp").forward(request,response);
        }

    }
}
