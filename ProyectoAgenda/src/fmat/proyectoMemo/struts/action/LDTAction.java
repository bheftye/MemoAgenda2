package fmat.proyectoMemo.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOLDT;
import fmat.proyectoMemo.struts.model.ListaDeTareas;
import fmat.proyectoMemo.struts.model.Usuario;

public class LDTAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> mapSession;
	private Usuario usuario;
	private ListaDeTareas ldt;
	
	public String agregarLDT(){
		if(ldt.getFechLimite().equals("") && ldt.getIdCreador() != 0 && ldt.getNombre().equals("")){
			DAOLDT dao = new DAOLDT();
			boolean insercionExitosa = dao.insertarLDT(ldt);
		}
		return "";
	}
	
	
	public ListaDeTareas getLdt() {
		return ldt;
	}

	public void setLdt(ListaDeTareas ldt) {
		this.ldt = ldt;
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
