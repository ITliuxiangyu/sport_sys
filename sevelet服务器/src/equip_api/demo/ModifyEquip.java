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
 * Servlet implementation class ModifyEquip
 */
@WebServlet("/ModifyEquip")
public class ModifyEquip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyEquip() {
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
		// idt_equip  name  num 
		String equip_id = request.getParameter("equip_id");
		String equip_name = request.getParameter("equip_name");
		String equip_num = request.getParameter("equip_num");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        String sql="update tiyu_lunwen.t_equip set name='" + equip_name + "' , num='" + equip_num + "' where idt_equip='" + equip_id + "'";
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
