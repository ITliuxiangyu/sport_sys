package yue_api.demo;

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
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetYue
 */
@WebServlet("/GetYue")
public class GetYue extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetYue() {
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
        ArrayList<YueModel> yue_arr = new ArrayList<>();
       try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from tiyu_lunwen.t_yue_log";  
            ResultSet rs=stmt.executeQuery(sql);  

			
			while(rs.next()) {

				// idt_yue_log yue_person  yue_time  area_id  yue_type;
				YueModel yue = new YueModel();
				yue.setIdt_yue_log(rs.getString("idt_yue_log"));
				yue.setYue_person(rs.getString("yue_person"));
				yue.setYue_time(rs.getString("yue_time"));
				yue.setArea_id(rs.getString("area_id"));
				yue.setYue_type(rs.getString("yue_type"));
				yue.setArea_name(rs.getString("area_name"));
				yue.setArea_bianhao(rs.getString("area_bianhao"));
				
				System.out.println(rs.getString("area_bianhao"));
				System.out.println(yue);
				
				
				yue_arr.add(yue);
			}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(yue_arr));
            
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
