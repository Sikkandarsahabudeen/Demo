package Pages;

import AbstractComponents.abstractClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class productPage extends abstractClass {
    WebDriver driver;


    public  productPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".mb-3")
    List<WebElement> products;
    By prod=By.cssSelector("b");
    By card=By.cssSelector(".card-body button:last-of-type");
    By toast=By.cssSelector("#toast-container");
    By animat=By.cssSelector(".ng-animating");
    @FindBy(css=".ng-animating")
    WebElement animation;
    @FindBy(css="[routerlink*='cart']")
    WebElement routerLink;

    public List<WebElement> getPro(){
        return products;
    }
    public resulPage findProduct(List<WebElement> prods, String ProdName) {

        WebElement pr = prods.stream().filter(product -> product.findElement(prod).getText().equals(ProdName)).findFirst().orElse(null);
        pr.findElement(card).click();
        waitVisibility(toast);
        waitInvisiblity(animation);
        routerLink.click();
        resulPage RP=new resulPage(driver);
        return RP;
    }

}
