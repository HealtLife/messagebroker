
### 2. **`start-rabbitmq.bat`**:

```batch
@echo off

:: Levanta RabbitMQ en Docker
docker run -d --name rabbitmq -p 15672:15672 -p 5672:5672 rabbitmq:management

echo RabbitMQ debería estar corriendo ahora en http://localhost:15672
pause
