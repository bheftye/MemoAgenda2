package fmat.proyectoMemo.tags;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import fmat.proyectoMemo.struts.dao.DAOEvento;
import fmat.proyectoMemo.struts.model.Evento;
import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

@SuppressWarnings("serial")
public class ShowEventInfo extends TagSupport{
	DAOEvento daoEv = new DAOEvento();
	public int doStartTag() throws JspException {
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();  
		HttpSession session = request.getSession(false);  
		generate( pageContext.getOut(), session);
		return( SKIP_BODY );
	}
	
	int id_evento;

	private void generate(JspWriter out, HttpSession session) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> integrantes = daoEv.recuperarIntegrantes(id_evento);
		ArrayList<Grupo> grupos = daoEv.recuperarGrupos(id_evento);
		Evento evento = daoEv.recuperarEvento(id_evento);
		
		String preffix ="<tr><td><b>";
		String ffix =" </b></td><td>";
		String suffix ="</td></tr>";

		try {
			System.out.println("Id evento:" + id_evento);
			out.println(preffix + "Nombre del evento:" + ffix +evento.getNombre() + suffix);
			out.println(preffix + "Descripción:" + ffix +evento.getDescripcion() + suffix);
			out.println(preffix + "Lugar:" + ffix +evento.getUbicacion() + suffix);
			out.println(preffix + "Fecha de inicio:" + ffix +evento.getFecha_inicio()+ suffix);
			out.println(preffix + "Fecha de finalización:  " + ffix +evento.getFecha_final() + suffix);
			out.println(preffix + "Hora inicio:" + ffix +evento.getHora_inicio() + suffix);
			out.println(preffix + "Hora final:" + ffix +evento.getHora_final() + suffix);
			out.println(preffix + "Integrantes:" + ffix + suffix);

			for (int i = 0; i < integrantes.size(); i++) {
				Usuario integrante = (Usuario) integrantes.get(i);
				out.println(preffix + ffix + integrante.getNombre() +" [" +integrante.getAlias()+"]" + suffix);
			}
			
			out.println(preffix + "Grupos:" + ffix + suffix);

			for (int i = 0; i < grupos.size(); i++) {
				Grupo grupo = (Grupo) grupos.get(i);
				out.println(preffix + ffix + grupo.getNombre() + suffix);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
	public int getId_evento() {
		return id_evento;
	}



	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}

}
