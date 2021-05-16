package cz.czechitas.selenium;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class StrankaNovaPrihlaska {

    WebDriver prohlizec;

    public StrankaNovaPrihlaska (WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void vyplnNovouPrihlasku() {
    WebElement rozeviraciSeznamTermin = prohlizec.findElement(By.xpath("//button/div/div/div"));
        rozeviraciSeznamTermin.click();
    WebElement vyberTerminZeSeznamu = prohlizec.findElement(By.xpath("//*[@id=\"bs-select-1-0\"]"));
        vyberTerminZeSeznamu.click();
    WebElement jmenoPrijmeniZZ = prohlizec.findElement(By.id("parent_name"));
        Assertions.assertNotNull(jmenoPrijmeniZZ , "Výpis jména neproběhl");
    WebElement poleJmenoZaka = prohlizec.findElement(By.id("forename"));
        poleJmenoZaka.sendKeys("Lojzík");
    WebElement polePrijmeniZaka = prohlizec.findElement(By.id("surname"));
        polePrijmeniZaka.sendKeys("Žák");
    WebElement poleNarozeniZaka = prohlizec.findElement(By.id("birthday"));
        poleNarozeniZaka.sendKeys("11.06.2016");
    WebElement poleEmailZastupce = prohlizec.findElement(By.id("email"));
        Assertions.assertNotNull(poleEmailZastupce , "Výpis e-mailu zástupce neproběhl");
    WebElement vyberPlatby = prohlizec.findElement(By.xpath("//span[4]/label"));
        vyberPlatby.click();
    WebElement polickoSouhlasVOPD = prohlizec.findElement(By.xpath("//tr[11]/td[2]/span/label"));
        polickoSouhlasVOPD.click();
    WebElement tlacitkoVytvorPrihlasku = prohlizec.findElement(By.xpath("//input[@type='submit']"));
        tlacitkoVytvorPrihlasku.click();
    }
}
