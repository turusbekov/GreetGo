# GreetGo
Чтобы скачать с гитхаба проект запускаем команду:
    git clone https://github.com/turusbekov/GreetGo
В файле:
    GreeGo oткрываем папку project на Intellij и т.п.
В терминале
    Запустем mysql -u root -p
Создадим юзера diasaga
    CREATE USER 'diasaga'@'localhost' IDENTIFIED BY 'diasaga';
Так же создадим базу greetgo
    create database greetgo;
    use greetgo;
Создадим table:
    create table user (name varchar(255), surname varchar(255), email varchar(255), password varchar(255));
Дадим доступ юзеру diasaga:
    GRANT ALL PRIVILEGES ON greetgo . * TO 'diasaga'@'localhost';
Ждемб когда запуститься сервер. После запуска сервера, заходим в браузер по адресу:
    http://localhost:8080
И видим результат.
  email = admin
  password = admin
  
  
