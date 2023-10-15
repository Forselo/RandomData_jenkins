package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@Tag("demoqa")
public class PracticeForm  {
    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void demoQaTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
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

    }

}
