package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrankaAkci {

    WebDriver prohlizec;

    public StrankaAkci (WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void vyberAkciProgramovani() {
    WebElement tlacitkoVytvorPrihlaskuProgramovani = prohlizec.findElement(By.xpath("//div[@class = 'card']//a[text() = 'Vytvořit přihlášku']"));
    tlacitkoVytvorPrihlaskuProgramovani.click();
    }
}
