package fmat.proyectoMemo.struts.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOGrupo;
import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

public class GrupoAction  extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 1L;
	
	private Grupo grupo;
	private Map<String, Object> mapSession;
	private Usuario usuario;
	private String htmlAgregarContactos;
	
	public String crearGrupo(){
		String texto = "No se realizó la operación, intentalo de nuevo";
		if(!grupo.getNombre().equals("")){
			DAOGrupo dao = new DAOGrupo();
			boolean insercionExitosa = dao.insetarGrupo(grupo);
			if(insercionExitosa){
				this.generarContactosAAgregar();
				return "editGroup";
			}
		}
		addActionError(texto);
		return "createGroup";
	}
	
	public String mostrarGrupo(){
		if(!(grupo.getIdGrupo() == 0 && grupo.getIdGrupo() < 0)){
			DAOGrupo dao = new DAOGrupo();
			grupo = dao.obtenerGrupoPorId(grupo.getIdGrupo());
			this.generarContactosAAgregar();
			return "editGroup";
		}
		return "about";
	}
	
	public String agregarIntegrante(){
		if(grupo.getIdGrupo() != 0){
			DAOGrupo dao = new DAOGrupo();
			boolean esIntegrante = dao.esIntegrante(grupo.getIdGrupo(), usuario.getIdUsuario());
			if(!esIntegrante){
				boolean insercionExitosa = dao.insertarIntegranteEnGrupo(grupo.getIdGrupo(), usuario.getIdUsuario());
				if(insercionExitosa){
					grupo = dao.obtenerGrupoPorId(grupo.getIdGrupo());
					this.generarContactosAAgregar();
					addActionError("Usuario agregado al grupo.");
					return "editGroup";
				}
				addActionError("Ocurrio un error, intentalo de nuevo.");
				grupo = dao.obtenerGrupoPorId(grupo.getIdGrupo());
				this.generarContactosAAgregar();
				return "editGroup";
			}
			addActionError("Ya es un integrante del grupo");
			grupo = dao.obtenerGrupoPorId(grupo.getIdGrupo());
			this.generarContactosAAgregar();
			return "editGroup";
			
		}
		addActionError("No se realizo ninguna operación");
		return "editGroup";
	}
	
	public void generarContactosAAgregar(){
		ArrayList<Usuario> contactos = ((Usuario) mapSession.get("usuario")).getContactos();
		htmlAgregarContactos = "<table><tr><th>Alias</th><th>Agregar</th></tr>";
		Usuario usuarioIndexado = null;
		for (int i = 0; i < contactos.size(); i++) {
			usuarioIndexado = contactos.get(i);
			htmlAgregarContactos += "<tr><td>" + usuarioIndexado.getAlias()
					+ "</td>";
			htmlAgregarContactos += "<td><form action=\"agregarIntegrante\">"
					+ "<input type=\"hidden\" name=\"usuario.idUsuario\" value=\""
					+ usuarioIndexado.getIdUsuario()
					+ "\" />"
					+ "<input type=\"hidden\" name=\"grupo.idGrupo\" value=\""
					+ grupo.getIdGrupo()
					+ "\" />"
					+ "<input type=\"submit\" class=\"submit\" value=\"Agregar\" />"
					+ "</form></td></tr>";
		}
		htmlAgregarContactos += "</table>";
	}
	
	
	public String getHtmlAgregarContactos() {
		return htmlAgregarContactos;
	}

	public void setHtmlAgregarContactos(String htmlAgregarContactos) {
		this.htmlAgregarContactos = htmlAgregarContactos;
	}

	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	@Override
	public void setSession(Map<String, Object> mapSession) {
		// TODO Auto-generated method stub
		this.mapSession = mapSession;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}
}	
