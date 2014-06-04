package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import fmat.proyectoMemo.struts.dao.DAOEvento;
import fmat.proyectoMemo.struts.model.Evento;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet {
	DAOEvento daoEv = new DAOEvento();
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddEventServlet() {

	}
	public void doIt(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id_creador = Integer.parseInt(request.getParameter("idUsuario"));
		String nombre = request.getParameter("nombre");
		String ubicacion = request.getParameter("ubicacion");
		String fecha_inicio = request.getParameter("fecha_inicio");
		String fecha_final = request.getParameter("fecha_final");
		String hora_inicio =  request.getParameter("hora_inicio");
		String hora_final =  request.getParameter("hora_final");

		//Obteniendo el arreglo de integrantes
		String[] integrantes = request.getParameterValues("integrantes");
		String[] grupos = request.getParameterValues("grupos");



		/*SimpleDateFormat formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
		Date fecha_inicial = null, fecha_finali = null, hasta_fechaa = null;*/

		if(nombre.isEmpty() || ubicacion.isEmpty() || fecha_inicio.isEmpty() || fecha_final.isEmpty() || hora_inicio.isEmpty()
				|| hora_final.isEmpty()){
			request.setAttribute("errorMessage", "Quedaron campos obligatorios vacÃ­os... <br /><br />");
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}else{
			boolean result = true;
			if((integrantes == null)&& (grupos == null)){	
					Evento evento = new Evento(id_creador,nombre, fecha_inicio,fecha_final, hora_inicio, hora_final, ubicacion);
					result = daoEv.agregarEvento(evento );
				if(result){
					request.getRequestDispatcher("blog.jsp").forward(request, response);
				}else{
					request.setAttribute("errorMessage", "Hubo un error al agregar el evento. <br /><br />");
					request.getRequestDispatcher("addevent.jsp").forward(request, response);
				}
			}else{
				if((integrantes != null ) && (grupos == null)){
					Evento evento = new Evento(id_creador,nombre, fecha_inicio,fecha_final, hora_inicio, hora_final, ubicacion);
					result = daoEv.agregarEventoIntegrantes(evento,integrantes);
				if(result){
					request.getRequestDispatcher("blog.jsp").forward(request, response);
				}else{
					request.setAttribute("errorMessage", "Hubo un error al agregar el evento. <br /><br />");
					request.getRequestDispatcher("addevent.jsp").forward(request, response);
				}
				}else{
					if((integrantes == null ) && (grupos != null)){
						Evento evento = new Evento(id_creador,nombre, fecha_inicio,fecha_final, hora_inicio, hora_final, ubicacion);
						result = daoEv.agregarEventoGrupos(evento,grupos);
					if(result){
						request.getRequestDispatcher("blog.jsp").forward(request, response);
					}else{
						request.setAttribute("errorMessage", "Hubo un error al agregar el evento. <br /><br />");
						request.getRequestDispatcher("addevent.jsp").forward(request, response);
					}
				}

			}

		}

		System.out.println("Id creador:" + id_creador );
		System.out.println("Nombre del evento:" + nombre );
		System.out.println("Ubicacion:" + ubicacion );
		System.out.println("Fecha inicio:" + fecha_inicio );
		System.out.println("Fecha final:" + fecha_final );
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doIt(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doIt(request, response);
	}

}
