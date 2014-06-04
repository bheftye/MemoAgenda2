package fmat.proyectoMemo.tags;

import	java.io.IOException;
import	java.util.Calendar;
import	java.util.GregorianCalendar;
import	java.text.DateFormat;
import	java.util.StringTokenizer;

import	javax.servlet.jsp.tagext.TagSupport;
import	javax.servlet.jsp.JspException;
import	javax.servlet.jsp.JspWriter;
import	javax.servlet.jsp.PageContext;
import	javax.servlet.http.HttpServletRequest;

@SuppressWarnings("serial")
public class SetDate extends TagSupport {

	private static final String	months[] = {
		"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
		"Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };

	public int doStartTag() throws JspException {
		HttpServletRequest	req = null;
		GregorianCalendar	cal = null;
		StringTokenizer	st = null;
		String		cmd = null;
		int		i = -1;

		cal = (GregorianCalendar) pageContext.getAttribute( "date",
				PageContext.SESSION_SCOPE );
		if( cal == null ) {
			cal = new GregorianCalendar();
			cal.set( Calendar.DATE, 1 );
			pageContext.setAttribute( "date", cal,
					PageContext.SESSION_SCOPE );
		}
		req = (HttpServletRequest) pageContext.getRequest();
		cmd = req.getParameter( "submit" );
		if( cmd != null ) {
			if( cmd.equals( "Año anterior" ) )
				cal.roll( Calendar.YEAR, -1 );
			if( cmd.equals( "Mes anterior" ) )
				cal.roll( Calendar.MONTH, -1 );
			if( cmd.equals( "Mes Actual" ) ) {
				cal = new GregorianCalendar();
				cal.set( Calendar.DATE, 1 );
			}
			if( cmd.equals( "Siguiente mes" ) )
				cal.roll( Calendar.MONTH, 1 );
			if( cmd.equals( "Siguiente año" ) )
				cal.roll( Calendar.YEAR, 1 );
			pageContext.setAttribute( "date", cal,
					PageContext.SESSION_SCOPE );
		}
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

		out.println( "<h1>" +
				months[cal.get( Calendar.MONTH )] + " " +
				cal.get( Calendar.YEAR ) + "</h1>" );
	}
}