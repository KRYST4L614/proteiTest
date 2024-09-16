Для запуска необходимо:
  1)  Спулить [Selenium Grid с Chrome на борту](https://hub.docker.com/r/selenium/standalone-chrome) командой: ```docker pull selenium/standalone-chrome:128.0```
  2)  Из директории с проектом запустить контейнер командой: ```docker run --rm -d -p 4444:4444 -p 7900:7900 -v ${PWD}:/dev/test --shm-size="2g" selenium/standalone-chrome:128.0```
  3)  Запустить тесты
За происходящим внутри контейнера можно следить по адресам localhost:4444 и localhost:7900, пароль: secret
*********
Некоторые тесты не проходят ввиду багов, они зафиксированы в виде баг-репортов в файле [Bugs.docx](https://github.com/KRYST4L614/proteiTest/blob/master/Bugs.docx)
*********
- Стек использованных технологий:
	- Selenium
	- TestNG
