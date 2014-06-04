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
							<h3>Editar lista de tareas</h3>
							<s:actionerror/>
							<s:form action="modificarLDT" method="post">
								<s:hidden name="ldt.idCreador" value="%{#session['usuario'].idUsuario}" />
								<table style="margin-left: 10px;">
									<tr>
										<td><label>*Nombre de la lista de tareas: </label></td>
										<td><s:textfield  name="ldt.nombre" value="%{ldt.nombre}" size="31" /></td>
									</tr>
									
									<tr>
										<td><label>*Fecha de límite:</label></td>
										<td><input type="text" name="ldt.fechLimite"
											id="datepicker" value="<s:property value="ldt.fechLimite"/>" size="31"></td>
									</tr>
									<tr>
										<td></td>
										<td align="right"><input type="submit"
											value="Editar LDT"><br /> <br /> <br /></td>
									</tr>
								</table>
							</s:form>
							<h1>Tareas</h1>
							<s:iterator value="ldt.tareas" status="a">
								<s:iterator value="ldt.tareas[#a.index]">
									<s:form action="mostrarLDT">
										<s:property value="nombre" />
										<s:hidden name="tarea.idTarea"
											value="%{idTarea}" />
										<s:submit cssClass="submit" style="display:inline" value="Ver" />
									</s:form>
								</s:iterator>
							</s:iterator>
							<h5>Agregar Tarea</h5>
							<s:form action="agregarTarea" method="post">
								<s:hidden name="tarea.idResponsable" value="%{#session['usuario'].idUsuario}" />
								<s:hidden name="tarea.idLDT" value="%{ldt.idLDT}"/> 
								<table style="margin-left: 10px;">
									<tr>
										<td><label>*Nombre de la tarea: </label></td>
										<td><s:textfield  name="tarea.nombre" size="31" /></td>
									</tr>
									
									<tr>
										<td><label>*Descripción:</label></td>
										<td><s:textarea  name="tarea.descripcion"  /></td>
									</tr>
									<tr>
										<td></td>
										<td align="right"><input type="submit"
											value="Agregar Tarea"><br /> <br /> <br /></td>
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