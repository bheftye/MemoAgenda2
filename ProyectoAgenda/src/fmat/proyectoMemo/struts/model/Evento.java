package fmat.proyectoMemo.struts.model;


public class Evento {
	private int id_evento;
	private String nombre;
	private String fecha_inicio, fecha_final;
	private String hora_inicio, hora_final;
	private String ubicacion;
	private int id_integrante;
	private int id_creador;
	private int id_grupo;

	public Evento() {
		super();
	}


	public Evento(int id_evento,int id_creador, String nombre, String fecha_inicio,
			String fecha_final, String hora_inicio, String hora_final,
			String ubicacion) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.ubicacion = ubicacion;
		this.id_creador = id_creador;
	}
	
	public Evento(int id_creador, String nombre, String fecha_inicio,
			String fecha_final, String hora_inicio, String hora_final,
			String ubicacion) {
		super();
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.ubicacion = ubicacion;
		this.id_creador = id_creador;
	}



	public Evento(int id_evento,int id_creador, String nombre, String fecha_inicio,
			String fecha_final, String hora_inicio, String hora_final,
			String ubicacion, int id_grupo) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.ubicacion = ubicacion;
		this.id_creador = id_creador;
		this.id_grupo = id_grupo;
	}


	public Evento(int id_evento, String nombre, String fecha_inicio,
			String fecha_final, String hora_inicio, String hora_final,
			String ubicacion, int id_integrante, int id_creador) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.ubicacion = ubicacion;
		this.id_integrante = id_integrante;
		this.id_creador = id_creador;
	}


	public Evento(int id_evento, String nombre, String fecha_inicio,
			String fecha_final, String hora_inicio, String hora_final,
			String ubicacion, int id_integrante, int id_creador, int id_grupo) {
		super();
		this.id_evento = id_evento;
		this.nombre = nombre;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.hora_inicio = hora_inicio;
		this.hora_final = hora_final;
		this.ubicacion = ubicacion;
		this.id_integrante = id_integrante;
		this.id_creador = id_creador;
		this.id_grupo = id_grupo;
	}


	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getHora_inicio() {
		return hora_inicio;
	}
	public void setHora_inicio(String hora_inicio) {
		this.hora_inicio = hora_inicio;
	}
	public String getHora_final() {
		return hora_final;
	}
	public void setHora_final(String hora_final) {
		this.hora_final = hora_final;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	public int getId_integrante() {
		return id_integrante;
	}
	public void setId_integrante(int id_integrante) {
		this.id_integrante = id_integrante;
	}
	public int getId_creador() {
		return id_creador;
	}
	public void setId_creador(int id_creador) {
		this.id_creador = id_creador;
	}
	public int getId_grupo() {
		return id_grupo;
	}
	public void setId_grupo(int id_grupo) {
		this.id_grupo = id_grupo;
	}



}
