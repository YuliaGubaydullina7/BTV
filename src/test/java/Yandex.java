import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

    public class Yandex {
        @BeforeAll
        public static void setUp() {
            Configuration.pageLoadStrategy = "eager";
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\gubaydullina.ym\\.cache\\selenium\\yandexdriver\\yandexdriver.exe");
            Configuration.browserBinary = "C:\\Users\\gubaydullina.ym\\AppData\\Local\\Yandex\\YandexBrowser\\Application\\browser.exe";
            Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-gpu");
            Configuration.pageLoadStrategy = "eager";
            Configuration.baseUrl = "https://bolshoe.tv/promo/test/";
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setAcceptInsecureCerts(true);
            chromeOptions.addArguments("--headless");
            try {
                new ChromeDriver(chromeOptions);
            } catch (final WebDriverException e) {
                throw new RuntimeException("Unable to create driver", e);
            }
        } //тест на проигрывание контента в яндекс браузере + юзер-агент iOS
        @Test
        void Yandex() {
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


