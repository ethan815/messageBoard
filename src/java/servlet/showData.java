package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import JavaBean.MessageBean;
import java.util.ArrayList;
import java.util.List;
public class showData extends HttpServlet {
        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            // 设置响应内容类型
            //response.setContentType("text/html;charset=UTF-8");
            //PrintWriter out = response.getWriter();
            servlet.jdbc jc = new servlet.jdbc();
            Connection jdbc = jc.getConnection();
            String sql = "select author,title,content,time from message";
            List<MessageBean> messageList = new ArrayList<MessageBean>();
            try {
                Statement sm = jdbc.createStatement();
                ResultSet rs = sm.executeQuery(sql);
                while (rs.next()) {
//                    int id = rs.getInt(1);
//                    String name = rs.getString(2);
//                    out.println(id + name);
                    MessageBean message = new MessageBean();
                    messageList.add(message);
                    message.setAuthor(rs.getString("author"));
                    message.setTitle(rs.getString("title"));
                    message.setContent(rs.getString("content"));
                    message.setTime(rs.getString("time"));
                }

                request.setAttribute("messageList",messageList);
                //向页面跳转
                request.getRequestDispatcher("/showData.jsp").forward(request,response);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }
        /**
         * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            doGet(request, response);
        }
    }