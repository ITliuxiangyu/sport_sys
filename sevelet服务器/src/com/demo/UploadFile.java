package com.demo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.InputStream;




/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setHeader("Access-Control-Allow-Origin", "*"); 
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Part part = request.getPart("myfile");
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
          //随机的生存一个32的字符串
        long time = System.currentTimeMillis();
        String filename = String.valueOf(time/1000) + suffix;
        
          //获取上传的文件名
        InputStream is = part.getInputStream();
        //动态获取服务器的路径
        String serverpath = request.getServletContext().getRealPath("static");
//        System.out.println(serverpath);
        FileOutputStream fos = new FileOutputStream(serverpath + "/"+filename);
        
        
        
        
        
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        
        fos.close();
        
        
        String aaa = request.getSession().getServletContext().getRealPath("static");
//        String bbb = aaa.substring(0 , aaa.indexOf(".metadata"));
//        String ccc = request.getContextPath();
////        System.out.println(ccc);
//        String ddd = ccc.substring(ccc.indexOf("/") , ccc.length());
//        fos = new FileOutputStream(bbb + ddd + "/WebContent/static/"+filename);
        fos = new FileOutputStream(aaa + "/"+filename);
        
        bty = new byte[1024];
        length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        
        
        fos.close();
        is.close();
        
        response.getWriter().write("{\"err\":0 , \"msg\": \"上传成功\" , \"img\":\"" + filename + "\"}");
        
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
