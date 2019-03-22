/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class Verify extends HttpServlet {
    public void doPost(HttpServletRequest request,HttpServletResponse response) 
                        throws ServletException,IOException{
        String number=request.getParameter("number");     
        try{
            double n=Double.parseDouble(number);//作用是把字符串转换为Double
            if(n>6000||n<-6000)
                 response.sendRedirect("sendForward.jsp"); //重定向到sendForward.jsp
            else{
                RequestDispatcher dispatcher= request.getRequestDispatcher("ShowMessage");
                dispatcher.forward(request,response); //转发到另一个servlet文件
            }
        }
        catch(NumberFormatException e){
             response.sendRedirect("sendForward.jsp"); //重定向到sendForward.jsp
         }
     } 
     public  void  doGet(HttpServletRequest request,HttpServletResponse response) 
                        throws ServletException,IOException{
         doPost(request,response);
    }
}
