package user_api.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class Regist
 */
@WebServlet("/Regist")
public class Regist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regist() {
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
		long time = System.currentTimeMillis();
        String user_id = String.valueOf(time/1000);
        
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String username = request.getParameter("user_name");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		String back_string = "";
		back_string = "{\"err\": 0 , \"msg\":\"注册成功\"}";
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="insert into tiyu_lunwen.t_user (idt_user , username , account , password , gender , birthday , tel , type) values ('" + user_id + "' , '" + username + "' , '" + account + "' , '" + password + "' , '" + gender + "' , '" + birthday + "' , '" + tel + "' , '" + type + "')";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        Boolean rs=stmt.execute(sql);
	        
//	        long time = System.currentTimeMillis();
//	        String t = String.valueOf(time/1000); 
//	        System.out.println("zzzz");
//	        System.out.println(rs);
	        
	        
	        
	       

        }  
        catch(Exception ex)  
        {  
        	back_string = "{\"err\": 1 , \"msg\":\"注册失败\"}";
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
