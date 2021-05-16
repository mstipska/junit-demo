package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StrankaPrihlaseniDoAplikace {

    WebDriver prohlizec;

    public StrankaPrihlaseniDoAplikace(WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void prihlasSeDoAplikace() {
    WebElement poleEmail = prohlizec.findElement(By.id("email"));
        poleEmail.sendKeys("eedragon@seznam.cz");
    WebElement poleHeslo = prohlizec.findElement(By.id("password"));
        poleHeslo.sendKeys("123456Hh");
    WebElement tlacitkoPrihlaseniHP = prohlizec.findElement(By.xpath("//button[@type='submit']"));
        tlacitkoPrihlaseniHP.click();
    }

}
