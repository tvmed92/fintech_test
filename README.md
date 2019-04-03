# fintech_test

Приложение для тестирования формы заявки на странице [Вакансии](https://www.tinkoff.ru/career/vacancies/), а также страницы [Тарифы Тинькофф Мобайла](https://www.tinkoff.ru/mobile-operator/tariffs/).


Запуск:
----------------------------------------
Для запуска тестов из командной строки перейдите в корневую директорию.

Чтобы запустить все тесты в приложении последовательно, введите следующую команду:


```mvn test или mvn -Dtest=TestFirst,TestSecond,TestThird,TestFourth test```


Чтобы запустить тесты в браузере Chrome, введите команду:


```mvn -Dtest=TestFirst,TestSecond,TestThird,TestFourth -Dbrowser=chrome test```


Для запуска одного из тестов введите имя нужного теста в качестве параметра в -Dtest= (TestFirst, TestSecond, TestThird, TestFourth).
