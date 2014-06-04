<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="WEB-INF/utils.tld" prefix="utils"%>

<html>
<head>
<meta charset="UTF-8">
<title>Agenda - MEMO</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker();
		$("#datepickers").datepicker();
		$("#datepicker3").datepicker();

	});
</script>

</head>
<body>
	<div id="background-lightgreen"></div>
	<div class="page">
		<div class="blog-page">
			<div class="sidebar">
				<a href="index.html" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class=" home"><a href="index.jsp">Inicio</a></li>
					<li class="about"><a href="about.jsp">Perfil</a></li>
					<li class="selected blog"><a href="blog.jsp">Agenda</a></li>
					<li class="projects"><a href="projects.html">Ajustes</a></li>
					<li class="contact"><a href="contact.html">Contacto</a></li>
				</ul>
				<div class="connect">
					<a href="#" id="fb">facebook</a> <a href="#" id="twitter">twitter</a>
				</div>
			</div>
			<div class="body">
				<div class="login">
					Bienvenido
					<s:property value="#session['usuario'].alias" />
					|
					<s:a href="index.jsp" onClick="cerrarSesion">Cerrar sesión</s:a>
				</div>
				<div class="content-blog">
					<div>
						<div>
							<h3>Agregar evento</h3>
							<jsp:useBean id="usuario" scope="session"
								class="fmat.proyectoMemo.struts.model.Usuario" />
							<div style="color: red">${errorMessage}</div>
							<form action="addEvent" method="post">
								<input type="hidden" name="idUsuario"
									value="${usuario.idUsuario}">
								<table style="margin-left: 10px;">
									<tr>
										<td><label>*Nombre del evento: </label></td>
										<td><input type="text" name="nombre" size="31"></td>
									</tr>
									<tr>
										<td><label>Descripción: </label></td>
										<td><textarea name="descripcion" cols="23" rows="10"></textarea></td>
									</tr>
									<tr>
										<td><label>*Lugar:</label></td>
										<td><input type="text" name="ubicacion" size="31"></td>
									</tr>
									<tr>
										<td><label>*Fecha de inicio:</label></td>
										<td><input type="text" name="fecha_inicio"
											id="datepicker" size="31"></td>
									</tr>
									<tr>
										<td><label>*Fecha de finalización:</label></td>
										<td><input type="text" name="fecha_final"
											id="datepickers" size="31"></td>
									</tr>
									<tr>
										<td><label>*Hora de inicio:</label></td>
										<td><input type="text" name="hora_inicio" size="31"></td>
									</tr>
									<tr>
										<td><label>*Hora final:</label></td>
										<td><input type="text" name="hora_final" size="31"></td>
									</tr>
									<tr>
										<td><label>*Repetición de evento:</label></td>
									</tr>
									<tr>
										<td></td>
										<td><input type="radio" name="repeticion" value="0">Ninguno</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="radio" name="repeticion" value="1">Diario</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="radio" name="repeticion" value="2">Cada
											semana</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="radio" name="repeticion" value="3">Cada
											mes</td>
									</tr>
									<tr>
										<td></td>
										<td><input type="radio" name="repeticion" value="4">Cada
											año</td>
									</tr>
									<tr>
										<td></td>
										<td>Hasta: <input type="text" name="hasta_fecha"
											id="datepicker3" size="31"></td>
									</tr>
									<tr>
										<td><label>Invitar usuarios:</label></td>
									</tr>
									<utils:showFriends />
									<!-- 	<tr>
										<td><label>Invitar grupos:</label></td>
									</tr>
									  	<utils:showGroups />-->
									<tr>
										<td></td>
										<td align="right"><input type="submit"
											value="Agregar evento"><br /> <br /> <br /></td>
									</tr>
								</table>
							</form>

						</div>
						<div class="sidebar">
							<div>
								<h3>Buscar evento</h3>
								<form action="index.html">
									<input type="text" value="Búsqueda"
										onblur="this.value=!this.value?'Busqueda':this.value;"
										onfocus="this.select()" onclick="this.value='';"> <input
										type="submit" value="">
								</form>
							</div>
							<div class="blog-categories">
								<a href="addevent.jsp" style="text-decoration: none"><h3>Agregar
										evento</h3></a>
							</div>
							<div>
								<h3>Agregar lista de tareas</h3>
								<br /> <br /> <br /> <br />
							</div>
						</div>
					</div>
				</div>
				<div class="footer">
					<p>&#169; 2014 MEMO | AGENDA EN LINEA</p>
					<ul>
						<li><a href="index.jsp">Inicio</a></li>
						<li><a href="about.jsp">Perfil</a></li>
						<li><a href="projects.jsp">Agenda</a></li>
						<li><a href="blog.jsp">Ajustes</a></li>
						<li><a href="contact.html">Contacto</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>