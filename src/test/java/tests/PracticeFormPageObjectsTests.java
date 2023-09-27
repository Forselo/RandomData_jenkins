package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class PracticeFormPageObjectsTests extends TestBase {
    @Test
    void demoQaTest() {
        registrationPage.openPage()
                .setFirstName("Seva")
                .setLastName("Ivanov")
                .setEmail("aaa@a.com")
                .setGender("Male")
                .setUserNumber("7986957850")
                .setDateOfBirth("01", "February", "1991");

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
