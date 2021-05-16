package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrankaDomovskaStranka {

    WebDriver prohlizec;

    public StrankaDomovskaStranka(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void vyberkurztestovani() {
    WebElement tlacitkoViceInfoKurzTestovani = prohlizec.findElement(By.xpath("//div[@class = 'card']//a[text() = 'Více informací']"));
        tlacitkoViceInfoKurzTestovani.click();
    }

}
