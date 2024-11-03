package Pages;

import AbstractComponents.abstractClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logIN extends abstractClass {
    WebDriver driver;


    public  logIN(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@type='email']")
    WebElement email;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password;
    @FindBy(id = "login")
    WebElement logInBtn;
    @FindBy(css="[class*='flyInOut']")
    WebElement errMsg;

    public void Goto(){
        driver.navigate().to("https://rahulshettyacademy.com/client");
    }
    public productPage logged(String emailId, String pass){
        email.sendKeys(emailId);
        password.sendKeys(pass);
        logInBtn.click();

        productPage pp=new productPage(driver);
        return pp;
    }

    public String getErrorMsg(){
     waitWebelementVisibility(errMsg);
      return errMsg.getText();
    }



}
