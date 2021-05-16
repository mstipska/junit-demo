package cz.czechitas.selenium;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class TestyPrihlasovaniNaKurzy {

    private static final String URL_APLIKACE = "https://cz-test-jedna.herokuapp.com/";

    WebDriver prohlizec;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mstips\\Downloads\\geckodriver-v0.29.1-win64\\geckodriver.exe");
        prohlizec = new FirefoxDriver();
        prohlizec.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    //1. Rodič s existujícím účtem se musí být schopen přihlásit do webové aplikace.
    //Poznámka: Nepište automatizovaný test na zakládání nového účtu rodiče. Účet si
    // připravte dopředu ručně nebo použijte svůj již existující z kurzu manuálního testování.
    //rodič: Hanka Rodič; heslo: 123456Hh; mail: eedragon@seznam.cz

    public void poStiskuTlacikaPrihlasitMusiBytZobrazenoPrihlasen() {
        prohlizec.navigate().to(URL_APLIKACE);

        Navigace vyberTlacitkoPrihlasit = new Navigace(prohlizec);
        vyberTlacitkoPrihlasit.klikniNaTlacitkoPrihlasit();

        StrankaPrihlaseniDoAplikace strankaSPrihlasovanim = new StrankaPrihlaseniDoAplikace(prohlizec);
        strankaSPrihlasovanim.prihlasSeDoAplikace();

        WebElement hlaseniPrihlasen = prohlizec.findElement(By.xpath("//span[text() = 'Přihlášen']"));
        Assertions.assertNotNull(hlaseniPrihlasen , "Přihlášení neproběhlo");
    }

    @Test
    //2.Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz.
    //Varianta, že rodič nejprve vybere kurz a potom se přihlásí ke svému účtu,
    // vyplní přihlášku, odešle ji a nakonec ve svém seznamu přihlášek zkontroluje, že ji systém eviduje.

    public void vyberKurzPrihlasRodiceVyplnPrihlaskuOdesliJiZkontrolujPrihlaskuVSystemu() {
        prohlizec.navigate().to(URL_APLIKACE);

        StrankaDomovskaStranka strankaHomePage = new StrankaDomovskaStranka(prohlizec);
        strankaHomePage.vyberkurztestovani();

        StrankaAkci strankaAkci = new StrankaAkci(prohlizec);
        strankaAkci.vyberAkciProgramovani();

        StrankaPrihlaseniDoAplikace strankaSPrihlasovanim = new StrankaPrihlaseniDoAplikace(prohlizec);
        strankaSPrihlasovanim.prihlasSeDoAplikace();

        StrankaNovaPrihlaska strankaSNovouPrihlaskou = new StrankaNovaPrihlaska(prohlizec);
        strankaSNovouPrihlaskou.vyplnNovouPrihlasku();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    //3.Rodič s existujícím účtem musí být schopen přihlásit svoje dítě na kurz.
    //Varianta, že se rodič nejprve přihlásí ke svému účtu a potom vybere kurz, vyplní, odešle, zkontroluje v seznamu.

    public void prihlasRodiceVyberKurzVyplnPrihlaskuOdesliJiZkontrolujPrihlaskuVSystemu() {
        prohlizec.navigate().to(URL_APLIKACE);

        Navigace zHomePageNaPrihlaseni = new Navigace(prohlizec);
        zHomePageNaPrihlaseni.klikniNaTlacitkoPrihlasit();

        StrankaPrihlaseniDoAplikace strankaSPrihlasovanim = new StrankaPrihlaseniDoAplikace(prohlizec);
        strankaSPrihlasovanim.prihlasSeDoAplikace();

        StrankaPrihlaskyZaci strankaSPrihlaskamiZaci = new StrankaPrihlaskyZaci(prohlizec);
        strankaSPrihlaskamiZaci.klikniNaVytvoritNovouPrihlasku();

        StrankaDomovskaStranka strankaHomePage = new StrankaDomovskaStranka(prohlizec);
        strankaHomePage.vyberkurztestovani();

        StrankaAkci strankaAkci = new StrankaAkci(prohlizec);
        strankaAkci.vyberAkciProgramovani();

        StrankaNovaPrihlaska strankaSNovouPrihlaskou = new StrankaNovaPrihlaska(prohlizec);
        strankaSNovouPrihlaskou.vyplnNovouPrihlasku();

        WebElement potvrzeniPrihlasky = prohlizec.findElement(By.xpath("//*[text()='Stáhnout potvrzení o přihlášení']"));
        Assertions.assertNotNull(potvrzeniPrihlasky);
    }

    @Test
    //4. Nepřihlášený uživatel vytvoří objednávku pro MŠ/ZŠ a následně zkontroluje v systému.
    //IČO 62156781; kontakt os Marie Jesen; cislo 602000000; mail xx@email.cz;
    public void neprihlasenyUzivatelVytvoriObjednavkuProSkolyAZkontrolujeVSystemu() {
        prohlizec.navigate().to(URL_APLIKACE);

        Navigace prejdiNaObjednavkaProSkoly = new Navigace(prohlizec);
        prejdiNaObjednavkaProSkoly.vyberObjednavkaProSkoly();

        StrankaNovaObjednavkaSkoly strankaSNovouObjednavkouSkoly = new StrankaNovaObjednavkaSkoly(prohlizec);
        strankaSNovouObjednavkouSkoly.vyplnNovaObjednavkaSkoly();

        WebElement potvrzeniObjednavky = prohlizec.findElement(By.xpath("//h3[text()='Děkujeme za objednávku']"));
        Assertions.assertNotNull(potvrzeniObjednavky);
    }



    @AfterEach
    public void tearDown() {
        prohlizec.close();
    }
}
