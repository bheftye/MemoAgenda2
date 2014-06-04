<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Perfil - MEMO</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="background-yellow">background</div>
	<div class="page">
		<div class="about-page">
			<div class="sidebar">
				<a href="`portal.jsp" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class="home"><a href="portal.jsp">Inicio</a></li>
					<li class=" selected about"><a href="about.jsp">Perfil</a></li>
					<li class="blog"><a href="blog.jsp">Agenda</a></li>
					<li class="projects"><a href="projects.html">Ajustes</a></li>
					<li class="contact"><a href="contact.html">Contacto</a></li>
				</ul>
				<div class="connect">
					<a href="http://freewebsitetemplates.com/go/facebook/" id="fb">facebook</a>
					<a href="http://freewebsitetemplates.com/go/twitter/" id="twitter">twitter</a>
				</div>
			</div>
			<div class="body">
				<div class="login">
					Bienvenido
					<s:property value="#session['usuario'].alias" />
					<s:a href="index.jsp" onClick="cerrarSesion">Cerrar sesión</s:a>
				</div>
				<div class="content-about">
					<div>
						<h3>Perfil</h3>
					</div>
					<div class="featured">
						<div id="perfil">
							<table>
								<tr>
									<td><img src="images/icon-perfil3.jpg" class="fotoPerfil" /></td>
									<td><strong><s:property
												value="#session['usuario'].nombre" /> </strong>
									<p id="alias">
											<s:property value="#session['usuario'].alias" />
										</p></td>
									<td width="200px" align="left"></td>
									<td width="200px" align="left"><strong>Contactos:
									</strong><s:property value="#session['usuario'].contactos.size"/></td>
									<td><strong>Grupos: </strong> <s:property value="#session['usuario'].grupos.size"/></td>
								</tr>
							</table>
						</div>
					</div>
					<div>
						<div>
							<h1>Datos personales</h1>
							<br />
							<s:actionerror />
							<s:form action="modificarInformacion">

								<s:textfield name="usuario.nombre" value="%{#session['usuario'].nombre}" placeholder="Nombre*"
									onFocus="this.select()" label="Nombre" />

								<s:textfield name="usuario.correo"
									placeholder="Correo Electr&oacute;nico*"
									onFocus="this.select()" value="%{#session['usuario'].correo}" label="Correo" />

								<s:textfield name="usuario.alias" value="%{#session['usuario'].alias}" placeholder="Alias*"
									onFocus="this.select()" label="Alias" />

								<s:submit cssClass="submit" value="Guardar" />
							</s:form>
							<br>
							<s:form action="modificarContrasena">

								<s:password name="usuario.contrasena"
									onFocus="this.select()" onClick="this.value='';" label="Nueva Contraseña" />

								<s:password name="contrasenaConfirmacion"
									placeholder=""
									onFocus="this.select()" onClick="this.value='';" label="Confirmar Contraseña" />

								<s:submit cssClass="submit" value="Cambiar Contraseña" />
							</s:form>
							
							
							<p></p>
						</div>
						<div class="sidebar">
							<div>
								<a href="editinfo.jsp"><h3>Editar informaci&oacute;n</h3></a>
							</div>
							<div>
								<a href="addcontact.jsp" style="text-decoration:none;"><h3>A&ntilde;adir contacto</h3></a>
							</div>
							<div class="section">
								<a href="addcontact.jsp" style="text-decoration:none;"><h3>Crear grupo</h3></a>
							</div>
						</div>
					</div>
				</div>
				<div class="footer">
					<p>&#169; 2014 MEMO | AGENDA EN LINEA</p>
					<ul>
						<li><a href="portal.jsp">Inicio</a></li>
						<li><a href="about.jsp">Perfil</a></li>
						<li><a href="blog.jsp">Agenda</a></li>
						<li><a href="blog.html">Ajustes</a></li>
						<li><a href="contact.html">Contacto</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>