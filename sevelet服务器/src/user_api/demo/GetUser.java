package user_api.demo;

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

import mysql_model.demo.UserModel;
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetUser
 */
@WebServlet("/GetUser")
public class GetUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUser() {
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
        ArrayList<UserModel> user_arr = new ArrayList<>();
       try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from tiyu_lunwen.t_user";  
            ResultSet rs=stmt.executeQuery(sql);  

			
			while(rs.next()) {
				// idt_user  username  account  
				// password  gender  birthday  tel
				 
				UserModel user = new UserModel();
				user.setIdt_user(rs.getString("idt_user"));
				user.setUsername(rs.getString("username"));
				user.setAccount(rs.getString("account"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setBirthday(rs.getString("birthday"));
				user.setTel(rs.getString("tel"));
				user.setType(rs.getString("type"));
				
				user_arr.add(user);
			}

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(user_arr));
            
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
