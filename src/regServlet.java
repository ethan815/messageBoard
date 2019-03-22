import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class regServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        //处理请求的一般步骤是：
        //1.接收参数
        String user = req.getParameter("userName");
        String pwd = req.getParameter("passWord");
        String sex = req.getParameter("sex");
        String[] interests = req.getParameterValues("interest");

        //处理请求乱码
        //方案一：将乱码后的字符串按照ISO还原再按UTF编码。不常用
        byte[] bs = user.getBytes("ISO8859-1");
        user = new String(bs, "utf-8");
        //方法二：只对GET有效，在eclipse中：server.xml中65行加URIEncoding="utf-8"
        //优点：简单  缺点：只对GET有效
        // 在idea中，File->Settings->Editor->File Encodings 把页面上的三个选项都改成UTF-8
        //方法三：只对POST有效，在接收参数前，加req.setCharactorEncoding("UTF-8")
        //声明试题内容的编码为UTF-8
        //优点：简单  缺点：只对POST有效

        //2.处理业务
        //常规的注册业务应该保存这些数据，但本案例重点在于传参，因此就不存了。
        System.out.println(user);
        System.out.println(pwd);
        System.out.println(sex);
        if (interests != null) {
            for (String i : interests) {
                System.out.println(i);
            }
        }
        //3.发送响应，这里也要对编码方式进行处理，不然“注册成功”就会是乱码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<p>注册成功</p>");
        out.close();
    }
}