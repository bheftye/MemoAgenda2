package fmat.proyectoMemo.struts.model;

import java.util.ArrayList;

public class ListaDeTareas {

	private int idLDT;
	private String nombre;
	private String fechLimite;
	private int idCreador;
	private int status;
	private ArrayList<Tarea> tareas;
	
	public ListaDeTareas(int idLDT, String nombre, String fechLimite,
			int idCreador, int status, ArrayList<Tarea> tareas) {
		super();
		this.idLDT = idLDT;
		this.nombre = nombre;
		this.fechLimite = fechLimite;
		this.idCreador = idCreador;
		this.status = status;
		this.tareas = tareas;
	}
	
	public ListaDeTareas(){}
	
	public int getIdLDT() {
		return idLDT;
	}
	public void setIdLDT(int idLDT) {
		this.idLDT = idLDT;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFechLimite() {
		return fechLimite;
	}
	public void setFechLimite(String fechLimite) {
		this.fechLimite = fechLimite;
	}
	public int getIdCreador() {
		return idCreador;
	}
	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public ArrayList<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(ArrayList<Tarea> tareas) {
		this.tareas = tareas;
	}
	
	
}
