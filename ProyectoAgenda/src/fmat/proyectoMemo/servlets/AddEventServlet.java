package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
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
		String repeat = null;

		//Obteniendo el arreglo de integrantes
		String[] integrantes = request.getParameterValues("integrantes");
		String[] grupos = request.getParameterValues("grupos");

		//Obteniendo el arreglo de recordatorio
		String[] repeticion = request.getParameterValues("repeticion");


		/*SimpleDateFormat formatoDelTexto = new SimpleDateFormat("MM/dd/yyyy");
		Date fecha_inicial = null, fecha_finali = null, hasta_fechaa = null;*/
		repeat = repeticion[0]+"";

		if(nombre.isEmpty() || ubicacion.isEmpty() || fecha_inicio.isEmpty() || fecha_final.isEmpty() || hora_inicio.isEmpty()
				|| hora_final.isEmpty()){
			request.setAttribute("errorMessage", "Quedaron campos obligatorios vacíos... <br /><br />");
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}else{
			boolean result = true;
			if((integrantes == null)&& (grupos == null)){	
				if(repeat.equals("0")){
					Evento evento = new Evento(id_creador,nombre, fecha_inicio,fecha_final, hora_inicio, hora_final, ubicacion);
					result = daoEv.agregarEvento(evento, repeat );
					}else{
						String hasta_fecha= request.getParameter("hasta_fecha");
						Evento evento = new Evento(id_creador,nombre, fecha_inicio,fecha_final, hora_inicio, hora_final, ubicacion);
				}



				if(result){
					request.getRequestDispatcher("blog.jsp").forward(request, response);
				}else{
					request.setAttribute("errorMessage", "Hubo un error al agregar el evento. <br /><br />");
					request.getRequestDispatcher("addevent.jsp").forward(request, response);
				}
			}else{
				if((integrantes != null ) && (grupos == null)){

				}

			}

		}

		System.out.println("Id creador:" + id_creador );
		System.out.println("Nombre del evento:" + nombre );
		System.out.println("Ubicacion:" + ubicacion );
		System.out.println("Fecha inicio:" + fecha_inicio );
		System.out.println("Fecha final:" + fecha_final );
		System.out.println("Repeticion:" + repeat );

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
