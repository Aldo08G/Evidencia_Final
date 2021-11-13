package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDaoImpl;
import model.UsuarioDAO;


@WebServlet(name = "/registro", urlPatterns = {"/registro"})
public class registro extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	try (PrintWriter out = response.getWriter()) {
    		String nombre = request.getParameter("nombre");
    		String apellido = request.getParameter("apellido");
    		String edad = request.getParameter("edad");
    		String sexo = request.getParameter("sexo");
    		String usuario = request.getParameter("usuario");
    		String password = request.getParameter("password");
    		
    		Usuario user = new Usuario(nombre, apellido, edad, sexo, usuario, password);
    		
    		if (consultar(user).getId() == 0) {
    			registrar(user);
    			validar(user);
    			request.setAttribute("usuarioRegistrado", "Tu usuario fue registrado exitosamente");
    			request.getRequestDispatcher("/calculoIMC.jsp").forward(request, response);
    		} else {
    			request.setAttribute("usuarioExistente", "El usuario ya existe, intentalo nuevamente");
    			request.getRequestDispatcher("/calculoIMC.jsp").forward(request, response);
    		}
    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void registrar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDaoImpl();
		dao.registrar(usuario);
	}
	
	public void validar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDaoImpl();
		dao.validar(usuario);
	}
	
	public Usuario consultar(Usuario usuario) {
		UsuarioDAO dao = new UsuarioDaoImpl();
		return dao.consultar(usuario);
	}
}
