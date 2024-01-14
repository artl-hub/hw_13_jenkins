import data.DataFaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;


@DisplayName("Заполненение формы регистрации и проверка")
@Tag("hw_13")
public class RegistrationPageTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    DataFaker data = new DataFaker();

    @DisplayName("Полное заполнение формы, отправка и проверка")
    @Test
    void fillFormTestFaker() {

        step("Открытие полное заполнение и отправка формы", () -> {
            registrationPage.openPage()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.userEmail)
                    .setGender(data.gender)
                    .setuserNumber(data.phoneNumber)
                    .setDateOfBirth(data.dayOfBirth, data.monthOfbirth, data.yearOfbirth)
                    .setSubject(data.subjects)
                    .setHobbi(data.hobbies)
                    .selectFile("img/1.png")
                    .setAddress(data.streetAddress)
                    .selectState(data.state)
                    .selectCity(data.city)
                    .submitForm();
        });

        step("Проверка отправленных данных ", () -> {
            registrationPage.checkAppearedTable()
                    .checkHeaderTextOfTable(data.titleModal)
                    .checkResult("Student Name", data.name)
                    .checkResult("Student Email", data.userEmail)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.phoneNumber)
                    .checkResult("Date of Birth",
                            data.dayOfBirth + "\n" +
                                    data.monthOfbirth + "," +
                                    data.yearOfbirth)
                    .checkResult("Subjects", data.subjects)
                    .checkResult("Hobbies", data.hobbies)
                    .checkResult("Picture", "1.png")
                    .checkResult("Address", data.streetAddress)
                    .checkResult("State and City", data.state + "\n" + data.city);

        });
    }

    @DisplayName("Минимальное заполнение формы, отправка и проверка")
    @Test
    void minimumfillFomTest() {
        step("Минимальное заполнение и отправка формы", () -> {

            registrationPage.openPage()
                    .setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setGender(data.gender)
                    .setuserNumber(data.phoneNumber)
                    .setDateOfBirth(data.dayOfBirth, data.monthOfbirth, data.yearOfbirth)
                    .submitForm();
            ;
        });
        step("Проверка отправленных данных ", () -> {

            registrationPage.checkAppearedTable()
                    .checkHeaderTextOfTable(data.titleModal)
                    .checkResult("Student Name", data.firstName + "\n" + data.lastName)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.phoneNumber)
                    .checkResult("Date of Birth",
                            data.dayOfBirth + "\n" +
                                    data.monthOfbirth + "," +
                                    data.yearOfbirth);

        });
    }

    @DisplayName("Отправка пустой формы")
    @Test
    void emptyFormNegativeTest() {

    step("Отправка пустой формы", () -> {
            registrationPage
                    .openPage()
                    .submitForm()
                    .checkEmptyFormNotSended();
        });




    }
}



