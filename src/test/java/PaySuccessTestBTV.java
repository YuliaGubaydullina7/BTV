import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PaySuccessTestBTV {
    @Test
    void successPayTestBTV() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        String userAgentValue = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36 Selenide";
        System.setProperty("chromeoptions.args", "--user-agent=" +"\"" + userAgentValue + "\"");
        open("https://bolshoe.tv/promo/test/account/packages");
        $(".packages__container__subscription__block__img__pc__container").click();
        $(".packages-info__container__pc__poster").shouldHave(Condition.attribute("style")).should(visible, Duration.ofSeconds(30));
        $(".packages-info__container__pc__buy").click();
        SelenideElement iframePayment = $x("//iframe[@class=' with-appled']");
        switchTo().frame(iframePayment);
        $x("(//input[@class='input-component__input'])[1]").click();
        $x("(//input[@class='input-component__input'])[1]").sendKeys("5200828282828210");
        $x("(//input[@id='date'])[1]").sendKeys("0126");
        $x("(//input[@id='cvv'])[1]").sendKeys("111");
        $x("(//button[@class='button button_primary'])[1]").click();
        $x("(//span[contains(text(),'Платёж завершён')])[1]").shouldHave(text("Платёж завершён"));
        $x("//div[@class='close']").click();
        switchTo().defaultContent();
        $x("(//h3[@class='_8Arfgx+TCq2Uzn5cHESWIA=='])[3]").click();
        $(".packages__container__subscription__block__img__pc").click();
        $(".packages-info__container__pc__container").shouldHave(text("Отменить подписку"));
    }
}