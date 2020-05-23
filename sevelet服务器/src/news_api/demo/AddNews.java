package news_api.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mysql_test.demo.MysqlConnectorTest;

/**
 * Servlet implementation class AddNews
 */
@WebServlet("/AddNews")
public class AddNews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNews() {
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
		// idt_user  user name  account  password  gender  birthday  t el
		long time = System.currentTimeMillis();
        String news_id = String.valueOf(time/1000);
        
		String title = request.getParameter("title");
		String detail = request.getParameter("detail");
		String news_time = request.getParameter("news_time");
		
		
		
		
//		File txt=new File("E:/log1.txt");
//        if(!txt.exists()){  
//            txt.createNewFile();  
//       }  
//        byte bytes[]=new byte[512];   
//        bytes=str.getBytes();  
//        int b=bytes.length;   //是字节的长度，不是字符串的长度
//        FileOutputStream fos=new FileOutputStream(txt); 
//        fos.write(bytes,0,b); 
//        fos.write(bytes);
//        fos.close();
        
        //动态获取服务器的路径
        String serverpath = request.getServletContext().getRealPath("static");
//        System.out.println(serverpath);
        
        
        
//        FileOutputStream fos = new FileOutputStream(serverpath + "/"+ news_id + ".txt");
//
//        
//        byte bytes[]=new byte[512];   
//        bytes=detail.getBytes();  
//        int b=bytes.length;   
//        fos.write(bytes,0,b); 
//        fos.write(bytes);
//        fos.close();
        
        
        OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(serverpath + "/"+ news_id + ".txt"), "utf-8");
        oStreamWriter.append(detail);
        oStreamWriter.close();
        

        
        
//        byte[] bty = new byte[1024];
//        int length =0;
//        while((length=is.read(bty))!=-1){
//            fos.write(bty,0,length);
//        }
//        
//        fos.close();
        
        
        String aaa = request.getSession().getServletContext().getRealPath("static");
//        String bbb = aaa.substring(0 , aaa.indexOf(".metadata"));
//        String ccc = request.getContextPath();
//        System.out.println(ccc);
//        String ddd = ccc.substring(ccc.indexOf("/") , ccc.length());
        

        
        
        oStreamWriter = new OutputStreamWriter(new FileOutputStream(aaa + "/"+ news_id + ".txt"), "utf-8");
        oStreamWriter.append(detail);
        oStreamWriter.close();
        
        
		
		
		
		
		PrintWriter out = response.getWriter(); 
		Connection con=null;
		
		String back_string = "";
		back_string = "{\"err\": 0 , \"msg\":\"操作成功\"}";
		
		try  
        {  
			con=MysqlConnectorTest.getConnection();  
	        Statement stmt=con.createStatement();  
	        // idt_user  user name  account  password  gender  birthday  t el
	        String sql="insert into tiyu_lunwen.t_news (idt_news , title , detail , news_time) values ('" + news_id + "' , '" + title + "' , '" + news_id + ".txt" + "', '" + news_time + "')";
	        // 查询用下面的
	        // stmt.executeQuery(sql);
	        Boolean rs=stmt.execute(sql);
	        
//	        long time = System.currentTimeMillis();
//	        String t = String.valueOf(time/1000); 
//	        System.out.println("zzzz");
//	        System.out.println(rs);
	        
	        
	        
	       

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




/**
 * 字符串和输入流互转类
 */
class StreamUtil {
 
    /**
     * 将一个字符串转化为输入流
     *
     * @param sInputString
     * @return
     */
    public static InputStream getStrToStream(String sInputString) {
        if (sInputString != null && !sInputString.trim().equals("")) {
            try {
                ByteArrayInputStream tInputStringStream = new ByteArrayInputStream(sInputString.getBytes());
                return tInputStringStream;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
 
    /**
     * 将一个输入流转化为字符串
     *
     * @param tInputStream
     * @return
     */
    public static String getStreamToStr(InputStream tInputStream) {
        if (tInputStream != null) {
            try {
                BufferedReader tBufferedReader = new BufferedReader(new InputStreamReader(tInputStream));
                StringBuffer tStringBuffer = new StringBuffer();
                String sTempOneLine;
                while ((sTempOneLine = tBufferedReader.readLine()) != null) {
                    tStringBuffer.append(sTempOneLine);
                }
                return tStringBuffer.toString();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
 
}
