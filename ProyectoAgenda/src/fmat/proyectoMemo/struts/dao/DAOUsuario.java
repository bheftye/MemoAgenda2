package fmat.proyectoMemo.struts.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fmat.proyectoMemo.struts.model.Grupo;
import fmat.proyectoMemo.struts.model.Usuario;

public class DAOUsuario extends DAOBase {

	public DAOUsuario() {
		super();
	}

	/*
	 * public void addSeat(Seat seat) { Statement statement; try { String
	 * insertStatement = "INSERT INTO " + SEATS_TABLE_NAME +
	 * " (id_asientos,ocupado) VALUES ('" + seat.getId_seat() + "'," +
	 * seat.getIsTaken() + ")"; statement = connection.createStatement();
	 * statement.executeUpdate(insertStatement); } catch (SQLException ex) {
	 * ex.printStackTrace(); } }
	 */

	public boolean insertarUsuario(Usuario nuevoUsuario) {
		boolean oprExitosa = false;
		String sql = "INSERT INTO `usuarios`("
				+ "`nombre`, `alias`, `correo`, `contrasena`,`foto`) "
				+ "VALUES (\"" + nuevoUsuario.getNombre() + "\",\""
				+ nuevoUsuario.getAlias() + "\",\"" + nuevoUsuario.getCorreo()
				+ "\"," + "MD5(\"" + nuevoUsuario.getContrasena() + "\"),\""+nuevoUsuario.getAlias()+".jpg\")";
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			ResultSet llavesGeneradas = statement.getGeneratedKeys();
			if(llavesGeneradas.next()){
				int idUsuario = llavesGeneradas.getInt(1);
				nuevoUsuario.setIdUsuario(idUsuario);
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean sonAmigos(int idUsuarioA, int idUsuarioB){
		String sqlAmigos = "select usuarios.id_usuario, nombre from (select id_usuario from amigos where id_amigo = "+idUsuarioA+" union select id_amigo from amigos where id_usuario= "+idUsuarioA+") AS amiguis join usuarios on amiguis.id_usuario = usuarios.id_usuario";
		boolean sonAmigos = false;
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sqlAmigos);
			while(resultados.next()){
				int idUsuario = resultados.getInt("usuarios.id_usuario");
				if(idUsuario == idUsuarioB){
					sonAmigos = true;
					break;
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return sonAmigos;
	}
	
	public boolean agregarAmigo(int idUsuarioA, int idUsuarioB){
		boolean oprExitosa = false;
		String sql = "INSERT INTO `amigos`("
				+ "`id_amigo`, `id_usuario`, `status`) "
				+ "VALUES (\"" + idUsuarioA + "\",\""
				+ idUsuarioB + "\", 0)";
		try {
			Statement statement = connection.createStatement();
			int renglonesAfectados = statement.executeUpdate(sql);
			if(renglonesAfectados != 0){
				oprExitosa = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	
	public ArrayList<Usuario> buscarUsuario(String aliasABuscar, String aliasSesion){
		String sqlBusqueda = "SELECT * FROM usuarios where alias like '%"+aliasABuscar+"%'";
		ArrayList<Usuario> usuarios = new ArrayList<>();
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sqlBusqueda);
			while(resultados.next()){
				String alias = resultados.getString("alias");
				String nombre = resultados.getString("nombre");
				int idUsuario = resultados.getInt("id_usuario");
				String correo = resultados.getString("correo");
				if(aliasSesion.equals(alias)){
					continue;
				}
				else{
					Usuario usuario = new Usuario();
					usuario.setAlias(alias);
					usuario.setNombre(nombre);
					usuario.setIdUsuario(idUsuario);
					usuario.setCorreo(correo);
					usuarios.add(usuario);
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return usuarios;
	}
	
	public boolean aliasDisponible(String alias){
		boolean aliasDisponible = true;
		String aliasUsado = "";
		String sqlBusqueda = "SELECT alias FROM usuarios where alias = '"+alias+"'";
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sqlBusqueda);
			while(resultados.next()){
				aliasUsado = resultados.getString("alias");
				if(alias.equals(aliasUsado)){
					aliasDisponible = false;
					break;
				}
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		
		return aliasDisponible;
	}
	
	public boolean modificarContrasena(Usuario usuario, Usuario sesion){
		boolean oprExitosa = false;
		String sqlContrasena = "UPDATE usuarios SET contrasena = MD5(?) WHERE id_usuario = ?";
		PreparedStatement sContrasena = null;
		
		try{
			connection.setAutoCommit(false);
			if(!usuario.getContrasena().equals(sesion.getContrasena())){
				sContrasena = connection.prepareStatement(sqlContrasena);
				sContrasena.setString(1, usuario.getContrasena());
				sContrasena.setInt(2, sesion.getIdUsuario());
				sContrasena.executeUpdate();
			}
			
			connection.commit();
			connection.setAutoCommit(true);
			oprExitosa = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return oprExitosa;
	}
	
	public boolean modificarInformacionUsuario(Usuario usuario, Usuario sesion){
		boolean oprExitosa = false;
		String sqlNombre = "UPDATE usuarios SET nombre = ? WHERE id_usuario = ?";
		String sqlAlias = "UPDATE usuarios SET alias = ? WHERE id_usuario = ?";
		String sqlCorreo = "UPDATE usuarios SET correo = ? WHERE id_usuario = ?";
		PreparedStatement sNombre = null;
		PreparedStatement sAlias = null;
		PreparedStatement sCorreo = null;
		try{
			connection.setAutoCommit(false);
			if(!usuario.getNombre().equals(sesion.getNombre())){
				sNombre = connection.prepareStatement(sqlNombre);
				sNombre.setString(1, usuario.getNombre());
				sNombre.setInt(2, sesion.getIdUsuario());
				sNombre.executeUpdate();
			}
			
			if(!usuario.getAlias().equals(sesion.getAlias())){
				sAlias = connection.prepareStatement(sqlAlias);
				sAlias.setString(1, usuario.getAlias());
				sAlias.setInt(2, sesion.getIdUsuario());
				sAlias.executeUpdate();
			}
			
			if(!usuario.getCorreo().equals(sesion.getCorreo())){
				sCorreo = connection.prepareStatement(sqlCorreo);
				sCorreo.setString(1, usuario.getCorreo());
				sCorreo.setInt(2, sesion.getIdUsuario());
			}
			connection.commit();
			connection.setAutoCommit(true);
			oprExitosa = true;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return oprExitosa;
	}

	/*
	 * public Seat getSeat(String id) { Seat resultSeat = null; try { String
	 * query = "SELECT * FROM " + SEATS_TABLE_NAME + " WHERE id_asientos = '" +
	 * id + "'"; Statement statement = connection.createStatement(); ResultSet
	 * results = statement.executeQuery(query); while (results.next()) {
	 * resultSeat = new Seat(results.getString("id_asientos"),
	 * results.getInt("ocupado")); } } catch (SQLException ex) {
	 * ex.printStackTrace(); } return resultSeat; }
	 */
	
	public ArrayList<Usuario> obtenerContactosPorId(int idUsuario){
		String sqlAmigos = "select usuarios.id_usuario, alias, nombre from (select id_usuario from amigos where id_amigo = "+idUsuario+" union select id_amigo from amigos where id_usuario= "+idUsuario+") AS amiguis join usuarios on amiguis.id_usuario = usuarios.id_usuario";
		ArrayList<Usuario> contactos = new ArrayList<>();
		try{
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sqlAmigos);
			while(resultados.next()){
				int idUsuarioC = resultados.getInt("usuarios.id_usuario");
				String alias = resultados.getString("alias");
				String nombre = resultados.getString("nombre");
				Usuario contacto = new Usuario();
				contacto.setAlias(alias);
				contacto.setNombre(nombre);
				contacto.setIdUsuario(idUsuarioC);
				contactos.add(contacto);
			}
		}
		catch(SQLException ex){
			ex.printStackTrace();
		}
		return contactos;
	}
	
	public Usuario obtenerUsuarioPorId(int idUsuario) {
		Usuario usuario = null;
		String sql = "SELECT * FROM `usuarios` WHERE `id_usuario` = "
				+ idUsuario;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while (resultados.next()) {
				ArrayList<Usuario> contactos = new ArrayList<>();
				contactos = this.obtenerContactosPorId(resultados.getInt("id_usuario"));
				ArrayList<Grupo> grupos = new ArrayList<>();
				DAOGrupo dao = new DAOGrupo();
				grupos = dao.obtenerGruposPorIdUsuario(resultados.getInt("id_usuario"));
				usuario = new Usuario(resultados.getInt("id_usuario"),resultados.getString("alias"), resultados.getString("contrasena"),resultados.getString("nombre"),resultados.getString("correo"),resultados.getString("foto"), contactos, grupos);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}
	
	public Usuario obtenerUsuarioPorCredenciales(String alias, String contrasena){
		Usuario usuario = null;
		String sql = "SELECT * FROM `usuarios` WHERE `alias` = \""
				+ alias + "\" and `contrasena` = MD5(\""+contrasena+"\")";
		
		try {
			Statement statement = connection.createStatement();
			ResultSet resultados = statement.executeQuery(sql);
			while (resultados.next()) {
				ArrayList<Usuario> contactos = new ArrayList<>();
				ArrayList<Grupo> grupos = new ArrayList<>();
				DAOGrupo dao = new DAOGrupo();
				grupos = dao.obtenerGruposPorIdUsuario(resultados.getInt("id_usuario"));
				contactos = this.obtenerContactosPorId(resultados.getInt("id_usuario"));
				usuario = new Usuario(resultados.getInt("id_usuario"),resultados.getString("alias"), resultados.getString("contrasena"),resultados.getString("nombre"),resultados.getString("correo"),resultados.getString("foto"),contactos, grupos);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return usuario;
	}
}
