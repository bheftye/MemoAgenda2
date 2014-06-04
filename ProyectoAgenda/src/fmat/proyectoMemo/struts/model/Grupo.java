package fmat.proyectoMemo.struts.model;

import java.util.ArrayList;

public class Grupo {
	
	private int idGrupo;
	private String nombre;
	private int idUsuarioCreador;
	private ArrayList<Usuario> integrantes;
	private int status;
	
	
	public Grupo(int idGrupo, String nombre, int idUsuarioCreador,
			ArrayList<Usuario> integrantes, int status) {
		super();
		this.idGrupo = idGrupo;
		this.nombre = nombre;
		this.idUsuarioCreador = idUsuarioCreador;
		this.integrantes = integrantes;
		this.status = status;
	}
	
	public Grupo(){}
	
	public int getIdGrupo() {
		return idGrupo;
	}
	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdUsuarioCreador() {
		return idUsuarioCreador;
	}
	public void setIdUsuarioCreador(int idUsuarioCreador) {
		this.idUsuarioCreador = idUsuarioCreador;
	}
	public ArrayList<Usuario> getIntegrantes() {
		return integrantes;
	}
	public void setIntegrantes(ArrayList<Usuario> integrantes) {
		this.integrantes = integrantes;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
