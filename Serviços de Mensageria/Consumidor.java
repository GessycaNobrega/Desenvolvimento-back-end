//Assim como em outras linguagens de programação, o Java dá suporte ao RabbitMQ utilizando a biblioteca amqp-client. Você pode usar o Maven ou o Gradle como ferramenta de gerenciamento de dependências, em ambas é possível configurar para que essa biblioteca possa ser inserida em seu projeto.


//OBS: Baixar o arquivo jar na versão 5.16.0 de um repositório na Web.


//Produtor em JAVA

//O objetivo do código Produtor.java é enviar uma mensagem de “Ola Mundo!” para o nosso servidor RabbitMQ! Veja:

package app;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Produtor {

 public static void main(String[] args) {
	  ConnectionFactory factory = new ConnectionFactory();
	  factory.setUsername("admin");
	  factory.setPassword("123");
	  factory.setHost("192.168.56.101");
	  try (Connection connection = factory.newConnection()) {
	    Channel channel = connection.createChannel();
	    channel.queueDeclare("hello", false, false, false, null);
	    String mensagem = "Ola Mundo!";
	    channel.basicPublish("", "hello", null, mensagem.getBytes("UTF-8"));
		  
	  } catch (IOException | TimeoutException e) {
		         e.printStackTrace();
	  }
 }

}

//


//Nas linhas 1 a 6, definimos o pacote de nosso código e importamos as classes necessárias para comunicar com o RabbitMQ, além de classes de exceção (erros) que devem ser tratados em Java.

//Nas linhas 11 a 14, criamos a factory e configuramos ela com os parâmetros, como o username e password do servidor RabbitMQ (linhas 12 e 13), e o endereço IP do servidor (linha 14). Na linha 15, tentamos abrir uma conexão com o servidor RabbitMQ, se houver alguma falha, a exceção será tratada nas linhas 21 a 22. Se tudo der certo, conseguimos a conexão com o servidor e o objeto connection representa essa conexão.

//Na linha 16, criamos um objeto channel a partir de conexão e na linha 17 informamos que a mensagem será enviada para a fila “hello”. Criamos a string que contém a mensagem (linha 18). Na linha 19, enviamos a mensagem para a exchange default, que é representada por “” no primeiro parâmetro do método basicPublish de channel.

//Pronto! O código deve ser capaz de enviar a mensagem “Ola Mundo” para a exchange default, fila “hello” do nosso servidor RabbitMQ.


****************************************************************

//Consumidor em Java:

package app;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
public class Consumidor {
 public static void main(String[] args) {
	ConnectionFactory factory = new ConnectionFactory();
	factory.setUsername("admin");
	factory.setPassword("123");
	factory.setHost("192.168.56.101");
	try (Connection connection = factory.newConnection()) {
	  Channel channel = connection.createChannel();
	  channel.queueDeclare("hello", false, false, false, null);
	  Consumer consumer = new DefaultConsumer(channel) {
	    @Override
	    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
	      String mensagem = new String(body, "UTF-8");
	      System.out.println("Mensagem recebida: " + mensagem);
		}
	   };
	  channel.basicConsume("hello", true, consumer);
	} catch (IOException | TimeoutException e) {
		e.printStackTrace();
	}
 }

}

//O código pode parecer complexo, mas a complexidade é da linguagem Java, e não do uso da amqp-client! Nas linhas 1 a 10, definimos o pacote de nossa classe e realizamos os imports necessários. Nas linhas 13 a 16, criamos um objetivo connection que representa a conexão com o servidor RabbitMQ e configuramos os parâmetros relacionados com o servidor.


//Na linha 17, tentamos realizar a conexão com o servidor. Caso aconteça algum problema, o erro será tratado nas linhas 28 a 30. Na linha 18 e 19, criamos um objeto channel que informa ao servidor que utilizará a file “hello”.


//Agora sim, a partir da linha 18 temos a parte mais complexa do Java.


//Na linha 18, criamos um objeto consumer a partir de channel. As chaves que abrimos na linha 20 e fechamos na linha 26 informam ao Java que faremos “algo” nesse objeto da classe Consumer. Esse “algo” nada mais é que sobrescrever o método handleDelivery, que é o método chamado automaticamente quando uma mensagem chega na exchange default, fila “hello” do nosso servidor.

******************************************************************

Executando os códigos em Java


//Vamos executar cada um dos códigos. Inicialmente, você deve se certificar de que o servidor RabbitMQ está executando. Em seguida, executamos o Produtor.java. Ele não produz nenhuma mensagem, mas envia a mensagem “Ola Mundo!” para o servidor.

Mensagem recebida: Ola Mundo!