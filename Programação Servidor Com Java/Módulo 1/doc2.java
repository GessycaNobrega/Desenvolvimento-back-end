//O servidor Tomcat pode ser utilizado como um serviço, executado a partir do ambiente do NetBeans, ou chamado diretamente pela linha de comando. Para executar na linha de comando, é necessário apontar a variável de ambiente JAVA_HOME para o local do JDK e executar o arquivo startup.bat, no Windows, ou startup.sh, para sistemas UNIX.

set JAVA_HOME="C:\Java\jdk\jdk1.7.0_80"
startup.bat

// O término da execução ocorrerá com a chamada para shutdown.bat


//No arquivo server.xml, do diretório conf, temos a possibilidade de alterar muitas das configurações do servidor, como o sistema de autenticação e a porta utilizada para a comunicação. A alteração da porta de conexão é feita no atributo com o nome port, presente nos elementos Connector, lembrando que o valor padrão é 8080.


<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000" redirectPort="8443" />
<Connector executor="tomcatThreadPool"
           port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000" redirectPort="8443" />

//Outro arquivo de grande importância, com o nome tomcat-users.xml, está presente no diretório conf. Para a autenticação padrão, podemos definir os usuários, as senhas e os perfis do servidor com o uso desse arquivo.


<?xml version="1.0" encoding="UTF-8"?>
<tomcat-users xmlns="http://tomcat.apache.org/xml"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"   
       version="1.0"
       xsi:schemaLocation="http://tomcat.apache.org/xml
       tomcat-users.xsd">
   <user password="tomcat" roles="manager-script,admin"
         username="tomcat"/>
</tomcat-users>

//Na configuração inicial, temos apenas o usuário padrão do Tomcat, com utilização dos perfis, ou regras (roles), que liberam as funções administrativas apenas em modo texto. Podemos efetuar uma alteração muito interessante no arquivo tomcat-users.xml, acrescentando os perfis manager-gui e admin-gui ao usuário tomcat.

<user password="tomcat"
      roles="manager-script,admin,manager-gui,admin-gui"
      username="tomcat"/>

    //Com a alteração efetuada, podemos acessar os gestores gráficos, clicando em alguns dos links presentes na página inicial do servidor, como Manager App e Host Manager.