package user_api.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class ModifyUser
 */
@WebServlet("/ModifyUser")
public class ModifyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUser() {
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
		String user_id = request.getParameter("user_id");
		String user_name = request.getParameter("user_name");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String birthday = request.getParameter("birthday");
		String tel = request.getParameter("tel");
		String user_type = request.getParameter("type");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="update tiyu_lunwen.t_user set username='" + user_name + "' , account='" + account + "', password='" + password + "', gender='" + gender + "',birthday='" + birthday + "', tel='" + tel + "',type='" + user_type + "' where idt_user='" + user_id + "'";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        // 操作用这个
	        stmt.execute(sql);

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);
    		
    		response.getWriter().write("{\"err\":0 , \"msg\":\"操作成功\"}");
    		
    		
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
