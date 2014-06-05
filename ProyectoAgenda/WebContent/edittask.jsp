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
							<h3>Editar Tarea</h3>
							<s:form action="modificarTarea" method="post">
								<s:hidden name="ldt.idCreador" value="#session['usuario'].idUsuario" />
								<s:hidden name="ldt.idLDT" value="ldt.idLDT"/> 
								<table style="margin-left: 10px;">
									<tr>
										<td><label>*Nombre de la tarea: </label></td>
										<td><s:textfield  name="tarea.nombre" size="31" /></td>
									</tr>
									
									<tr>
										<td><label>*Descripción:</label></td>
										<td><s:textarea  name="tarea.descripcion" cols ="23" rows="10"/></td>
									</tr>
									<tr>
										<td></td>
										<td align="right"><input type="submit"
											value="Editar Tarea"><br /> <br /> <br /></td>
									</tr>
								</table>
							</s:form>

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
								<a href="addtasklist.jsp" style="text-decoration: none"><h3>Agregar lista de tareas</h3></a>
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