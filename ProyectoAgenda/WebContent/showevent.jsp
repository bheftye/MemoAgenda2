<!DOCTYPE html>
<%@ taglib uri="WEB-INF/utils.tld" prefix="utils"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta charset="UTF-8">
<title>Agenda - MEMO</title>
<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="stylesheet" href="css/styles.css" type="text/css">
<style>
</style>
</head>
<body>
	<div id="background-lightgreen"></div>
	<div class="page">
		<div class="blog-page">
			<div class="sidebar">
				<a href="portal.jsp" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class=" home"><a href="index.jsp">Inicio</a></li>
					<li class="about"><a href="about.jsp">Perfil</a></li>
					<li class="selected blog"><a href="blog.jsp">Agenda</a></li>
				</ul>
				<div class="connect">
				</div>
			</div>
			<div class="body">
				<div class="login">
					Bienvenido
					<s:property value="#session['usuario'].alias" />|
					<s:url action="cerrarSesion" var="linkCerrar">
					</s:url>
					<a href="${linkCerrar}">Cerrar sesión</a>
				</div>
				<div class="content-blog">
					<div>
						<div>
							<h3>Información de Evento</h3>
							<table style="margin-left: 20px;">
								<utils:showEventInfo id_evento="${eventoInfo}" />
							</table>
							<br /> <br /> <br /> <br /> <br />
						</div>
						<div class="sidebar">
						</div>
					</div>
				</div>
				<div class="footer">
					<p>&#169; 2014 MEMO | AGENDA EN LINEA</p>
					<ul>
						<li><a href="index.jsp">Inicio</a></li>
						<li><a href="about.jsp">Perfil</a></li>
						<li><a href="projects.jsp">Agenda</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>