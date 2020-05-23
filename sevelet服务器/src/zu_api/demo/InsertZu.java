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
 * Servlet implementation class InsertZu
 */
@WebServlet("/InsertZu")
public class InsertZu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertZu() {
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
		
		//user_id
				// user_name
					// equip_num
						// equip_name
							// equip_id
								// idt_zu_log
		long time = System.currentTimeMillis();
        String idt_zu_log = String.valueOf(time/1000);
        
        
		String equip_id = request.getParameter("equip_id");
		String equip_name = request.getParameter("equip_name");
		String equip_num = request.getParameter("equip_num");
		String user_name = request.getParameter("user_name");
		String user_id = request.getParameter("user_id");
		String caozuo = request.getParameter("caozuo");
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		String back_string = "";
		back_string = "{\"err\": 0 , \"msg\":\"操作成功\"}";
		
		try  
        {  
			
			//user_id
			// user_name
				// equip_num
					// equip_name
						// equip_id
							// idt_zu_log
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="insert into tiyu_lunwen.t_zu_log (idt_zu_log , equip_id , equip_name , equip_num , user_name , user_id , caozuo) values ('" + idt_zu_log + "' , '" + equip_id + "' , '" + equip_name + "' , '" + equip_num + "' , '" + user_name + "', '" + user_id + "' , '" + caozuo + "')";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        Boolean rs=stmt.execute(sql);
	        
	        
	        String sql2="";
	        if (caozuo.equals("退租")) {
	        	sql2 = "update tiyu_lunwen.t_equip set num=cast(num as unsigned) + " + (equip_num + "") + " where idt_equip='" + equip_id + "'";
            } else if (caozuo.equals("租借")) {
            	sql2 = "update tiyu_lunwen.t_equip set num=cast(num as unsigned) - " + (equip_num + "") + " where idt_equip='" + equip_id + "'";
            }
	        System.out.println(sql2);
	        System.out.println(caozuo);
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
