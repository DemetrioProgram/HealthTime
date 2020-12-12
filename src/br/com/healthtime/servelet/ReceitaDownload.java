package br.com.healthtime.servelet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReceitaDownload
 */
@WebServlet("/ReceitaDownload")
public class ReceitaDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceitaDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		          
		        final String dir="C:\\receita\\";
		        String fileName = request.getParameter("cdConsulta") + ".pdf";
		        File f= new File( dir+fileName);
		        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
		        response.setContentLength((int) f.length()); 
		        OutputStream responseOutputStream = response.getOutputStream();           
		        FileInputStream fis= new FileInputStream(f);
		        DataInputStream dis= new DataInputStream(fis);
		        byte[] dados= new byte[ dis.available()];
		        dis.readFully(dados);
		        responseOutputStream.write(dados);
		        dis.close();
		        fis.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
