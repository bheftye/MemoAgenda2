package fmat.proyectoMemo.tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

@SuppressWarnings("serial")
public class ShowGroups extends TagSupport {

	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();  
		HttpSession session = request.getSession(false);  
		generate( pageContext.getOut(), session);
		return( SKIP_BODY );
	}



	private void generate(JspWriter out, HttpSession session) {
		// TODO Auto-generated method stub
		String preffix ="<tr><td></td><td><input type=\"checkbox\" name=\"grupos\" value=\"";
		String ffix= "\">";
		String suffix ="</td></tr>";
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		ArrayList<Grupo> grupos = usuario.getGrupos();
		try {
			for (int i = 0; i < grupos.size(); i++) {
				Grupo grupo = (Grupo) grupos.get(i);
				out.println(preffix + grupo.getIdGrupo() + ffix + grupo.getNombre() + suffix);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
