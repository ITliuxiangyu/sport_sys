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

import mysql_model.demo.AreaModel;
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetYueByPerson
 */
@WebServlet("/GetYueByPerson")
public class GetYueByPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetYueByPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("text/html; charset=UTF-8");
		
		String yue_person = request.getParameter("yue_person");
		
        PrintWriter out = response.getWriter();  
        Connection con=null;
        ArrayList<AreaModel> area_arr = new ArrayList<>();
        
        try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from tiyu_lunwen.t_area where idt_area in (select area_id from tiyu_lunwen.t_yue_log where yue_person='" + yue_person +"')";  
            ResultSet rs=stmt.executeQuery(sql); 

			
			while(rs.next()) {
				// idt_area  img   is_yue  yue_person  yue_time
				AreaModel area = new AreaModel();
				area.setIdt_area(rs.getString("idt_area"));
				area.setImg(rs.getString("img"));
				area.setIs_yue(rs.getString("is_yue"));
				area.setYue_person(rs.getString("yue_person"));
				area.setYue_time(rs.getString("yue_time"));
				area.setTitle(rs.getString("title"));
				area.setBianhao(rs.getString("bianhao"));
				area_arr.add(area);
			}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(area_arr));
            
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
