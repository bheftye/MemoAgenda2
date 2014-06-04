package fmat.proyectoMemo.struts.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOLDT;
import fmat.proyectoMemo.struts.dao.DAOTarea;
import fmat.proyectoMemo.struts.model.ListaDeTareas;
import fmat.proyectoMemo.struts.model.Tarea;
import fmat.proyectoMemo.struts.model.Usuario;

public class LDTAction extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> mapSession;
	private Usuario usuario;
	private ListaDeTareas ldt;
	private Tarea tarea;
	
	public String agregarLDT(){
		if(!(ldt.getFechLimite().equals("") && ldt.getIdCreador() != 0 && ldt.getNombre().equals(""))){
			DAOLDT dao = new DAOLDT();
			boolean insercionExitosa = dao.insertarLDT(ldt);
			if(insercionExitosa){
				return "editLDT";
			}
		}
		addActionError("Llena todos los campos para continuar.");
		return "addLDT";
	}
	
	public String modificarLDT(){
		if(!ldt.getFechLimite().equals("") && !ldt.getNombre().equals("")){
			DAOLDT dao = new DAOLDT();
			boolean insercionExitosa = dao.insertarLDT(ldt);
			if(insercionExitosa){
				addActionError("Cambio realizado correctamente.");
				return "editLDT";
			}
		}
		addActionError("Cambio no realizado correctamente.");
		return "editLDT";
	}
	
	public String insertarTarea(){
		if(!tarea.getNombre().equals("") && !tarea.getDescripcion().equals("")){
			DAOTarea dao = new DAOTarea();
			boolean insercionExitosa = dao.insertarTarea(tarea);
			if(insercionExitosa){
				return "editTask";
			}
		}
		return "addTask";
	}
	
	public String modificarTarea(){
		if(!tarea.getNombre().equals("") && !tarea.getDescripcion().equals("")){
			DAOTarea dao = new DAOTarea();
			boolean insercionExitosa = dao.modificarTarea(tarea);
			if(insercionExitosa){
				return "editLDT";
			}
		}
		addActionError("No se realizó la operación");
		return "editTask";
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

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	
}
