### Тестовое задание на позицию Java Developer

#### Требования:
- Проект должен собираться Maven (pom)
- Написать простой web сервис для Tomcat 7 возвращающий по Get запросу с параметром найденную запись из БД в виде json.
- Реализация сервиса должна позволять возвращать все поля заданного в конфигурационном файле приложения произвольного SQL запроса без пересборки исполняемого кода.
- в качестве БД используем derby, подключение (прописывается в context.xml) - url="jdbc:derby://localhost:1527/test" username="uname" password="pass"
- sql запрос (прописывается в web.xml) - select * from ttable where id = ?
- обрабатываемый get запрос - http://localhost:8080/db2any/bykey/getjson?key=1
- требуемый формат ответа 
```json
{
  "data": {
    "ID": 1,
    "VALUE": "first"
  },
  "response": "ok",
  "request":"1"
}
```
где data - все поля запроса с их значениями, response - признак успеха или причина сбоя, request - переданное на вход значение


#### Реализация

Сборка:
```
mvn clean install
```

Endpoint для получения записи со всеми полями
```
http://localhost:8080/simple_webapp_war/db2any/bykey/getjson?key=<value>
```
где _value_ - значение ключа для поиска записи