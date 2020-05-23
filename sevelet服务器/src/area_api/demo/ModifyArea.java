package area_api.demo;

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
 * Servlet implementation class ModifyArea
 */
@WebServlet("/ModifyArea")
public class ModifyArea extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyArea() {
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
		// idt_area  img   is_yue  yue_person  yue_time 
		String area_id = request.getParameter("idt_area");
		String img = request.getParameter("img");
		String is_yue = request.getParameter("is_yue");
		String yue_person = request.getParameter("yue_person");
		String yue_time = request.getParameter("yue_time");
		String title = request.getParameter("title");
		String bianhao = request.getParameter("bianhao");
		
		
//		System.out.println(yue_time);
		
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement(); 
	        // idt_area  img   is_yue  yue_person  yue_time 
	        String sql="update tiyu_lunwen.t_area set img='" + img + "', is_yue='" + is_yue + "', yue_person='" + yue_person + "', yue_time='" + yue_time + "', title='" + title + "', bianhao='" + bianhao + "' where idt_area='" + area_id + "'";
//	        System.out.println(sql);
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
