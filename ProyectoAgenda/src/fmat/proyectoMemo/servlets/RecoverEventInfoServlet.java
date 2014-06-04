package fmat.proyectoMemo.servlets;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import fmat.proyectoMemo.struts.model.Evento;

@SuppressWarnings("serial")
@WebServlet("/showInfo")
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

		String idEvento = request.getParameter("idEvento");
		Evento event = new Evento();


		request.setAttribute("eventoInfo", idEvento);
		request.getRequestDispatcher("showevent.jsp").forward(request, response);
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
