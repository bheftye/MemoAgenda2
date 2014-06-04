package fmat.proyectoMemo.struts.dao;

import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.Evento;
import fmat.proyectoMemo.struts.model.Usuario;

public class DAOEvento extends DAOBase{
	
	public DAOEvento() {
		super();
	}

	public boolean agregarEvento(Evento evento, String repeticion) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `eventos`("
				+ "`id_creador`, `nombre`, `fecha_inicio`,`fecha_final`,`hora_inicio`, `hora_final`,`repeticion`,`ubicacion`) "
				+ "VALUES (" + evento.getId_creador() + ",\"" + evento.getNombre()
				+ "\"," + "\"" + evento.getFecha_inicio() + "\",\""+evento.getFecha_final()+"\""+ ",\""+evento.getHora_inicio()+"\", \""+evento.getHora_final()+"\", \"" + repeticion +"\", \"" + evento.getUbicacion()+"\")";
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

}
