package equip_api.demo;

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
 * Servlet implementation class DeleteEquip
 */
@WebServlet("/DeleteEquip")
public class DeleteEquip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEquip() {
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
		
		String equip_id = request.getParameter("equip_id");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        
	        String sql="delete from tiyu_lunwen.t_equip where idt_equip='" + equip_id + "'";
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
