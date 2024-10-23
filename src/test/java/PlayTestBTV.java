import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class PlayTestBTV {
    @Test
    void PlayTestBTV() {
        Configuration.pageLoadStrategy = "eager";
        open("https://bolshoe.tv/promo/test/");
        $(".header__menu__flex").click();
        $(".reg-modal-window");
        $("#phone").setValue("3247659210");
        $(".continue").click();
        $(".reg-modal-window__code");
        $("#idPassFirstDigit").setValue("1");
        $("#idPassSecondDigit").setValue("2");
        $("#idPassThirdDigit").setValue("3");
        $("#idPassFourthDigit").setValue("4");
        $("[class=reg-phone_pc]").shouldHave(text("73247659210"));
        open("https://bolshoe.tv/promo/test/movie/40551/"); //premier ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("https://bolshoe.tv/promo/test/movie/50984"); //start ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("https://bolshoe.tv/promo/test/movie/50752"); //телеканал ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("https://bolshoe.tv/promo/test/movie/42118/"); //TVIGLE
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("https://bolshoe.tv/promo/test/tv/6291/"); //бесплатный тв-канал
        $("#id_channel_play").click();
        $(".player__channel").should(visible, Duration.ofSeconds(20));
        open("https://bolshoe.tv/promo/test/tv/2/"); //матч тв-канал платный
        $("#id_channel_play").click();
        $(".player__channel").should(visible, Duration.ofSeconds(20));
    }
}
