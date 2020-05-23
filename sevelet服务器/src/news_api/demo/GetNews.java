package news_api.demo;

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
import mysql_model.demo.NewsModel;
import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class GetNews
 */
@WebServlet("/GetNews")
public class GetNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetNews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*"); 
		// TODO Auto-generated method stub
				response.setContentType("text/html; charset=UTF-8");  
		        PrintWriter out = response.getWriter();  
		        Connection con=null;
		        ArrayList<NewsModel> news_arr = new ArrayList<>();
		       try  
		        {  
		            con=MysqlConnectorTest.getConnection();  
		            Statement stmt=con.createStatement();  
		            String sql="select * from tiyu_lunwen.t_news";  
		            ResultSet rs=stmt.executeQuery(sql);  

					
					while(rs.next()) {
						// idt_news  title  detail   
						NewsModel news = new NewsModel();
						news.setIdt_news(rs.getString("idt_news"));
						news.setTitle(rs.getString("title"));
						news.setDetail(rs.getString("detail"));
						news.setNews_time(rs.getString("news_time"));
						
						news_arr.add(news);
					}

		        }  
		        catch(Exception ex)  
		        {  
		            ex.printStackTrace();  
		        }  
		        finally  
		        {  
		        	MysqlConnectorTest.Close(null, null, con);

		            response.getWriter().write(JSON.toJSONString(news_arr));
		            
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
