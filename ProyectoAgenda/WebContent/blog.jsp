<!DOCTYPE html>
<%@ taglib uri="WEB-INF/utils.tld" prefix="utils"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="UTF-8">
<title>Agenda - MEMO</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/styles.css" type="text/css">

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
					<s:property value="#session['usuario'].alias" /> |
					<s:a href="index.jsp" onClick="cerrarSesion">Cerrar sesión</s:a>
				</div>
				<div class="content-blog">
					<div>
						<div>
							<h3>Agenda</h3>

							<center>
								<p>
									<utils:setDate />
								<p>
								<form>
									<table width="500" border="2">
										<utils:showCalendar />
									</table>
									<table cellpadding="7">
										<utils:showNavigation />
									</table>
									<p>
								</form>
							</center>
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
								<a href="addevent.jsp"><h3>Agregar evento</h3></a>
							</div>
							<div>
								<a href="addtasklist.jsp"><h3>Agregar lista de tareas</h3></a>
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