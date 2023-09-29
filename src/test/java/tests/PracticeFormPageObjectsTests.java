package tests;

import org.junit.jupiter.api.Test;

public class PracticeFormPageObjectsTests extends TestBase {
    private static final String URL_DEMO_QA = "/automation-practice-form";
    @Test
    void demoQaTest() {
        registrationPage.openPage(URL_DEMO_QA)
                .setFirstName("Seva")
                .setLastName("Ivanov")
                .setEmail("aaa@a.com")
                .setGender("Male")
                .setUserNumber("7986957850")
                .setDateOfBirth("01", "February", "1991")
                .setSubjects("Arts")
                .setHobby("Sports")
                .uploadPicture("panda.jpg")
                .setCurrentAddress("Kazan")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmit();


        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", "Seva Ivanov")
                .verifyResult("Student Email", "aaa@a.com")
                .verifyResult("Gender", "Male")
                .verifyResult("Mobile", "7986957850")
                .verifyResult("Date of Birth", "01 February,1991")
                .verifyResult("Subjects", "Arts")
                .verifyResult("Hobbies", "Sports")
                .verifyResult("Picture", "panda.jpg")
                .verifyResult("Address", "Kazan")
                .verifyResult("State and City", "NCR Delhi");
    }
}
