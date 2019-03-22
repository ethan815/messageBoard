package servlet;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class jdbc {
    public Connection getConnection(){
        try {
            //加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //连接数据库
            return DriverManager.getConnection("jdbc:mysql://:3306/messageboard","root","");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public void closeConection(Connection con){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
