package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("demoqa")
public class PracticeForm  {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
//        Configuration.holdBrowserOpen = true;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
    @Test
    void demoQaTest() {
        step("Открытие страницы", () -> {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        });
        step("Заполнение формы", () -> {
        $("#firstName").setValue("Seva");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("aaa@a.com");
        $("#gender-radio-1").parent().click();
        $("#userNumber").setValue("7986957850");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Arts");
        $("#subjectsInput").pressEnter();
        $(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("panda.jpg");
        $("#currentAddress").setValue("Kazan");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        });
        step("Проверка формы", () -> {
        $(".table").shouldHave(
                text("Seva Ivanov"),
                text("aaa@a.com"),
                text("Male"),
                text("7986957850"),
                text("01 February,1991"),
                text("Arts"),
                text("Sports"),
                text("panda.jpg"),
                text("Kazan"),
                text("NCR Delhi"));
        });

    }

}
