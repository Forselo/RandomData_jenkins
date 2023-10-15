package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import utils.RandomUtils;

public class PracticeFormPageObjectsTests extends TestBase {
    private static final String URL_DEMO_QA = "/automation-practice-form";
    @Test
    void demoQaTest() {
        RandomUtils randomUtils = new RandomUtils();
        String[] birthDate = randomUtils.getBirthDateAsStringArray();
        String firstName = randomUtils.getFirstName(),
                lastName = randomUtils.getLastName(),
                email = randomUtils.getEmail(),
                gender = randomUtils.getGender(),
                mobileNumber = randomUtils.getMobileNumber(),
                birthDay = birthDate[0],
                birthMonth = birthDate[1],
                birthYear = birthDate[2],
                subject = randomUtils.getSubject(),
                hobby = randomUtils.getHobby(),
                pictureFileName = "panda.jpg",
                currentAddress = randomUtils.gerAddress(),
                state = randomUtils.getState(),
                city = randomUtils.getCityByState(state);

        registrationPage.openPage(URL_DEMO_QA)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(mobileNumber)
                .setDateOfBirth(birthDay, birthMonth, birthYear)
                .setSubjects(subject)
                .setHobby(hobby)
                .uploadPicture(pictureFileName)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears()
                .verifyResult("Student Name", firstName + " " + lastName)
                .verifyResult("Student Email", email)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", mobileNumber)
                .verifyResult("Date of Birth", birthDay + " " + birthMonth + "," + birthYear)
                .verifyResult("Subjects", subject)
                .verifyResult("Hobbies", hobby)
                .verifyResult("Picture", pictureFileName)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", state + " " + city);
    }
}
