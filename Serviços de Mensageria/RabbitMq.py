#O objetivo do código send.py, apresentado a seguir, é enviar uma mensagem de “Ola Mundo!” para o servidor RabbitMQ.

import pika

credentials = pika.PlainCredentials('admin', '123')
connection = pika.BlockingConnection(pika.ConnectionParameters('192.168.56.101',5672,'/',credentials))

channel = connection.channel()

channel.queue_declare(queue='hello')

channel.basic_publish(exchange='',routing_key='hello', body='Ola Mundo!')

print(" [x] Enviado 'Ola Mundo!'")
connection.close()

#Consumidor em Python

import pika, sys, os

def main():
    credentials = pika.PlainCredentials('admin', 'kamisama123')
    connection = pika.BlockingConnection(pika.ConnectionParameters('192.168.56.101',5672,'/',credentials))

    channel = connection.channel()
    channel.queue_declare(queue='hello')

    def callback(ch, method, properties, body):
        print(" [x] Recebido %r" % body)

    channel.basic_consume(queue='hello', 
       on_message_callback=callback, auto_ack=True)

    print(' [*] Aguardando Mensagens. Para sair pressione CTRL+C')
    channel.start_consuming()

if __name__ == '__main__':
    try:
        main()
    except KeyboardInterrupt:
        print('Interrupted')
        try:
            sys.exit(0)
        except SystemExit:
            os._exit(0)

#Executando os códigos em Python

#Agora, colocaremos tudo para funcionar. Inicialmente, execute o receive.py para que o consumidor de mensagens fique monitorando a fila “hello”.

$ Python receive.py
[*] Aguardando Mensagens. Para sair pressione CTRL+C



Light Mode

Copiar

#Em outro terminal, execute o send.py:

$ Python send.py
[x] Enviado 'Ola Mundo!'

#Nesse momento, se observarmos o terminal do consumidor, teremos:

$ Python receive.py 
 [*] Aguardando Mensagens. Para sair pressione CTRL+C
 [x] Recebido b'Ola Mundo!'


#Você pode ainda testar enviar a mensagem “Ola Mundo!” mais vezes, observe:

$ Python send.py 
 [x] Enviado 'Ola Mundo!'
$ Python send.py 
 [x] Enviado 'Ola Mundo!'
$ Python send.py 
 [x] Enviado 'Ola Mundo!'


$ Python receive.py 
 [*] Aguardando mensagens.  Para sair pressione CTRL+C 
 [x] Recebido b'Ola Mundo!' 
 [x] Recebido b'Ola Mundo!' 
 [x] Recebido b'Ola Mundo!'