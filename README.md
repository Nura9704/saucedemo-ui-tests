# SauceDemo UI Tests (Java + Selenium + JUnit5 + Allure)

Автоматизация тестирования авторизации на https://www.saucedemo.com/

## Стек
- Java 17
- Maven
- Selenium WebDriver
- JUnit 5
- Allure Reports
- Page Object Model (POM)

## Предусловия
- Установлен JDK 17+
- Установлен Maven
- Установлены браузеры: Chrome/Firefox/Edge
- Selenium 4 умеет сам поднимать драйверы (Selenium Manager), отдельно скачивать chromedriver обычно не нужно.

## Запуск тестов
### Chrome (по умолчанию)
```bash
mvn clean test
