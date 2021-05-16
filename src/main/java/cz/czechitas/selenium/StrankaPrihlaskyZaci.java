package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrankaPrihlaskyZaci {

    WebDriver prohlizec;

    public StrankaPrihlaskyZaci(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void klikniNaVytvoritNovouPrihlasku() {
    WebElement tlacitkoVytvorNovouPrihlasku = prohlizec.findElement(By.xpath("//div[@class = 'card']//a[text() = 'Vytvořit novou přihlášku']"));
        tlacitkoVytvorNovouPrihlasku.click();
    }
}
