import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class landingAndroid {
    @Test
    void LANDING() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        String userAgentValue = "Mozilla/5.0 (Linux; Android 14; K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.6613.148 Mobile Safari/537.36";
        System.setProperty("chromeoptions.args", "--user-agent=" +"\"" + userAgentValue + "\"");
        open("https://bolshoe.tv/promo/lpy6/#/movie/42674?segment=prem_pacankinew&package_id=5400&utm_campaign=%7Bcampaign_id%7D&utm_medium=yandex_lp&utm_source=YandexDirect&series=last&utm_term=%7Bkeyword%7D&ad_id=%7Bad_id%7D&gbid=%7Bgbid%7D&click_id=%7Byclid%7D&mt_campaign=%7Bcampaign_id%7D&mt_sub1=%7Bcampaign_name%7D&mt_sub4=%7Bsource%7D&regid=%7BLOGID%7D&logid=%7BLOGID%7D&mt_adset=%7Bgbid%7D&mt_creative=%7Bad_id%7D&mt_network=%7Bsource_type%7D");
        $("._play_utq3f_1").should(visible, Duration.ofSeconds(300));;
        $("._install_wrhvk_1").click();
    }
}

