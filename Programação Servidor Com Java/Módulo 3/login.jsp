<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <body>
      <h1>Acesso ao Sistema</h1>
      <form action="ServletLogin" method="post">
         <input type="hidden" name="acao" value="conectar"/>
         Login: <input type="text" name="login"/>
         Senha: <input type="password" name="senha"/>
         <input type="submit" value="login"/>
      </form>
<%
   if(request.getAttribute("erro")!=null) {
%>
      <hr/>Ocorreu um erro: <%=request.getAttribute("erro")%>   
<%
   }
%>
    </body>
</html>


//Na primeira parte de Login.jsp, temos um formulário HTML bastante simples, contendo as informações que deverão ser enviadas para ServletLogin no processo de verificação, enquanto na segunda parte apresentamos mensagens de erro de autenticação. Note que a segunda parte será apresentada apenas se o atributo de erro estiver presente na chamada ao JSP, e que, por se tratar de um atributo, e não de um parâmetro, não permite o envio a partir do protocolo HTTP, mas apenas por meio do código do Servlet.