package yue_api.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class DeleteYue
 */
@WebServlet("/DeleteYue")
public class DeleteYue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteYue() {
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
		
		String yue_id = request.getParameter("yue_id");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        
	        String sql="delete from tiyu_lunwen.t_yue_log where idt_yue_log='" + yue_id + "'";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        // 操作用这个
	        stmt.execute(sql);
	        // Boolean rs = stmt.execute(sql);
	        // System.out.println("88888");
	        // System.out.println(rs);

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);
    		
    		response.getWriter().write("{\"err\":0 , \"msg\":\"删除成功\"}");
    		
    		
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
