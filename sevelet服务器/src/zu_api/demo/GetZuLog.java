package zu_api.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.alibaba.fastjson.JSON;

import mysql_model.demo.YueModel;
import mysql_model.demo.ZuModel;
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetZuLog
 */
@WebServlet("/GetZuLog")
public class GetZuLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetZuLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("text/html; charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        Connection con=null;
        ArrayList<ZuModel> zu_arr = new ArrayList<>();
       try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from tiyu_lunwen.t_zu_log";  
            ResultSet rs=stmt.executeQuery(sql);  

			
			while(rs.next()) {

				//user_id
				// user_name
					// equip_num
						// equip_name
							// equip_id
								// idt_zu_log
				ZuModel zu = new ZuModel();
				zu.setIdt_zu_log(rs.getString("idt_zu_log"));
				zu.setEquip_id(rs.getString("equip_id"));
				zu.setEquip_name(rs.getString("equip_name"));
				zu.setEquip_num(rs.getString("equip_num"));
				zu.setUser_name(rs.getString("user_name"));
				zu.setUser_id(rs.getString("user_id"));
				zu.setCaozuo(rs.getString("caozuo"));
				
//				System.out.println(rs.getString("area_bianhao"));
//				System.out.println(yue);
				
				
				zu_arr.add(zu);
			}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(zu_arr));
            
            out.flush();  
            out.close();  
        } 
        
        
        response.setHeader("content-type", "text/html;charset=UTF-8");
		 
		response.setCharacterEncoding("UTF-8");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
