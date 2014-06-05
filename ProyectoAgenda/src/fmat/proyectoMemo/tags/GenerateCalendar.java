package fmat.proyectoMemo.tags;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import fmat.proyectoMemo.struts.dao.DAOEvento;
import fmat.proyectoMemo.struts.model.Evento;
import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;



@SuppressWarnings("serial")
public class GenerateCalendar extends TagSupport {
	GregorianCalendar greg = new GregorianCalendar();
	int today = greg.get(Calendar.DATE);
	int month =greg.get(Calendar.MONTH);
	int year = greg.get(Calendar.YEAR);
	ArrayList<Evento> eventos = new ArrayList<Evento>();
	DAOEvento daoEv = new DAOEvento();
	Calendar cal2 = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	String extra = "";
	HttpServletRequest request;

	public int doStartTag() throws JspException {
		GregorianCalendar	cal = null;
		 request = (HttpServletRequest) pageContext.getRequest();  
		HttpSession session = request.getSession(false);  

		cal = (GregorianCalendar) pageContext.getAttribute( "date",
				PageContext.SESSION_SCOPE );
		if( cal == null )
			throw( new JspException( "date missing from page" ) );
		try {
			generate( pageContext.getOut(), cal ,session);
		}
		catch( IOException | ParseException e ) {
			throw( new JspException( getClass().getName() + ": " +
					e.toString() ) );
		}
		return( SKIP_BODY );
	}

	private void generate( JspWriter out, GregorianCalendar cal , HttpSession session)
			throws IOException, ParseException {
		int	i = -1;
		int	mon = -1;

		getUserEvents(session);

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
			extra = "";
			if( (cal.get( Calendar.DATE ) == today) && (cal.get(Calendar.MONTH) == month) && (cal.get(Calendar.YEAR) == year)){
				out.print( getHeaderToday() );
			}else{
				out.print( getHeader( i ));
			}
			if( i == cal.get( Calendar.DAY_OF_WEEK ) ) {
				out.print( cal.get( Calendar.DATE));//
				for (int j = 0; j < eventos.size(); j++) {
					System.out.println("FOR || " + eventos.get(j).toString());
					cal2.setTime(sdf.parse(eventos.get(j).getFecha_inicio()));// all done
					int day = cal2.get(Calendar.DATE);
					int monthAux = cal2.get(Calendar.MONTH);
					int yearAux = cal2.get(Calendar.YEAR);
					String fecha_evento = day + "/" + monthAux +"/" +yearAux;
					String fecha_calendario =cal.get( Calendar.DATE ) + "/" + cal.get( Calendar.MONTH) +"/" +cal.get( Calendar.YEAR );
					System.out.println("FOR || " + fecha_evento);
					System.out.println("FOR || " +  fecha_calendario);
					if(fecha_evento.equals(fecha_calendario)){
						System.out.println("FOR >>> Son la misma fecha");
						String ahref = "<a href=\"showInfo?idEvento="+eventos.get(j).getId_evento()+"\" style=\"text-decoration:none; color:white\">";
						extra = "<br />"+ ahref +"<font size=\"2\">*" + eventos.get(j).getNombre() +"</font></a>";
						System.out.println("FOR >>>>" + extra);
						out.print( extra );
					}else{
						extra = "";
					}
				}
				extra = "";
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
					}else{
						out.print( getHeader( i ) );
					}
					out.print( cal.get( Calendar.DATE ) );

					for (int j = 0; j < eventos.size(); j++) {
						System.out.println("FOR || " + eventos.get(j).toString());
						cal2.setTime(sdf.parse(eventos.get(j).getFecha_inicio()));// all done
						int day = cal2.get(Calendar.DATE);
						int monthAux = cal2.get(Calendar.MONTH);
						int yearAux = cal2.get(Calendar.YEAR);
						String fecha_evento = day + "/" + monthAux +"/" +yearAux;
						String fecha_calendario =cal.get( Calendar.DATE ) + "/" + cal.get( Calendar.MONTH) +"/" +cal.get( Calendar.YEAR );
						System.out.println("FOR || " + fecha_evento);
						System.out.println("FOR || " +  fecha_calendario);
						if(fecha_evento.equals(fecha_calendario)){
							System.out.println("FOR >>> Son la misma fecha");
							String ahref = "<a href=\"showInfo?idEvento="+eventos.get(j).getId_evento()+"\" style=\"text-decoration:none; color:white\">";
							extra = "<br />"+ ahref +"<font size=\"2\">*" + eventos.get(j).getNombre() +"</font></a>";
							System.out.println("FOR >>>>" + extra);
							out.print( extra );
						}else{
							extra = "";
						}
					}
					cal.add( Calendar.DATE, 1 );
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
		int id_usuario = usuario.getIdUsuario();

		eventos = daoEv.recuperarEventosDelUsuario(id_usuario);
		for (int i = 0; i < eventos.size(); i++) {
			System.out.println(eventos.get(i).toString());
		}}


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