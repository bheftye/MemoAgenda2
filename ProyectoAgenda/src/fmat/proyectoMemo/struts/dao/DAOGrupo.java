package fmat.proyectoMemo.struts.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

public class DAOGrupo extends DAOBase{
	
	public boolean insetarGrupo(Grupo grupo){
		boolean oprExitosa = false;
		String sql = "INSERT INTO `grupos`(`nombre`, `id_creador`, `status`) VALUES ('"+grupo.getNombre()+"',"+grupo.getIdUsuarioCreador()+",1)";
		try {
			Statement statement = connection.createStatement();
		    statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet llavesGeneradas = statement.getGeneratedKeys();
			if(llavesGeneradas.next()){
				int idGrupo = llavesGeneradas.getInt(1);
				grupo.setIdGrupo(idGrupo);
				String sql2 = "INSERT INTO `integrantes` (id_grupo, id_integrante) VALUES ("+grupo.getIdGrupo()+", "+grupo.getIdUsuarioCreador()+")";
				System.out.println(sql2);
				Statement statement2 = connection.createStatement();
				int renglonesAfectados = statement2.executeUpdate(sql2);
				if(renglonesAfectados > 0){
					oprExitosa = true;
				}
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public ArrayList<Grupo> obtenerGruposPorIdUsuario(int idUsuario){
		ArrayList<Grupo> grupos = new ArrayList<>();
		String sql = "SELECT grupos.id_grupo, nombre, id_creador, status FROM grupos LEFT JOIN integrantes ON grupos.id_grupo = integrantes.id_grupo WHERE integrantes.id_integrante ="+idUsuario;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while(resultados.next()){
				Grupo grupo = new Grupo();
				grupo.setNombre(resultados.getString("nombre"));
				grupo.setIdGrupo(resultados.getInt("id_grupo"));
				grupo.setIdUsuarioCreador(resultados.getInt("id_creador"));
				grupo.setStatus(resultados.getInt("status"));
				grupos.add(grupo);
			}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		return grupos;
	}
	
	public boolean insertarIntegranteEnGrupo(int idGrupo, int idUsuario){
		boolean oprExitosa = false;
		String sql = "INSERT INTO `integrantes`(`id_grupo`, `id_integrante`) VALUES ('"+idGrupo+"',"+idUsuario+")";
		try {
			Statement statement = connection.createStatement();
			int renglonesAfectados = statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if(renglonesAfectados != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean esIntegrante(int idGrupo, int idUsuario){
		boolean esIntegrante = false;
		String sql = "SELECT id_grupo FROM `integrantes` WHERE id_grupo = "+idGrupo+" and id_integrante = "+idUsuario;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			int numRenglones = 0;
			while(resultados.next()){
				numRenglones++;
			}
			if(numRenglones > 0 ){
				esIntegrante = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return esIntegrante;
	}
	
	public ArrayList<Usuario> obtenerIntegrantesDeGrupo(int idGrupo){
		ArrayList<Usuario> integrantes = new ArrayList<>();
		String sql  = "SELECT id_usuario, alias FROM usuarios LEFT JOIN integrantes ON usuarios.id_usuario = integrantes.id_integrante WHERE integrantes.id_grupo ="+idGrupo;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while(resultados.next()){
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(resultados.getInt("id_usuario"));
				usuario.setAlias(resultados.getString("alias"));
				integrantes.add(usuario);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return integrantes;
	}
	
	public Grupo obtenerGrupoPorId(int idGrupo){
		Grupo grupo = new Grupo();
		String sql = "SELECT * FROM grupos WHERE id_grupo = "+idGrupo;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while(resultados.next()){
				ArrayList<Usuario> integrantes = new ArrayList<>();
				integrantes = this.obtenerIntegrantesDeGrupo(idGrupo);
				grupo.setIdGrupo(idGrupo);
				grupo.setIdUsuarioCreador(resultados.getInt("id_creador"));
				grupo.setIntegrantes(integrantes);
				grupo.setNombre(resultados.getString("nombre"));
				grupo.setStatus(resultados.getInt("status"));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return grupo;
	}
	
}
