package Steps;

import Base.BaseUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hook {
    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {
        /*
            W tym miejscu należy podać ścieżkę do pliku *.exe z Chromedriver
            https://chromedriver.storage.googleapis.com/index.html?path=84.0.4147.30/
         */
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        base.Driver = new ChromeDriver();
        base.Wait = new WebDriverWait(base.Driver, 30);
    }

    @After
    public void TearDownTests() {
        base.Driver.quit();
    }
}
