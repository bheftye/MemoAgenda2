package fmat.proyectoMemo.struts.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import fmat.proyectoMemo.struts.dao.DAOUsuario;
import fmat.proyectoMemo.struts.model.Usuario;

public class UsuarioAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> mapSession;
	private Usuario usuario;
	private String contrasenaConfirmacion;
	private String htmlUsuarios = "<p>Sin coincidencias</p>";

	/**
	 * Agregar la clase services para que el usuario sea null
	 * 
	 * @return
	 * @throws Exception
	 */

	public String iniciarSesion() throws Exception {
		DAOUsuario dao = new DAOUsuario();
		String texto = "Nombre de usuario o contrase&ntilde;a incorrectos";
		/**
		 * Coloca el usuario al nivel de la sesi�n
		 */
		if (!usuario.getAlias().equals("")
				&& !usuario.getContrasena().equals("")) {
			usuario = dao.obtenerUsuarioPorCredenciales(usuario.getAlias(),
					usuario.getContrasena());
			texto = "Favor de llenar todos los campos";
		}
		if (usuario != null) {
			mapSession.put("usuario", usuario);
			return "portal";
		} else {
			addActionError(texto);
			return "login";
		}
	}

	public String buscarUsuario() {
		DAOUsuario dao = new DAOUsuario();
		boolean camposLlenos = !usuario.getAlias().equals("");
		if (camposLlenos && mapSession.get("usuario") != null) {
			if (usuario.getAlias().equals(
					((Usuario) mapSession.get("usuario")).getAlias())) {
				htmlUsuarios = "<p>Un, dos, tres por tí.</p>";
			} else {
				ArrayList<Usuario> usuarios = new ArrayList<>();
				usuarios = dao.buscarUsuario(usuario.getAlias(),
						((Usuario) mapSession.get("usuario")).getAlias());
				Usuario usuarioIndexado;
				htmlUsuarios = "<table><tr><th>Alias</th><th>Agregar</th></tr>";
				for (int i = 0; i < usuarios.size(); i++) {
					usuarioIndexado = usuarios.get(i);
					htmlUsuarios += "<tr><td>" + usuarioIndexado.getAlias()
							+ "</td>";
					htmlUsuarios += "<td><form action=\"agregarAmigo\">"
							+ "<input type=\"hidden\" name=\"usuario.idUsuario\" value=\""
							+ usuarioIndexado.getIdUsuario()
							+ "\" />"
							+ "<input type=\"submit\" class=\"submit\" value=\"Agregar\" />"
							+ "</form></td></tr>";
				}
				htmlUsuarios += "</table>";
				System.out.println(htmlUsuarios);
			}
		} else {
			addFieldError("usuario.alias", "Introduce un alias a buscar.");

		}
		return "addContact";
	}

	public String modificarInformacion() {
		DAOUsuario dao = new DAOUsuario();
		String texto = "Se modifico exitosamente tu información";
		boolean camposLlenos = !usuario.getAlias().equals("")
				&& !usuario.getNombre().equals("")
				&& !usuario.getCorreo().equals("");
		if (camposLlenos && mapSession.get("usuario") != null) {
			boolean insercionExitosa = dao.modificarInformacionUsuario(usuario,
					(Usuario) mapSession.get("usuario"));
			if (!insercionExitosa) {
				texto = "Modificación fallida, intentalo de nuevo";
			} else {
				this.modificarInfoSesion();
				return "editInfo";
			}
		} else {
			texto = "Llena todos los campos para continuar.";
		}
		addActionError(texto);
		return "editInfo";
	}

	private void modificarInfoSesion() {
		if (usuario != null) {
			DAOUsuario dao = new DAOUsuario();
			usuario = dao.obtenerUsuarioPorId(usuario.getIdUsuario());
			mapSession.put("usuario", usuario);
		}
	}

	public String agregarAmigo() {
		DAOUsuario dao = new DAOUsuario();
		String texto = "No se pudo realizar la operación";
		if (usuario.getIdUsuario() != 0 && mapSession.get("usuario") != null
				&& ((Usuario) mapSession.get("usuario")).getIdUsuario() != 0) {
			boolean sonAmigos = dao.sonAmigos(usuario.getIdUsuario(),
					((Usuario) mapSession.get("usuario")).getIdUsuario());
			if (!sonAmigos) {
				boolean insercionExitosa = dao.agregarAmigo(
						usuario.getIdUsuario(),
						((Usuario) mapSession.get("usuario")).getIdUsuario());
				if (insercionExitosa) {
					texto = "Usuario agregado";
					addActionError(texto);
					return "addContact";
				}
				texto ="Ocurrio un error intentalo de nuevo";
				addActionError(texto);
				return "addContact";
			}
			texto ="Ya es un contacto tuyo";
		}
		addActionError(texto);
		return "addContact";
	}

	public String modificarContrasena() throws Exception {
		DAOUsuario dao = new DAOUsuario();
		String texto = "";
		boolean camposLlenos = !usuario.getContrasena().equals("")
				&& !contrasenaConfirmacion.equals("");
		if (camposLlenos && mapSession.get("usuario") != null) {
			if (usuario.getContrasena().equals(contrasenaConfirmacion)) {
				boolean insercionExitosa = dao.modificarContrasena(usuario,
						(Usuario) mapSession.get("usuario"));
				if (!insercionExitosa) {
					texto = "Modificación fallida, intentalo de nuevo";
					addActionError(texto);
					return "editInfo";
				} else {
					this.cerrarSesion();
					texto = "Modificación exitosa, inicia sesión";
					addActionError(texto);
					return "login";
				}
			} else {
				texto = "Las contraseñas no coinciden";
			}
		} else {
			texto = "Llena todos los campos para continuar.";
		}
		addActionError(texto);
		return "editInfo";
	}

	public String registrarUsuario() throws Exception {
		DAOUsuario dao = new DAOUsuario();
		String texto = "Registro exitoso, inicia sesión";
		boolean camposLlenos = !usuario.getAlias().equals("")
				&& !usuario.getNombre().equals("")
				&& !usuario.getContrasena().equals("")
				&& !contrasenaConfirmacion.equals("")
				&& !usuario.getCorreo().equals("");
		if (camposLlenos) {
			if (usuario.getContrasena().equals(contrasenaConfirmacion)) {
				boolean aliasDisponible = dao.aliasDisponible(usuario
						.getAlias());
				if (!aliasDisponible) {
					texto = "Alias no disponible";
				} else {
					boolean insercionExitosa = dao.insertarUsuario(usuario);
					if (!insercionExitosa) {
						texto = "Registro fallido, intentalo de nuevo";
					}
				}
			} else {
				texto = "Las contraseñas no coinciden";
			}
		} else {
			texto = "Llena todos los campos para continuar el registro";
		}
		addActionError(texto);
		return "login";
	}

	public String cerrarSesion() throws Exception {
		mapSession.remove("usuario");
		System.out.println("CERRAR SESI�N");
		return "index";
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public String getContrasenaConfirmacion() {
		return contrasenaConfirmacion;
	}

	public void setContrasenaConfirmacion(String contrasenaConfirmacion) {
		this.contrasenaConfirmacion = contrasenaConfirmacion;
	}

	public String getHtmlUsuarios() {
		return htmlUsuarios;
	}

	public void setHtmlUsuarios(String htmlUsuarios) {
		this.htmlUsuarios = htmlUsuarios;
	}

	@Override
	public void setSession(Map<String, Object> mapSession) {
		// TODO Auto-generated method stub
		this.mapSession = mapSession;
	}
}
