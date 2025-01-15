import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class PlayTestBTV {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://bolshoe.tv/promo/test/";
        Configuration.pageLoadStrategy = "eager";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void PlayTestBTV() {
        String userAgentValue = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.6 Safari/605.1.15 testios";
        System.setProperty("chromeoptions.args", "--user-agent=" +"\"" + userAgentValue + "\"");
        Selenide.open("https://bolshoe.tv/promo/test/");
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
        open("movie/40551/"); //premier ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("movie/50984"); //start ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("movie/50752"); //телеканал ЕК
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("movie/42118/"); //TVIGLE
        $("#id_play").click();
        $(".player").should(visible, Duration.ofSeconds(20));
        open("tv/11/"); //бесплатный тв-канал
        $("#id_channel_play").click();
        $(".player__channel").should(visible, Duration.ofSeconds(200));
        open("tv/7392/"); //матч тв-канал платный
        $("#id_channel_play").click();
        $(".player__channel").should(visible, Duration.ofSeconds(20));
    }
}

