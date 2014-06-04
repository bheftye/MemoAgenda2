package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fmat.proyectoMemo.struts.model.Evento;
import fmat.proyectoMemo.struts.model.Usuario;

public class DAOEvento extends DAOBase{

	public DAOEvento() {
		super();
	}

	public boolean agregarEvento(Evento evento) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `eventos`("
				+ "`id_creador`, `nombre`, `fecha_inicio`,`fecha_final`,`hora_inicio`, `hora_final`,`ubicacion`,`descripcion`) "
				+ "VALUES (" + evento.getId_creador() + ",\"" + evento.getNombre()
				+ "\"," + "\"" + evento.getFecha_inicio() + "\",\""+evento.getFecha_final()+"\""+ ",\""+evento.getHora_inicio()+"\", \""+evento.getHora_final()+"\", \"" + evento.getUbicacion()+"\",\"" + evento.getDescripcion()+"\")";
		try {
			Statement statement = connection.createStatement();
			int id_evento = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			evento.setId_evento(id_evento);
			if(id_evento != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}

	public boolean agregarEventoIntegrantes(Evento evento, String[] integrantes) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `eventos`("
				+ "`id_creador`, `nombre`, `fecha_inicio`,`fecha_final`,`hora_inicio`, `hora_final`,`ubicacion`, `descripcion`) "
				+ "VALUES (" + evento.getId_creador() + ",\"" + evento.getNombre()
				+ "\"," + "\"" + evento.getFecha_inicio() + "\",\""+evento.getFecha_final()+"\""+ ",\""+evento.getHora_inicio()+"\", \""+evento.getHora_final()+"\", \"" + evento.getUbicacion()+"\",\"" + evento.getDescripcion()+"\")";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet res = statement.getGeneratedKeys();
			int id_evento = 0;
			if(res.next()){
				id_evento = res.getInt(1);
			}
			evento.setId_evento(id_evento);
			boolean agregados = agregarIntegrantesaEvento(evento.getId_evento(), integrantes);
			if(id_evento != 0 && agregados){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}

	public boolean agregarEventoIntegrantesyGrupo(Evento evento, String[] integrantes, String[] grupos) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `eventos`("
				+ "`id_creador`, `nombre`, `fecha_inicio`,`fecha_final`,`hora_inicio`, `hora_final`,`ubicacion`,`descripcion`) "
				+ "VALUES (" + evento.getId_creador() + ",\"" + evento.getNombre()
				+ "\"," + "\"" + evento.getFecha_inicio() + "\",\""+evento.getFecha_final()+"\""+ ",\""+evento.getHora_inicio()+"\", \""+evento.getHora_final()+"\", \"" + evento.getUbicacion()+"\",\"" + evento.getDescripcion()+"\")";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet res = statement.getGeneratedKeys();
			int id_evento = 0;
			if(res.next()){
				id_evento = res.getInt(1);
			}
			evento.setId_evento(id_evento);
			boolean agregados = agregarIntegrantesaEvento(evento.getId_evento(), integrantes);
			boolean gruposAg = agregarGruposaEvento(evento.getId_evento(), grupos);

			if(id_evento != 0 && agregados && gruposAg){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}



	public boolean agregarIntegrantesaEvento(int id_evento, String[] integrantes) {
		boolean oprExitosa = false;
		for (int i = 0; i < integrantes.length; i++) {
			int id_integrante = Integer.parseInt(integrantes[i]+"");
			String sql = "INSERT INTO `eventos_integrantes`("
					+ "`id_evento`, `id_integrante`) "
					+ "VALUES (" + id_evento + ","+id_integrante+")";
			try {
				Statement statement = connection.createStatement();
				int affectedRows = statement.executeUpdate(sql);
				if (affectedRows >= 1) {
					oprExitosa = true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oprExitosa;
	}

	public boolean agregarEventoGrupos(Evento evento, String[] grupos) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `eventos`("
				+ "`id_creador`, `nombre`, `fecha_inicio`,`fecha_final`,`hora_inicio`, `hora_final`,`ubicacion`,`descripcion`) "
				+ "VALUES (" + evento.getId_creador() + ",\"" + evento.getNombre()
				+ "\"," + "\"" + evento.getFecha_inicio() + "\",\""+evento.getFecha_final()+"\""+ ",\""+evento.getHora_inicio()+"\", \""+evento.getHora_final()+"\", \""+ evento.getUbicacion()+"\",\"" + evento.getDescripcion()+"\")";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet res = statement.getGeneratedKeys();
			int id_evento = 0;
			if(res.next()){
				id_evento = res.getInt(1);
			}
			evento.setId_evento(id_evento);
			boolean agregados = agregarGruposaEvento(evento.getId_evento(), grupos);
			if(id_evento != 0 && agregados){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}



	public boolean agregarGruposaEvento(int id_evento, String[] grupos) {
		boolean oprExitosa = false;
		for (int i = 0; i < grupos.length; i++) {
			int id_grupo = Integer.parseInt(grupos[i]+"");
			String sql = "INSERT INTO `eventos_grupos`("
					+ "`id_evento`, `id_grupo`) "
					+ "VALUES (" + id_evento + ","+id_grupo+")";
			try {
				Statement statement = connection.createStatement();
				int affectedRows = statement.executeUpdate(sql);
				if (affectedRows >= 1) {
					oprExitosa = true;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return oprExitosa;
	}

	//SELECT * FROM `eventos` WHERE `id_evento` = (SELECT `id_evento` FROM `eventos_grupos` WHERE `id_grupo` = 4) 


	public ArrayList<Evento> recuperarEventosDelUsuario(int id_grupo){
		String sql = "SELECT * FROM `eventos` WHERE `id_creador`=8 union SELECT * FROM `eventos` WHERE `id_evento` = (SELECT `id_evento` FROM `eventos_grupos` WHERE `id_grupo` = "+id_grupo+" ) union SELECT * FROM `eventos` WHERE `id_evento` = (SELECT `id_evento` FROM `eventos_integrantes` WHERE `id_integrante` = 8 )";
		ArrayList<Evento> eventos = new ArrayList<>();
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while(resultados.next()){
				eventos.add(new Evento(resultados.getInt("id_evento"),resultados.getString("nombre"), resultados.getString("fecha_inicio"), resultados.getString("fecha_final"), resultados.getString("hora_inicio"), resultados.getString("hora_final"), resultados.getString("ubicacion"), resultados.getString("descripcion")));
			}

		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return eventos;
	}
}



