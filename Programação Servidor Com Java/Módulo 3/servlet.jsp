@WebServlet(name = "ServletLogin",
            urlPatterns = {"/ServletLogin"})
public class ServletLogin extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {
      String acao = request.getParameter("acao");
      if(acao==null)
         throw new ServletException("Parâmetro Requerido");
      HttpSession session = request.getSession();
      switch(acao){
      case "conectar":
         if(request.getParameter("login").equals("admin")&&
            request.getParameter("senha").equals("123")){
            session.setAttribute("usuario", "Administrador");
            response.sendRedirect("Segura.jsp");
         } else {
            request.setAttribute("erro","Dados inválidos.");
            RequestDispatcher rd =
               request.getRequestDispatcher("Login.jsp");
            rd.forward(request,response);
         }
         break;
      case "desconectar":
         session.invalidate();
         response.sendRedirect("index.html");               
         break;
      default:
         throw new ServletException("Parâmetro incorreto");
      }
   }
}


//Aqui estamos tratando de um processo de login muito simples, mas que, por se tratar de uma autenticação de usuário, deverá adotar apenas o método doPost. O parâmetro acao, indicando a solicitação de conexão ou desconexão, é obrigatório, sendo gerada uma exceção caso ele não seja fornecido.


//A partir de uma instrução switch, com base no parâmetro acao, temos a implementação da autenticação e da desconexão do sistema. Observe que o Java permite uso de texto para os desvios de fluxo do switch, mas apenas nas versões atuais da plataforma.


//Para responder à ação "conectar" é feito um teste, em que apenas o login "admin" e a senha com valor "123" permitirão a autenticação. Fornecidos os valores corretos, temos o acréscimo do atributo usuario à sessão, contendo o valor "Administrador", e ocorre o redirecionamento para a página Segura.jsp.

//Caso sejam fornecidas credenciais diferentes das estipuladas, será definido o atributo erro para a requisição, com a mensagem "Dados Inválidos", e ocorrerá o retorno para Login.jsp, por meio de um redirecionamento interno.