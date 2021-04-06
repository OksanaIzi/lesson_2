import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AutomationPractiseFormTest {

    String name = "Test",
            lastName = "Testik",
            email = "test@test.com",
            phone = "1234567891",
            genderName = "Female",
            subject = "Physics",
            hobby = "Reading",
            month = "May",
            year = "1992",
            day = "12",
            convertedDate = day + month + "," + year;

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void successfulPractiseFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue(name);   //name
        $("#lastName").setValue(lastName);    //lastname
        $("#userEmail").setValue(email);   //emeil
        $("[for='gender-radio-2']").click();   //gender
        $("#userNumber").setValue(phone);   //phone
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").find(byText(month)).click();
        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__day--0" + day).click();
        $("#subjectsContainer").click();   //Subject
        $("#subjectsInput").setValue(subject).pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue(name);   //CurrentAddres
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();
        $(".modal-content").shouldHave(text(name),
                text(lastName),
                text(email),
                text(genderName),
                text(phone),
                text(subject),
                text(convertedDate),
                text(hobby),
                text("1.jpg"),
                text("NCR Delhi"));
    }
}
