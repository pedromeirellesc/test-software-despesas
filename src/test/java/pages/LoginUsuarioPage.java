package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginUsuarioPage extends BasePage {

    @FindBy(id = "login")
    private WebElement txtLogin;

    @FindBy(id = "senha")
    private WebElement txtSenha;

    @FindBy(id = "btnSubmit")
    private WebElement btnSubmit;

    public LoginUsuarioPage(WebDriver driver) {
        super(driver);
    }

    public LoginUsuarioPage inserirLogin(String Login) {
        txtLogin.sendKeys(Login);
        return this;
    }

    public LoginUsuarioPage inserirSenha(String senha) {
        txtSenha.sendKeys(senha);
        return this;
    }
 
    public LoginUsuarioPage submitForm() {
        btnSubmit.click();
        return this;
    }

    public String findResult() {
        return driver.getPageSource();
    }
}