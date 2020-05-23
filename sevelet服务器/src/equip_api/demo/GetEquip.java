package equip_api.demo;

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

import mysql_model.demo.EquipModel;
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetEquip
 */
@WebServlet("/GetEquip")
public class GetEquip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEquip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("text/html; charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        Connection con=null;
        ArrayList<EquipModel> equip_arr = new ArrayList<>();
       try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from tiyu_lunwen.t_equip";  
            ResultSet rs=stmt.executeQuery(sql);  

			
			while(rs.next()) {
				// idt_equip  name  num 
				EquipModel equip = new EquipModel();
				equip.setIdt_equip(rs.getString("idt_equip"));
				equip.setName(rs.getString("name"));
				equip.setNum(rs.getString("num"));
				
				equip_arr.add(equip);
			}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(equip_arr));
            
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
