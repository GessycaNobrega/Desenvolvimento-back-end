//No fragmento de código apresentado, temos a recuperação de um parâmetro de nome valor, enviado através do protocolo HTTP, sendo recuperado no formato texto, a partir do método getParameter do objeto request, mas que teve a conversão para o formato inteiro com a chamada para parseInt. Em seguida, temos a escrita do conteúdo no canal de saída, através do objeto response, utilizando a sintaxe HTML.

int a = Integer.parseInt(request.getParameter("valor"));
response.getWriter().println("<html><body>Valor Enviado: "+a+
                             "</body></html>");
