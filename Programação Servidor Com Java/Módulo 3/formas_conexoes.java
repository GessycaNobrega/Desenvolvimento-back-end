//Com relação à codificação Java, os componentes do JDBC estão presentes no pacote java.sql, e o processo para utilização segue quatro passos simples:

//Instanciar a classe do driver de conexão.
//Obter uma conexão (Connection) a partir da Connection String, usuário e senha.
//Instanciar um executor de SQL (Statement)
//Executar os comandos DML (linguagem de manipulação de dados).

ArrayList<String> listaDescricoes = new ArrayList<>();

//No início do código, temos o driver Derby sendo instanciado a partir a partir de uma chamada para o método forName. Com o driver instanciado, ele fica disponível para o aplicativo, permitindo abrir as conexões com o banco de dados através de JDBC.
 
// passo 1
Class.forName("org.apache.derby.jdbc.ClientDriver");
 
//Em seguida, é instanciada a conexão c1, por meio da chamada ao método getConnection, da classe DriverManager, e os parâmetros fornecidos são a Connection String, o usuário e a senha. Quanto à Connection String, ela pode variar muito, sendo iniciada pelo driver utilizado, seguido dos parâmetros específicos para aquele driver, que, no caso do Derby, são o endereço de rede, a porta e o nome do banco de dados.

// passo 2
Connection c1 = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/loja",
                "loja", "loja");
// passo 3
Statement st = c1.createStatement();
 
 //A partir da conexão c1, é gerado um executor de SQL de nome st, com a chamada para o método createStatement. Com o executor instanciado, realizamos uma consulta ao banco, através da invocação do método executeQuery, recebendo um ResultSet.
 
// passo 4 e recepção no ResultSet
ResultSet r1 = st.executeQuery("SELECT * FROM PRODUTO");
 
while(r1.next())
   listaDescricoes.add("Produto " + r1.getInt("codigo")+
                       ": " + r1.getString("nome"));
r1.close();
st.close();
c1.close();