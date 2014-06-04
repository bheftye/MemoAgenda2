package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fmat.proyectoMemo.struts.model.ListaDeTareas;

public class DAOLDT extends DAOBase{
	
	public boolean insertarLDT(ListaDeTareas ldt){
		boolean insercionExitosa = false;
		String sql = "INSERT INTO `listas_tareas`( `nombre`, `fecha_limite`, `id_creador`) VALUES ('"+ldt.getNombre()+"','"+ldt.getFechLimite()+"','"+ldt.getIdCreador()+")";
		System.out.println(sql);
		try{
			Statement st = connection.createStatement();
			st.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = st.getGeneratedKeys();
			if(rs.next()){
				int idLDT = rs.getInt(1);
				ldt.setIdLDT(idLDT);
				String sql2 = "INSERT INTO `lista_paticipantes`(`id_lista`, `id_participante`) VALUES ("+ldt.getIdLDT()+","+ldt.getIdCreador()+")";
				int renglonesAfectados = st.executeUpdate(sql2);
				if(renglonesAfectados > 0){
					insercionExitosa = true;
				}
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return insercionExitosa;
	}
	
	public boolean modificarLDT(ListaDeTareas ldt){
		boolean insercionExitosa = false;
		String sql = "UPDATE `listas_tareas` SET nombre = '"+ldt.getNombre()+"', fecha_limite = '"+ldt.getFechLimite()+"' WHERE id_lista = "+ldt.getIdLDT();
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
	
	
}
