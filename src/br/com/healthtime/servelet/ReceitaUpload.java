package br.com.healthtime.servelet;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;

/**
 * Servlet implementation class ReceitaUpload
 */
@WebServlet("/ReceitaUpload")
public class ReceitaUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceitaUpload() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (FileUpload.isMultipartContent(request)) {
			String idConsulta = request.getParameter("cdConsulta");
			DiskFileUpload upload = new DiskFileUpload();
			upload.setSizeMax(50 * 1024 * 1024); // 50Mb
			List items = null;
			try {
				items = upload.parseRequest(request);
				Iterator it = items.iterator();
				while (it.hasNext()) {
					FileItem fitem = (FileItem) it.next();
					String fileName = idConsulta;
					if (!fitem.isFormField()) {
						File f = new File("C:\\receita\\"+fileName+".pdf");
						FileOutputStream fo = new FileOutputStream(f);
						DataOutputStream dados = new DataOutputStream(fo);
						byte[] b = fitem.get();
						dados.write(b, 0, (int) fitem.getSize());
						dados.close();
						fo.close();
						System.out.println(f.getAbsolutePath());
					}

				}
				
				String msg = "Sucesso";
				request.setAttribute("msg", msg);
				
				RequestDispatcher rd = request.getRequestDispatcher("AdicionarReceita.jsp");
				rd.forward(request, response);
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
