package com.gosch.addressbook.tests;

import com.gosch.addressbook.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    // static - чтобы ссылка была общей для всех тестов
    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    // BeforeMethod - запуск перед каждым тестовым методом
    // BeforeClass - запускается один раз перед всеми тестовыми методами, которые входят в какой-то класс
    // BeforeGroups - в TestNG есть возможность указать что тестовый метод принадлежит к какой-то группе,
    // тем самым для каждой группы можно написать свой собственный метод инициализации
    // BeforeSuite - в TestNG он всегда один единственный, соответствует одному запуску и он может состоять из нескольких тестов
    // Сделать Suite состоящий из нескольких тестовых методов можно только благодаря конфигурационного файла
    // Если запускать тесты из среды разработки по правой кнопки на пакет или на класс, то Suite создаётся автоматически,
    // и он состоит из одного единственного теста, в этом случае между Suite и Test нету разницы
    // Разница возникает, только в том случае, когда используется конфигурационный файл.
    // Suite всегда один единственный, Test - может быть несколько; Test - часть Suite-а;
    // Test включает в себя какие-то Class-ы, Class состоит из нескольких тестовых методов;
    // Hierarchy: Suit->Test->Class->Method

    //@BeforeMethod
    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
    }

    //@AfterMethod
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

}
