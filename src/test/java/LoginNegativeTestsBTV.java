import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginNegativeTestsBTV {
    @Test
    void negativeLoginTestBTV() {
        Configuration.pageLoadStrategy = "eager";
        open("https://bolshoe.tv/promo/test/");
        $(".header__menu__flex").click();
        $(".reg-modal-window");
        $("#phone").setValue("3247659218");
        $(".continue").click();
        $(".reg-modal-window__code");
        $("#idPassFirstDigit").setValue("5");
        $("#idPassSecondDigit").setValue("9");
        $("#idPassThirdDigit").setValue("8");
        $("#idPassFourthDigit").setValue("0");
        $("[class=simple-login__sms]").shouldHave(text("Неверный код"));
    }
}

