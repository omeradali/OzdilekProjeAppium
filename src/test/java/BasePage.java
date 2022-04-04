import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {
    @Step("<int> saniye bekle")
    public void waitSecond(int s) throws InterruptedException {
        Thread.sleep(1000 * s);


    }

    @Step("<id> elementi bul ve tıkla")
    public void findElementAndClick(String id) {
        MobileElement element = appiumDriver.findElement(By.id(id));
        if (element.isDisplayed()) {
            element.click();
        } else {
            System.out.println("Aranan element bulunamadı!!!!!");
        }

    }

    @Step("<id> yeni elementi bul tıkla")
    public void findAndClickCategorie(String id) {
        MobileElement element2 = appiumDriver.findElement(By.xpath(id));
        if (element2.isDisplayed()) {
            element2.click();
        } else {
            System.out.println("Kategoriler elementi bulunamadı");
        }
    }

    @Step("Sayfayı aşağı doğru kaydır")
    public void swipeDown() {
        int startx = 700, starty = 2700, endx = 710, endy = 500;
        TouchAction touchAction = new TouchAction(appiumDriver);
        touchAction.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release().perform();

    }

    @Step("Rastgele Ürün Seçimi Yapılır")
    public void selectRandom() {
        List<MobileElement> elements = appiumDriver.findElements(By.xpath("//*[@resource-id=\"com.ozdilek.ozdilekteyim:id/imageView\"]\n"));
        Random random = new Random();
        int randomInt = random.nextInt(elements.size());
        elements.get(randomInt).click();

    }


    @Step("<id> E-Posta gir")
    public void eMail(String lgn) {
        MobileElement element3 = appiumDriver.findElement(By.id(lgn));
        element3.sendKeys("omerradalii@gmail.com");
        assortCheck(By.id("com.ozdilek.ozdilekteyim:id/etEposta"));

    }

    @Step("<id> Sifre Gir")
    public void passwordPut(String psw) {
        MobileElement element4 = appiumDriver.findElement(By.id("psw"));
        element4.sendKeys("Omeromer12!");
    }

    @Step("Geri Git Butonuna Tıkla")
    public void goBack() {
        MobileElement element5 = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/ivBack"));
        element5.click();

    }

    @Step("Ürünü Sepete Ekle")
    public void addProductToBasket() {
        MobileElement element6 = appiumDriver.findElement(By.id("com.ozdilek.ozdilekteyim:id/relLayAddCartBtn"));
        element6.click();
    }
    public void assortCheck(By by){
        Assert.assertTrue(appiumDriver.findElement(by).isDisplayed());
    }


}
