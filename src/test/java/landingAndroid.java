import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class landingAndroid {
    @Test
    void  LANDING3() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        String userAgentValue = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 YaBrowser/24.10.0.0 Safari/537.36";
        System.setProperty("chromeoptions.args", "--user-agent=" +"\"" + userAgentValue + "\"");
        open("https://bolshoe.tv/landing-test/lpy5/#/movie/49414?segment=sts_plaksa&package_id=5700&utm_campaign=%7Bcampaign_id%7D&utm_medium=yandex_lp&utm_source=YandexDirect&series=last&utm_term=%7Bkeyword%7D&ad_id=%7Bad_id%7D&gbid=%7Bgbid%7D&click_id=%7Byclid%7D&mt_campaign=%7Bcampaign_id%7D&mt_sub1=%7Bcampaign_name%7D&mt_sub4=%7Bsource%7D&regid=%7BLOGID%7D&logid=%7BLOGID%7D&mt_adset=%7Bgbid%7D&mt_creative=%7Bad_id%7D&mt_network=%7Bsource_type%7D");
        $("._play_utq3f_1").should(visible, Duration.ofSeconds(30));
//        $("style=display: none;").shouldNot(visible, Duration.ofSeconds(30));
        $("._install_wrhvk_1").click();
    }
}

