package fmat.proyectoMemo.struts.model;

import java.util.ArrayList;

public class Usuario {
	private int idUsuario;
	private String alias;
	private String contrasena;
	private String nombre;
	private String correo;
	private String foto;
	private ArrayList<Usuario> contactos;
	private ArrayList<Grupo> grupos;
	private ArrayList<ListaDeTareas> ldts;
	
	public Usuario(int idUsuario, String alias, String contrasena,
			String nombre, String correo, String foto, ArrayList<Usuario> contactos, ArrayList<Grupo> grupos,ArrayList<ListaDeTareas> ldts) {
		super();
		this.idUsuario = idUsuario;
		this.alias = alias;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.correo = correo;
		this.foto = foto;
		this.contactos = contactos;
		this.grupos = grupos;
		this.ldts = ldts;
	}

	public Usuario(){}
	

	public Usuario(int idUsuario, String nombre, String alias) {
		// TODO Auto-generated constructor stub
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.alias = alias;
	}
	public ArrayList<ListaDeTareas> getLdts() {
		return ldts;
	}

	public void setLdts(ArrayList<ListaDeTareas> ldts) {
		this.ldts = ldts;
	}

	public ArrayList<Usuario> getContactos() {
		return contactos;
	}

	public void setContactos(ArrayList<Usuario> contactos) {
		this.contactos = contactos;
	}

	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}
	

}
