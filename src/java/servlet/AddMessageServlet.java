/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import JavaBean.MessageBean;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author Administrator
 */
public class AddMessageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String author=new String(request.getParameter("author").getBytes("ISO-8859-1"),"UTF-8");
	String title=new String(request.getParameter("title").getBytes("ISO-8859-1"),"UTF-8");
	String content=new String(request.getParameter("content").getBytes("ISO-8859-1"),"UTF-8");
	//获取当前时间并格式化时间为指定格式
	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String today=format.format(new Date());
	MessageBean mm=new MessageBean();
	mm.setAuthor(author);
	mm.setTitle(title);
	mm.setContent(content);
	mm.setTime(today);
//        //获取session对象
//	HttpSession session=request.getSession();
//	//通过session对象获取应用上下文
//	ServletContext scx=session.getServletContext();
//        //获取存储在应用上下文中的集合对象
//	ArrayList wordlist=(ArrayList)scx.getAttribute("wordlist");							if(wordlist==null)
//	wordlist=new ArrayList();
//        //将封装了信息的值JavaBean存储到集合对象中
//	wordlist.add(mm);
//	//将集合对象保存到应用上下文中
//	scx.setAttribute("wordlist",wordlist);
//	response.sendRedirect("showMessage.jsp");

		insert(mm);

		response.sendRedirect("showData");
    }

	protected void addData(String author,String title,String content){
		//获取当前时间并格式化时间为指定格式
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String today=format.format(new Date());
		MessageBean mm=new MessageBean();
		mm.setAuthor(author);
		mm.setTitle(title);
		mm.setContent(content);
		mm.setTime(today);
		insert(mm);
	}

	protected void insert(MessageBean mm) {
		servlet.jdbc jc = new servlet.jdbc();
		Connection conn = jc.getConnection();
		String sql = "insert into message (author,title,content,time) values(?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, mm.getAuthor());
			pstmt.setString(2, mm.getTitle());
			pstmt.setString(3, mm.getContent());
			pstmt.setString(4, mm.getTime());
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
