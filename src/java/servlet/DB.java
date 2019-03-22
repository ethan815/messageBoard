package servlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        Connection conn=null;
        try {
            conn=DriverManager.getConnection("jdbc:mysql://:3306/messageboard", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closeConnection(Connection conn){
        if(conn!=null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Statement getStatement(Connection conn){
        Statement state=null;
        try {
            state=conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return state;
    }

    public static void closeStatement(Statement state){
        if(state!=null){
            try {
                state.close();
                state=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static PreparedStatement getPreparedStatement(Connection conn,String sql){
        PreparedStatement pstate=null;
        try {
            pstate=conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstate;
    }

    public static PreparedStatement getPreparedStatement(Connection conn,String sql,boolean is){
        PreparedStatement pstate=null;
        try {
            pstate=conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstate;
    }

    public static ResultSet executeQuery(Statement state,String sql){
        ResultSet reSet=null;
        try {
            reSet=state.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reSet;
    }

    public static void closeResultSet(ResultSet reSet){
        if(reSet!=null){
            try {
                reSet.close();
                reSet=null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
