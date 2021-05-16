package cz.czechitas.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navigace {

    WebDriver prohlizec;

    public Navigace (WebDriver prohlizec) {
        this.prohlizec = prohlizec;
    }

    public void klikniNaTlacitkoPrihlasit() {
    WebElement tlacitkoPrihlasitZHP = prohlizec.findElement(By.xpath("//div[2]/a/i"));
        tlacitkoPrihlasitZHP.click();
    }

    public void klikniNaTlacitkoProUcitele() {
    //WebElement tlacitkoProUcitele = prohlizec.findElement(By.xpath("//nav/div/div[1]/div[2]/a"));
    //tlacitkoProUcitele.click();

    WebElement tlacitkoProUcitele = prohlizec.findElement(By.xpath("//div[@class = 'navbar-nav']//a[text() = '\n" +
            "                        Pro učitelé                    ']"));
        tlacitkoProUcitele.click();
    }

    public void vyberObjednavkaProSkoly() {
    WebElement tlacitkoProUcitele = prohlizec.findElement(By.xpath("//div[@class = 'navbar-nav']//a[text() = '\n" +
                "                        Pro učitelé                    ']"));
        tlacitkoProUcitele.click();

        WebElement objednavkaProSkoly = prohlizec.findElement(By.xpath("//a[text() = 'Objednávka pro MŠ/ZŠ']"));
        objednavkaProSkoly.click();
    }

    public void vyberNavodyAFormulare() {
        WebElement tlacitkoProUcitele = prohlizec.findElement(By.xpath("//div[@class = 'navbar-nav']//a[text() = '\n" +
                "                        Pro učitelé                    ']"));
        tlacitkoProUcitele.click();

        WebElement navodyAFormulare = prohlizec.findElement(By.xpath("//div/div[1]/div[2]/div/a[1]"));
        navodyAFormulare.click();
    }
}
