<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
   <form action="login" method="post">
      Usuario:<br>
      <input type="text" name="usuario" value=""><br>
      Password:<br>
      <input type="text" name="password" value=""><br>
      <input type="submit" value="Entrar">	
   </form>
   ¿Aun no eres usuario? <a href="registro.jsp">Registrate</a><br>
   
   <% String mensaje = (String)request.getAttribute("UsuarioRegistrado");
      if (mensaje == null) {
    	  mensaje = "";
      }
   %>
   
   <%=mensaje%>
   
</body>
</html>