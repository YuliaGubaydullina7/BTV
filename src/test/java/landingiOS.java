import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class landingiOS {
    @Test
    void LANDING() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        String userAgentValue = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.6 Safari/605.1.15 testios";
        System.setProperty("chromeoptions.args", "--user-agent=" +"\"" + userAgentValue + "\"");
        open("https://bolshoe.tv/landing-test/lpy5/#/movie/45391");
        $("._play_utq3f_1").should(visible, Duration.ofSeconds(300));;
        $("._install_wrhvk_1").click();
    }
}

