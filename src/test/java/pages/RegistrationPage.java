package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            modalDialog = $(".modal-dialog"),
            titleInTable = $("#example-modal-sizes-title-lg"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            stateCityWrapper = $("#stateCity-wrapper"),
            city = $("#city"),
            submit = $("#submit");
    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

    public RegistrationPage openPage() {

        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('#adplus-anchor').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;


    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setuserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }


    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbi(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectFile(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegistrationPage selectState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage selectCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage submitForm() {

        submit.click();

        return this;
    }


    public RegistrationPage checkResult(String key, String value) {
        checkResultComponent.checkResult(key, value);

        return this;
    }


    public RegistrationPage checkAppearedTable() {
        modalDialog.should(appear);


        return this;
    }

    public RegistrationPage checkHeaderTextOfTable(String value) {
        titleInTable.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkEmptyFormNotSended() {
        modalDialog.shouldBe(hidden);

        return this;


    }



}

