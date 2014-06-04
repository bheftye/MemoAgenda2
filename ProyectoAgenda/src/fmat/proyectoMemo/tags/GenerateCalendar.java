package fmat.proyectoMemo.tags;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import fmat.proyectoMemo.struts.model.Evento;
import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;



@SuppressWarnings("serial")
public class GenerateCalendar extends TagSupport {
	GregorianCalendar greg = new GregorianCalendar();
	Date date = new Date();
	int today = greg.get(Calendar.DATE);
	int month =greg.get(Calendar.MONTH);
	int year = greg.get(Calendar.YEAR);
	ArrayList<Evento> eventos = new ArrayList<Evento>();


	public int doStartTag() throws JspException {
		GregorianCalendar	cal = null;
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();  
		HttpSession session = request.getSession(false);  

		cal = (GregorianCalendar) pageContext.getAttribute( "date",
				PageContext.SESSION_SCOPE );
		if( cal == null )
			throw( new JspException( "date missing from page" ) );
		try {
			generate( pageContext.getOut(), cal ,session);
		}
		catch( IOException e ) {
			throw( new JspException( getClass().getName() + ": " +
					e.toString() ) );
		}
		return( SKIP_BODY );
	}

	private void generate( JspWriter out, GregorianCalendar cal , HttpSession session)
			throws IOException {
		 getUserEvents(session);
		int		i = -1;
		int		mon = -1;

		cal.set( Calendar.DATE, 1 );
		out.println( "<tr>" );
		out.println( "<th width=\"15%\" class=\"calendar\">Domingo</th>" );
		out.println( "<th width=\"14%\" class=\"calendar\">Lunes</th>" );
		out.println( "<th width=\"14%\" class=\"calendar\">Martes</th>" );
		out.println( "<th width=\"14%\" class=\"calendar\">Miércoles</th>" );
		out.println( "<th width=\"14%\" class=\"calendar\">Jueves</th>" );
		out.println( "<th width=\"14%\" class=\"calendar\">Viernes</th>" );
		out.println( "<th width=\"15%\" class=\"calendar\">Sábado</th>" );
		out.println( "</tr>" );
		out.println( "<tr>" );
		for( i = 1; i <= 7; i++ ) {
			if( (cal.get( Calendar.DATE ) == today) && (cal.get(Calendar.MONTH) == month) && (cal.get(Calendar.YEAR) == year)){
				System.out.println("Fecha 2: " + cal.get( Calendar.DATE ) +"/"+ cal.get(Calendar.MONTH) +"/" + year);
				out.print( getHeaderToday() );
			}else{
				out.print( getHeader( i ));
			}
			if( i == cal.get( Calendar.DAY_OF_WEEK ) ) {
				out.print( cal.get( Calendar.DATE ) );//
				cal.add( Calendar.DATE, 1 );
			}
			else
				out.println( " " );
			out.println( "</td>" );
		}
		out.println( "</tr>" );
		mon = cal.get( Calendar.MONTH );
		while( mon == cal.get( Calendar.MONTH ) ) {
			out.println( "<tr>" );
			for( i = 1; i <= 7; i++ ) {
				if( mon == cal.get( Calendar.MONTH ) ) {
					if( (cal.get( Calendar.DATE ) == today) && (cal.get(Calendar.MONTH) == month) && (cal.get(Calendar.YEAR) == year)){
						out.print( getHeaderToday() );
						out.print( cal.get( Calendar.DATE ) );
						cal.add( Calendar.DATE, 1 );

					}else{
						out.print( getHeader( i ) );
						out.print( cal.get( Calendar.DATE ) );//
						cal.add( Calendar.DATE, 1 );
					}
				}
				else
					out.println( " " );
				out.println( "</td>" );
			}
			out.println( "</tr>" );
		}
		cal.set( Calendar.MONTH, mon );
		cal.set( Calendar.DATE, 1 );
	}

	private void getUserEvents(HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		//creador, integrante
		ArrayList<Grupo> grupos = usuario.getGrupos();
		// le paso el id del grupo
		
	}

	private String getHeader( int dayOfWeek ) {
		String	style = "weekday";

		if( ( dayOfWeek == 1 ) || ( dayOfWeek == 7 ) )
			style = "weekend";
		return( "<td class=\"" + style + "\">" );
	}

	private String getHeaderToday(  ) {
		String	style = "today";
		return( "<td class=\"" + style + "\">" );
	}


}