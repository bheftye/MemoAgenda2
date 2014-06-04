package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fmat.proyectoMemo.struts.model.ListaDeTareas;
import fmat.proyectoMemo.struts.model.Tarea;

public class DAOLDT extends DAOBase{
	
	public boolean insertarLDT(ListaDeTareas ldt){
		boolean insercionExitosa = false;
		String sql = "INSERT INTO `listas_tareas`( `nombre`, `fecha_limite`, `id_creador`,status) VALUES ('"+ldt.getNombre()+"','"+ldt.getFechLimite()+"',"+ldt.getIdCreador()+",1)";
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
	
	public ArrayList<ListaDeTareas> obtenerLDTSPorIdUsuario(int idUsuario){
		ArrayList<ListaDeTareas> ldts = new ArrayList<>();
		String sql = "SELECT listas_tareas.`id_lista` , `nombre` , `fecha_limite` , `id_creador` , status FROM listas_tareas LEFT JOIN lista_paticipantes ON listas_tareas.id_lista = lista_paticipantes.id_lista WHERE lista_paticipantes.id_participante ="+idUsuario;
		try{
			Statement st = connection.createStatement();
			ResultSet resultados = st.executeQuery(sql);
			while(resultados.next()){
				ListaDeTareas ldt = new ListaDeTareas();
				ldt.setFechLimite(resultados.getString("fecha_limite"));
				ldt.setIdCreador(resultados.getInt("id_creador"));
				ldt.setIdLDT(resultados.getInt("id_lista"));
				ldt.setNombre(resultados.getString("nombre"));
				ldt.setStatus(resultados.getInt("status"));
				ArrayList<Tarea> tareas = this.obtenerTareasLDPPorId(resultados.getInt("id_lista"));
				ldt.setTareas(tareas);
				ldts.add(ldt);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ldts;
	}
	
	public ListaDeTareas obtenerLDTPorId(int idLDT){
		ListaDeTareas ldt = new ListaDeTareas();
		String sql = "SELECT * FROM listas_tareas WHERE id_lista = "+idLDT;
		try{
			Statement st = connection.createStatement();
			ResultSet resultados = st.executeQuery(sql);
			while(resultados.next()){
				ldt.setFechLimite(resultados.getString("fecha_limite"));
				ldt.setIdCreador(resultados.getInt("id_creador"));
				ldt.setIdLDT(resultados.getInt("id_lista"));
				ldt.setNombre(resultados.getString("nombre"));
				ldt.setStatus(resultados.getInt("status"));
				ArrayList<Tarea> tareas = this.obtenerTareasLDPPorId(resultados.getInt("id_lista"));
				ldt.setTareas(tareas);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return ldt;
	}
	
	public ArrayList<Tarea> obtenerTareasLDPPorId(int idLDT){
		ArrayList<Tarea> tareas = new ArrayList<>();
		String sql = "SELECT * FROM tareas WHERE id_list ="+idLDT;
		try{
			Statement st = connection.createStatement();
			ResultSet resultados = st.executeQuery(sql);
			while(resultados.next()){
				Tarea tarea = new Tarea();
				tarea.setDescripcion(resultados.getString("descripcion"));
				tarea.setIdLDT(idLDT);
				tarea.setIdResponsable(resultados.getInt("id_responsable"));
				tarea.setIdTarea(resultados.getInt("id_tarea"));
				tarea.setNombre(resultados.getString("nombre"));
				tarea.setStatus(resultados.getInt("status"));
				tareas.add(tarea);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return tareas;
	}
	
	
}
