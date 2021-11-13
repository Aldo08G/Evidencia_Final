<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="controller.registro" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro</title>
</head>
<body>
   Registrate<br><br>
   <form action="registro" method="post">
      Nombre<br>
      <input type="text" name="nombre" value=""><br>
      Apellido<br>
      <input type="text" name="apellido" value=""><br>
      Edad<br>
      <input type="text" name="edad" value=""><br>
      Sexo<br>
      <input type="radio" id="sexo" name="sexo" value="Masculino">Masculino<br>
      <input type="radio" id="sexo" name="sexo" value="Femenino">Femenino<br>
      Usuario<br>
      <input type="text" name="usuario" value=""><br>
      Password<br>
      <input type="text" name="password" value=""><br>
      <input type="submit" value="Registrar">
   </form>
   <a href="index.jsp">Regresar</a><br>
   
   <% String mensaje = (String)request.getAttribute("usuarioExistente");
      if (mensaje == null) {
    	  mensaje = "";
      }
   %>
   
   <%=mensaje%>
   
</body>
</html>