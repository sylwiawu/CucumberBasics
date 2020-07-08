package Steps;

import Base.BaseUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestStep {
    private BaseUtil base;

    public TestStep(BaseUtil base) {
        this.base = base;
    }

    @Given("I am on main site")
    public void iAmOnMainSite() throws InterruptedException {
        base.Driver.navigate().to("http://automationpractice.com/index.php");
        base.Wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php"));

        Assert.assertTrue(base.Wait.until(ExpectedConditions.urlContains("/index")));
    }

    @Given("I am on product site")
    public void iAmOnProductSite() {
        base.Driver.navigate().to("http://automationpractice.com/index.php?id_product=2&controller=product");
        base.Wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?id_product=2&controller=product"));
    }

    @When("I click on add to cart")
    public void iClickOnAddToCart() throws InterruptedException {
        base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add to cart')]")));
        base.Driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
    }

    @Then("Product is added to cart")
    public void productIsAddedToCart() {
        Assert.assertTrue(base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@class='layer_cart_product col-xs-12 col-md-6']//h2[1]"), "Product successfully added to your shopping cart")));
    }

    @Given("I am on a login site")
    public void iAmOnALoginSite() {
        base.Driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        base.Wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=authentication&back=my-account"));
    }

    @When("I enter my credentials")
    public void iEnterMyCredentials() throws InterruptedException {
        base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='email']")));
        base.Driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ImBatman@gmail.com");

        base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='passwd']")));
        base.Driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("Joker12");
    }

    @And("I click sign in")
    public void iClickSignIn() throws InterruptedException {
        base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='submit']//span[1]")));
        base.Driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
    }

    @Then("Logged user is {string}")
    public void loggedUserIs(String username) {
        base.Wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='account']")));

        Assert.assertEquals(base.Driver.findElement(By.xpath("//a[@class='account']")).getText(), username);
    }

    @When("I type {string} in search bar")
    public void iTypeInSearchBar(String productName) {
        base.Wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='search_query_top']")));
        base.Driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(productName);
    }

    @And("I click enter")
    public void iClickEnter() {
        base.Driver.findElement(By.xpath("//input[@id='search_query_top']")).sendKeys(Keys.ENTER);
    }

    @Then("Result found shown for {string}")
    public void resultFoundShownFor(String productName) {
        Assert.assertTrue(base.Wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@class='lighter']"), productName)));
    }
}
