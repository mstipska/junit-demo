package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrankaNovaObjednavkaSkoly {

    WebDriver prohlizec;

    public StrankaNovaObjednavkaSkoly (WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void vyplnNovaObjednavkaSkoly () {
    WebElement poleICO = prohlizec.findElement(By.id("ico"));
        poleICO.sendKeys("62156781");

    WebElement poleZastupce = prohlizec.findElement(By.id("substitute"));
        poleZastupce.sendKeys("Marie Jesen");

    WebElement poleJmenoPrijmeniKontaktOsob = prohlizec.findElement(By.id("contact_name"));
        poleJmenoPrijmeniKontaktOsob.sendKeys("Marie Jesen");
    WebElement poleTelefonKontaktOsob = prohlizec.findElement(By.id("contact_tel"));
        poleTelefonKontaktOsob.sendKeys("602000000");
    WebElement poleEmailKontaktOsob = prohlizec.findElement(By.id("contact_mail"));
        poleEmailKontaktOsob.sendKeys("xx@email.cz");
    WebElement poleTermin1Zacatek = prohlizec.findElement(By.id("start_date_1"));
        poleTermin1Zacatek.sendKeys("20.06.2021");
    WebElement poleTermin1Konec = prohlizec.findElement(By.id("end_date_1"));
        poleTermin1Konec.sendKeys("10.07.2021");
    WebElement tlacitkoSkolaVPrirode = prohlizec.findElement(By.id("nav-home-tab"));
        tlacitkoSkolaVPrirode.click();
    WebElement polePocetDeti = prohlizec.findElement(By.id("camp-students"));
        polePocetDeti.sendKeys("20");
    WebElement poleVeVeku = prohlizec.findElement(By.id("camp-age"));
        poleVeVeku.sendKeys("10");
    WebElement polePocetDoprovodu = prohlizec.findElement(By.id("camp-adults"));
        polePocetDoprovodu.sendKeys("3");

    WebElement tlacitkoUlozObjednavku = prohlizec.findElement(By.xpath("//div[5]/div[1]/div[2]/input"));
        tlacitkoUlozObjednavku.click();
    }

}
