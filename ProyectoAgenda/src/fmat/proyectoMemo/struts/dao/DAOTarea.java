package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.ListaDeTareas;
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
}
