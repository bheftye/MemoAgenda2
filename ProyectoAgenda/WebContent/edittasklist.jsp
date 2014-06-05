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
					<a href="${linkCerrar}">Cerrar sesi�n</a>
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
										<td><label>*Fecha de l�mite:</label></td>
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
									<s:form action="mostrarTarea">
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
										<td><label>*Descripci�n:</label></td>
										<td><s:textarea  name="tarea.descripcion" cols="27" rows="10" /></td>
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