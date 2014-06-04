package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.Tarea;

public class DAOTarea extends DAOBase{
	
	public boolean insertarTarea(Tarea tarea){
		boolean insercionExitosa = false;
		String sql = "INSERT INTO `tareas`(`id_lista`, `nombre`, `descripcion`, `id_responsable`, `status`) VALUES ("+tarea.getIdLDT()+",'"+tarea.getNombre()+"','"+tarea.getDescripcion()+"',"+tarea.getIdResponsable()+",1)";
		try{
			Statement st = connection.createStatement();
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()){
				int idTarea = rs.getInt(1);
				tarea.setIdTarea(idTarea);
				insercionExitosa = true;
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return insercionExitosa;
	}
	
	public boolean modificarTarea(Tarea tarea){
		boolean insercionExitosa = false;
		String sql = "UPDATE `tareas` SET nombre = '"+tarea.getNombre()+", descripcion = '"+tarea.getDescripcion()+"' WHERE id_tarea = "+tarea.getIdTarea();
		try{
			Statement st = connection.createStatement();
			int renglonesAfectados = st.executeUpdate(sql);
			if(renglonesAfectados > 0){
				insercionExitosa = true;
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return insercionExitosa;
	}
	
	public Tarea obtenerTareaPorId(int idTarea){
		Tarea tarea = new Tarea();
		String sql = "SELECT * FROM tareas WHERE id_tarea = "+idTarea;
		try{
			Statement st = connection.createStatement();
			ResultSet set = st.executeQuery(sql);
			if(set.next()){
				tarea.setDescripcion(set.getString("descripcion"));
				tarea.setIdLDT(set.getInt("id_lista"));
				tarea.setIdResponsable(set.getInt("id_responsable"));
				tarea.setIdTarea(set.getInt("id_tarea"));
				tarea.setNombre(set.getString("nombre"));
				tarea.setStatus(set.getInt("status"));
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return tarea;
	}
}
