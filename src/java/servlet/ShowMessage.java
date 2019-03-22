/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
public class ShowMessage extends HttpServlet {

    
    public  void  doPost(HttpServletRequest request,HttpServletResponse response)                         throws ServletException,IOException{
      response.setContentType("text/html;charset=GB2312");
      PrintWriter out=response.getWriter();
      String number=request.getParameter("number"); //获取客户提交的信息
      double n=Double.parseDouble(number);
      out.println(number+"的平方:"+(n*n));
   } 
   public  void  doGet(HttpServletRequest request,HttpServletResponse response) 
                        throws ServletException,IOException{
      doPost(request,response);
   }
}
