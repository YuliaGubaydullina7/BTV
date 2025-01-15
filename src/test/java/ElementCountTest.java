import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

class ElementCountTest {
    public static void main(String[] args) {

        // Создаем экземпляр WebDriver для Chrome
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://bolshoe.tv/promo/web/");
            String cssSelector = ".collection";
            // Получаем список элементов по указанному классу
            List<WebElement> elements = driver.findElements(By.cssSelector(cssSelector));
            // Проверяем, есть ли элементы на странице
            if (elements.isEmpty()) {
                System.out.println("Нет элементов с классом: " + cssSelector);
            } else {
                int elementCount = elements.size();
                System.out.println("Количество элементов с классом: " + cssSelector + " = " + elementCount);
            }
        }
        finally {
            // Закрываем браузер
            driver.quit();
        }
    }
}