//No fragmento de código apresentado, temos a recuperação de um parâmetro de nome valor, enviado através do protocolo HTTP, sendo recuperado no formato texto, a partir do método getParameter do objeto request, mas que teve a conversão para o formato inteiro com a chamada para parseInt. Em seguida, temos a escrita do conteúdo no canal de saída, através do objeto response, utilizando a sintaxe HTML.

int a = Integer.parseInt(request.getParameter("valor"));
response.getWriter().println("<html><body>Valor Enviado: "+a+
                             "</body></html>");


// No modelo desktop, temos a armazenagem de objetos em um espaço de memória local, permitindo que os dados sejam mantidos durante toda a execução do sistema, mesmo que ocorra a troca de janelas, o que viabiliza a manutenção de estados, enquanto no modelo Web, a cada requisição e resposta, todos os objetos são recriados e o estado não pode ser mantido.


//Uma solução primária para a manutenção de estados no HTTP é o uso de cookies, algo que pode ser explorado por meio do Java Script.


function setUser(login) {
  var d = new Date();
  d.setTime(d.getTime() + (24 * 3600 * 1000)); // 24 horas
  document.cookie = "username=" + login + ";expires=" +
                    d.toUTCString() + ";path=/";
}
function getUSer() {
  var userStr = "username=";
  var ca = document.cookie.split(';');
  for(var i = 0; i < ca.length; i++) {
    var c = ca[i].trim();
    if (c.indexOf(usrStr) == 0)
      return c.substring(usrStr.length, c.length);
  }
  return "";
}


//Nas funções de exemplo, com sintaxe Java Script, temos o uso do atributo cookie, no objeto document, para armazenar o usuário logado de forma local. O momento para expiração da informação é calculado em milissegundos, sendo definido um prazo total de 24 horas, a partir do qual teremos a invalidação do cookie.