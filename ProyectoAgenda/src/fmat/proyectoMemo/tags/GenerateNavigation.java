
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

@SuppressWarnings("serial")
public class GenerateNavigation extends TagSupport {

	public int doStartTag() throws JspException {
		try {
			generate( pageContext.getOut() );
		}
		catch( IOException e ) {
			throw( new JspException( getClass().getName() + ": " +
					e.toString() ) );
		}
		return( SKIP_BODY );
	}

	private void generate( JspWriter out )
			throws IOException {
		String	prefix = "<td class=\"navigation\"><input class=\"submit\" type=\"submit\" name=\"submit\" " +
				"value = \"";
		String	suffix = "\"></td>";

		out.println( "<tr>" );
		out.println( "<th class=\"navigation\">" +
				"</th>" );
		out.println( "<th class=\"navigation\">" +
				"</th>" );
		out.println( "<th class=\"navigation\">" +
				"</th>" );
		out.println( "<th class=\"navigation\">" +
				"</th>" );
		out.println( "<th class=\"navigation\">" +
				"</th>" );
		out.println( "</tr>" );
		out.println( "<tr>" );
		out.println( prefix + "Año anterior" + suffix );
		out.println( prefix + "Mes anterior" + suffix );
		out.println( prefix + "Mes Actual" + suffix );
		out.println( prefix + "Siguiente mes" + suffix );
		out.println( prefix + "Siguiente año" + suffix );
		out.println( "</tr>" );
	}
}
