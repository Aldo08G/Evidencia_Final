package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.IMC;
import model.ImcDAO;
import model.ImcDaoImpl;


@WebServlet(name = "/calculoIMC", urlPatterns = {"/calculoIMC"})
public class calculoIMC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      	response.setContentType("text/html;charset=UTF-8");
      	
    	try (PrintWriter out = response.getWriter()) {
    		
      	String peso = request.getParameter("peso");
      	String estatura = request.getParameter("estatura");
      	
      	IMC i = new IMC(peso, estatura);
      	
      	if (verHistorico(i).getId() == 0) {
      		registrarImc(i);
		request.setAttribute("imc", i);
		request.getRequestDispatcher("/historial.jsp").forward(request, response);
		}
	}	
}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void registrarImc(IMC imc) {
		ImcDAO dao = new ImcDaoImpl();
		dao.registrarImc(imc);
	}
	
	public void verHistorico(IMC imc) {
		ImcDAO dao = new ImcDaoImpl();
		dao.verHistorico(imc);
	}
}
