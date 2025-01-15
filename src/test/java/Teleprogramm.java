import com.codeborne.selenide.*;
import com.codeborne.selenide.Selenide.*;
import org.junit.jupiter.api.Test;

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;

public class Teleprogramm {
    @Test
    void Teleprogramm() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = "chrome";
        String userAgentValue = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/128.0.0.0 YaBrowser/24.10.0.0 Safari/537.36";
        System.setProperty("chromeoptions.args", "--user-agent=" + "\"" + userAgentValue + "\"");
        open("https://bolshoe.tv/promo/web/tv/7952/");
        ElementsCollection divs = $$("[class*='NFo9ft4ywbZoOQGYxK3hfA'] div");
        divs.shouldHave(sizeGreaterThan(0));
        System.out.println("Number of elements: " + divs.size());
        if (divs.size() >=2 ) {
            for (SelenideElement div : divs) {
                System.out.println(div.getText()); // Prints the text of each div
            }
            System.out.println("Телепрограмма доступна");
        } else {
            System.out.println("Телепрограмма недоступна");
        }
    }
}
