package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;
import fmat.proyectoMemo.struts.model.Evento;

@SuppressWarnings("serial")
public class RecoverEventInfoServlet extends HttpServlet{

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecoverEventInfoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doIt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);

		String id_evento = request.getParameter("id_evento");
		String nombre = request.getParameter("nombre") ;
		String fecha_inicio = request.getParameter("fecha_inicio");
		String fecha_final = request.getParameter("fecha_final");
		String hora_inicio =  request.getParameter("hora_inicio");
		String hora_final =  request.getParameter("hora_final");
		String ubicacion = request.getParameter("ubicacion");
		String id_integrante = request.getParameter("id_integrante");
		String id_creador = request.getParameter("id_creador");
		String id_grupo= request.getParameter("id_grupo");
		String hasta_fecha= request.getParameter("hasta_fecha");



		Evento event  = new Evento();
		
		 SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		 Date fecha_inicial = null, fecha_finali = null, hasta_fechaa = null;
		 try {

		     fecha_inicial = (Date) formatoDelTexto.parse(fecha_inicio);
		     fecha_finali = (Date) formatoDelTexto.parse(fecha_final);
		     hasta_fechaa = (Date) formatoDelTexto.parse(hasta_fecha);
		 } catch (ParseException | java.text.ParseException ex) {
		     ex.printStackTrace();
		 }
		
		event.setId_evento(Integer.parseInt(id_evento));
		event.setNombre(nombre);
		event.setFecha_inicio(fecha_inicio);
		event.setFecha_final(fecha_final);
		event.setHora_inicio(hora_inicio);
		event.setHora_final(hora_final);
		event.setUbicacion(ubicacion);
		event.setId_creador(Integer.parseInt(id_creador));
		event.setId_integrante(Integer.parseInt(id_integrante));
		event.setId_grupo(Integer.parseInt(id_grupo));
		
		

		request.setAttribute("evento", event);
		request.getRequestDispatcher("blog.jsp").forward(request, response);
		//}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doIt(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doIt(request, response);

	}

}
