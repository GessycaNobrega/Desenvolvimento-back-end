//As sessões HTTP são de grande utilidade no ambiente Web, provendo uma forma de manutenção de estados na troca de páginas, pois ao contrário dos sistemas desktop, com valores mantidos na alternância de janelas, a cada página temos um novo conjunto de variáveis, desconsiderando-se todas as existentes antes da requisição ser efetuada.

//Podemos controlar sessões de forma muito simples, com o uso da classe HttpSession, e um exemplo típico de utilização é no controle de login. Normalmente, temos um Servlet para a verificação do login, e a sessão deve ser obtida a partir do objeto de requisição, com a invocação do método getSession.


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   if(session.getAttribute("usuario")==null)
      response.sendRedirect("Login.jsp");
   else {
%>
<!DOCTYPE html>
<html>
   <body>
      <h1>Esta é uma página protegida!</h1>
      O usuário <%=session.getAttribute("usuario")%>
      está logado.<br/>
      <form action="ServletLogin" method="post">
      <input type="hidden" name="acao" value="desconectar"/>
      <input type="submit" value="logout"/>
      </form>
   </body>
</html>
<% } %>


//Na primeira parte do arquivo JSP, temos o teste para a existência do atributo "usuário" na sessão, e se ele não existir, isto significa que não há um usuário autenticado, devendo ocorrer o redirecionamento para a página de login através de sendRedirect.

//Ainda observando o código da página JSP, podemos notar que a instrução else é aberta antes do início do código HTML e fechada apenas no final, logo após a tag de finalização, significando que a página de resposta será processada apenas se o atributo usuário estiver presente na sessão, ou seja, se existir alguém autenticado no sistema. Quando ocorre a montagem da página, temos um retorno bastante simples, com a exibição do login corrente, obtido através de getAttribute, e um botão para efetuar o logout, ou desconexão, por meio de uma chamada para ServletLogin.