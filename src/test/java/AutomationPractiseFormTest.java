import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPractiseFormTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }
    @Test
    void successfulPractiseFormTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Test");   //name
        $("#lastName").setValue("Testik");    //lastname
        $("#userEmail").setValue("test@test.com");   //emeil

        $("[for='gender-radio-2']").click();   //gender

        $("#userNumber").setValue("1234567891");   //phone

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("4");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--012").click();

        $("#subjectsContainer").click();   //Subject
        $("#subjectsInput").setValue("Physics").pressEnter();

        $("[for='hobbies-checkbox-2']").click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");

        $("#currentAddress").setValue("Test");   //CurrentAddres

        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Test"),
                text("Testik"),
                text("test@test.com"),
                text("Female"),
                text("1234567891"),
                text("Physics"),
                text("12 May,1992"),
                text("Reading"),
                text("1.jpg"),
                text("NCR Delhi"));
    }
}
