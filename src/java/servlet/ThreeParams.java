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
public class ThreeParams extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();        
        out.println("<html>");      
        out.println("<body>");        
        out.println(request.getParameter("gr1") +"<br>");
        out.println(request.getParameter("gr2") +"<br>");
        out.println(request.getParameter("gr3") +"<br>");        
        out.println("</body>");
        out.println("</html>");        
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
       processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        processRequest(request, response);
    }
} 
