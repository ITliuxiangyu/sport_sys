package zu_api.demo;

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
 * Servlet implementation class TuiZu
 */
@WebServlet("/TuiZu")
public class TuiZu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TuiZu() {
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
	
	
        
        
		String zu_id = request.getParameter("zu_id");
		String equip_id = request.getParameter("equip_id");
		String equip_num = request.getParameter("equip_num");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		String back_string = "";
		back_string = "{\"err\": 0 , \"msg\":\"操作成功\"}";
		
		try  
        {  
			
			
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="update tiyu_lunwen.t_zu_log set caozuo = '已退租' where idt_zu_log='" + zu_id + "'";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        Boolean rs=stmt.execute(sql);
	        
	        
	        String sql2= "update tiyu_lunwen.t_equip set num=cast(num as unsigned) + " + (equip_num + "") + " where idt_equip='" + equip_id + "'";
	        
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        stmt.execute(sql2);
	        
	        
	        
	        
	        
	       

        }  
        catch(Exception ex)  
        {  
        	back_string = "{\"err\": 1 , \"msg\":\"操作失败\"}";
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
