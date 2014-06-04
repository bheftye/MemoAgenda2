<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="s" uri="/struts-tags"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MEMO | Agenda en Línea</title>

<link rel="stylesheet" href="css/style.css" type="text/css">
<link rel="icon" type="image/png" href="images/favicon-memo.png">

</head>
</head>
<body>

	<div id="background-green">background</div>
	<div class="page">
		<div class="home-page">
			<div class="sidebar">
				<a href="index.jsp" id="logo"><img src="images/logo.png"
					alt="logo"></a>
				<ul>
					<li class="selected home"><a href="portal.jsp">Inicio</a></li>
					<li class="about"><a href="about.jsp">Perfil</a></li>
					<li class="blog"><a href="blog.jsp">Agenda</a></li>
					<li class="projects"><a href="projects.html">Ajustes</a></li>
					<li class="contact"><a href="contact.html">Contacto</a></li>
				</ul>
				<div class="connect">
					<a href="http://www.facebook.com" id="fb">facebook</a>
					<a href="http://www.twitter.com" id="twitter">twitter</a>
				</div>
			</div>
			<div class="body">
				<div class="login">
				
					Bienvenido <s:property value="#session['usuario'].alias" /> | 					
					
					<s:a href="index.jsp" onClick="cerrarSesion">Cerrar sesión</s:a>
				
					
				</div>
				<div class="content-home">
					<div class="featured">
						<img src="images/memo-home.png" alt="">
					</div>
					<div>
						<div>
							<h3>
								Ahora organizar tus pendientes será <span class="beauty">sencillo</span>.
								Descubre <span class="function">MEMO</span> y todas las opciones
								que<br /> traemos <span class="works">para ti</span>.
							</h3>
							<p>MEMO es una aplicación web que te permite crear nuevos
								eventos y listas de tareas. Puedes editar eventos que ya tengas
								agregados, adjuntar imágenes y archivos, agregar recordatorios y
								compartir tus eventos con quién desees. Únete a la comunidad de
								personas que usan MEMO y disfruta de sus funcionalidades .</p>
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