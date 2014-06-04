package fmat.proyectoMemo.struts.model;

public class Tarea {
	private int idTarea;
	private int idLDT;
	private String nombre;
	private String descripcion;
	private int idResponsable;
	private int status;
	
	
	
	public Tarea(int idTarea, int idLDT, String nombre, String descripcion,
			int idResponsable, int status) {
		super();
		this.idTarea = idTarea;
		this.idLDT = idLDT;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.idResponsable = idResponsable;
		this.status = status;
	}
	
	public Tarea(){}
	
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdResponsable() {
		return idResponsable;
	}
	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
