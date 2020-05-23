package com.demo;

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
  
import net.sf.json.JSONObject; 
import mysql_test.demo.MysqlConnectorTest;
import mysql_test.demo.Ad;
import com.alibaba.fastjson.JSON;

/**
 * Servlet implementation class CeshiApi
 */
@WebServlet("/CeshiApi")
public class CeshiApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CeshiApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		
		
		String ID = request.getParameter("username"); //用于接收android前台的输入的值，此处参数必须要与你前台的值相对应
        String PW= request.getParameter("password");  
        boolean type=false;//用于判断账号和密码是否与数据库中查询结果一致  
        response.setContentType("text/html; charset=UTF-8");  
        PrintWriter out = response.getWriter();  
        Connection con=null;
        JSONObject json = new JSONObject();
//        Ad[] ads = {};
        ArrayList<Ad> ads = new ArrayList<>();
       //   JsonConfig jsonConfig = new JsonConfig();
       // jsonConfig.registerJsonValueProcessor(java.sql.Date.class,new JsonDateValueProcessor());
        try  
        {  
            con=MysqlConnectorTest.getConnection();  
            Statement stmt=con.createStatement();  
            String sql="select * from jiafuxiang_db.ad";  
            ResultSet rs=stmt.executeQuery(sql);  
            
            
//            Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery(sql);
			
//			Ad ad = new Ad();
//			ad.setId(321);
//			ad.setPosition("1111");
//			ad.setImgs("imgssssss");
//			ads.add(ad);
			
			while(rs.next()) {
				Ad ad = new Ad();
				ad.setId(rs.getString("adid"));
				ad.setPosition(rs.getString("position"));
				ad.setImgs(rs.getString("imgs"));
				ads.add(ad);
			}
			//将数据库中查询到的信息封装在user对象中，use对象保存在request中，之后将通过request对象将数据传递到页面
			//需要的话也可以只传递一个参数request.setAttribute("id", user.getId());
			

        }  
        catch(Exception ex)  
        {  
            ex.printStackTrace();  
        }  
        finally  
        {  
        	MysqlConnectorTest.Close(null, null, con);

            response.getWriter().write(JSON.toJSONString(ads));
            
//            String userJson = JSON.toJSONString(user);
            
            out.flush();  
            out.close();  
        } 
        
        
        response.setHeader("content-type", "text/html;charset=UTF-8");
		 
		response.setCharacterEncoding("UTF-8");
		
		
		
		
//		response.setHeader("content-type", "text/html;charset=UTF-8");
//		 
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write("我是个 测试 ceshi 接口");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
