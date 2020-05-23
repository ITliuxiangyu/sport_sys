package user_api.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import mysql_model.demo.UserModel;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		// idt_user  user name  account  password  gender  birthday  t el
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		String back_string = "";
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="select * from tiyu_lunwen.t_user where account='" + account + "' and password='" + password + "'";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        ResultSet rs=stmt.executeQuery(sql);
	        // System.out.println(rs);
	        
	        
	        
	        if (rs.next()) {
	        	UserModel user = new UserModel();
				user.setIdt_user(rs.getString("idt_user"));
				user.setUsername(rs.getString("username"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getString("birthday"));
				user.setTel(rs.getString("tel"));
				user.setType(rs.getString("type"));
	        	back_string = "{\"err\": 0 , \"msg\":\"登录成功\" , \"user\":" + JSON.toJSONString(user) + "}";
        	} else {
        		back_string = "{\"err\": 1 , \"msg\":\"登录失败\"}";
        	}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);
        	
        	
        	
    		
    		// response.getWriter().write("{\"err\":0 , \"msg\":\"操作成功\"}");
        	response.getWriter().write(back_string);
    		
    		response.setHeader("content-type", "text/html;charset=UTF-8");
      		 
    		response.setCharacterEncoding("UTF-8");
    		
            out.flush();  
            out.close();  
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
