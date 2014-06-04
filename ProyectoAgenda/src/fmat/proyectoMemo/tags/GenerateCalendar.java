package fmat.proyectoMemo.tags;

import	java.io.IOException;
import	java.util.Calendar;
import java.util.Date;
import	java.util.GregorianCalendar;
import	java.text.DateFormat;
import	java.util.StringTokenizer;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;



@SuppressWarnings("serial")
public class GenerateCalendar extends TagSupport {
	Date date = new Date();
	@SuppressWarnings("deprecation")
	int today = date.getDate();


	public int doStartTag() throws JspException {
		GregorianCalendar	cal = null;

		cal = (GregorianCalendar) pageContext.getAttribute( "date",
				PageContext.SESSION_SCOPE );
		if( cal == null )
			throw( new JspException( "date missing from page" ) );
		try {
			generate( pageContext.getOut(), cal );
		}
		catch( IOException e ) {
			throw( new JspException( getClass().getName() + ": " +
					e.toString() ) );
		}
		return( SKIP_BODY );
	}

	private void generate( JspWriter out, GregorianCalendar cal )
			throws IOException {
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
			if( cal.get( Calendar.DATE ) == today){
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
					if(cal.get( Calendar.DATE ) == today){
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