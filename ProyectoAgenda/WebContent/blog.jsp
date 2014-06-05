<!DOCTYPE html>
<%@ taglib uri="/WEB-INF/utils.tld" prefix="utils"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
				<a href="portal.jsp" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class="home"><a href="index.jsp">Inicio</a></li>
					<li class="about"><a href="about.jsp">Perfil</a></li>
					<li class="selected blog"><a href="blog.jsp">Agenda</a></li>
				</ul>
				<div class="connect">
				</div>
			</div>
			<div class="body">
				<div class="login">
					Bienvenido
					<s:property value="#session['usuario'].alias" /> |
					<s:url action="cerrarSesion" var="linkCerrar">
					</s:url>
					<a href="${linkCerrar}">Cerrar sesión</a>
				</div>
				<div class="content-blog">
					<div>
						<div>
							<h3>Agenda</h3>
							<div style="color: black;">${successMessage}</div>
								<p>
								<center>
								<utils:setDate/>
								</center>	
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
						</div>
						<div class="sidebar">
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
						<li><a href="blog.jsp">Agenda</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>