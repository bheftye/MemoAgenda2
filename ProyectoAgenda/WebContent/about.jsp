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
					|

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
									</strong>
									<s:property value="#session['usuario'].contactos.size" /></td>
									<td><strong>Grupos: </strong> <s:property value="#session['usuario'].grupos.size" /></td>
								</tr>
							</table>
						</div>
					</div>
					<div>
						<div>
							<h1>Datos personales</h1>
							<br />
							<p>
								<strong>Nombre:</strong>
								<s:property value="#session['usuario'].nombre" />
								<br /> <strong>Alias:</strong>
								<s:property value="#session['usuario'].alias" />
								<br /> <strong>Correo electr&oacute;nico:</strong>
								<s:property value="#session['usuario'].correo" />
							</p>
							<h1>Contactos</h1>
							<s:iterator value="#session['usuario'].contactos" status="a">
								<s:iterator value="#session['usuario'].contactos[#a.index]">
									<s:property value="alias" />
									<br>
								</s:iterator>
							</s:iterator>
							<h1>Grupos</h1>
							<s:iterator value="#session['usuario'].grupos" status="a">
								<s:iterator value="#session['usuario'].grupos[#a.index]">
									<s:form action="mostrarGrupo">
										<s:property value="nombre" />
										<s:hidden name="grupo.idGrupo"
											value="%{idGrupo}" />
										<s:submit cssClass="submit" style="display:inline" value="Ver" />
									</s:form>
								</s:iterator>
							</s:iterator>
							<p></p>
						</div>
						<div class="sidebar">
							<div>
								<a href="editinfo.jsp"><h3>Editar informaci&oacute;n</h3></a>
							</div>
							<div>
								<a href="addcontact.jsp" style="text-decoration: none;"><h3>A&ntilde;adir
										contacto</h3></a>
							</div>
							<div class="section">
								<a href="addgroup.jsp" style="text-decoration: none;"><h3>Crear
										grupo</h3></a>
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