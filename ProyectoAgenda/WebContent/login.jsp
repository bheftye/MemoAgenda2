<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MEMO | Agenda En Línea</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="icon" type="image/png" href="images/favicon-memo.png">
</head>
<body>
	<div id="background-green">background</div>
	<div class="page">
		<div class="home-page">
			<div class="sidebar">
				<a href="index.html" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class="home"><a href="index.jsp">Inicio</a></li>
					<li class="about"><a href="about.jsp">Perfil</a></li>
					<li class="blog"><a href="blog.jsp">Agenda</a></li>
					<li class="projects"><a href="projects.html">Ajustes</a></li>
					<li class="contact"><a href="contact.html">Contacto</a></li>
				</ul>
				<div class="connect">
					<a href="#" id="fb">facebook</a> <a href="#" id="twitter">twitter</a>
				</div>
			</div>
			<div class="body">
				<div class="login">
					<a href="login.jps" id="login">Iniciar sesión | Registrarse</a>
				</div>
				<div class="content-login">
					<div>
						<table>
							<tr>
								<td><h3 style="margin-top:50px;">Iniciar sesión</h3>
									
									<!-- 
									<form action="login">
										 -->
										 
										<h4 >Escribe tu alias y contrase&ntilde;a para iniciar
											sesi&oacute;n</h4>
										
											<s:actionerror />
											<s:form action="iniciarSesion">
											
											<s:textfield name="usuario.alias" placeholder="Alias*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:password name="usuario.contrasena"  placeholder="Contraseña*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:submit  cssClass="submit"
											value="Iniciar sesión" />
											</s:form>
										
										<p>
											<a href="#">¿Olvidaste tu contraseña?</a>
										</p>
										
									<!--  	
									</form>
									-->
									
									</td>
								
								<td class="linea"><h3 class="registro">Registro</h3>
										<h4>Escribe tu nombre, contrase&ntilde;a y correo
											electr&oacute;nico para registrarte.</h4>										
											
											<s:actionerror />
											<s:form action="registrarUsuario">
											
											<s:textfield name="usuario.nombre" placeholder="Nombre*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:textfield name="usuario.correo" placeholder="Correo Electr&oacute;nico*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:textfield name="usuario.alias" placeholder="Alias*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:password name="usuario.contrasena"  placeholder="Contraseña*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:password name="contrasenaConfirmacion"  placeholder="Contraseña Confirmaci&oacute;n*"
											onFocus="this.select()" 
											onClick="this.value='';" />
											
											<s:submit  cssClass="submit"
											value="Registrarse" />
											</s:form></td>
							</tr>
						</table>
					</div>
				</div>
				<div class="footer">
					<p>&#169; 2014 MEMO | AGENDA EN LINEA</p>
					<ul>
						<li><a href="index.html">Inicio</a></li>
						<li><a href="about.html">Perfil</a></li>
						<li><a href="projects.html">Agenda</a></li>
						<li><a href="blog.html">Ajustes</a></li>
						<li><a href="contact.html">Contacto</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>