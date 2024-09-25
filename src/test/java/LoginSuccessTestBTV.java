import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginSuccessTestBTV {
    @Test
    void successfulLoginTestBTV() {
        Configuration.pageLoadStrategy = "eager";
        open("https://bolshoe.tv/promo/test/");
        $(".header__menu__flex").click();
        $(".reg-modal-window");
        $("#phone").setValue("3247659218");
        $(".continue").click();
        $(".reg-modal-window__code");
        $("#idPassFirstDigit").setValue("1");
        $("#idPassSecondDigit").setValue("2");
        $("#idPassThirdDigit").setValue("3");
        $("#idPassFourthDigit").setValue("4");
        $("[class=reg-phone_pc]").shouldHave(text("73247659218"));
    }
}

