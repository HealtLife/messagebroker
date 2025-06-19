# Message Broker

## Iniciar RabbitMQ con Docker

Para levantar RabbitMQ en Docker y que el proyecto pueda conectarse a él, ejecuta el siguiente comando en tu terminal o PowerShell:

```bash
docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management
