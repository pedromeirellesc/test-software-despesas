package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroUsuarioPage extends BasePage {

    @FindBy(id = "nomeUsuario")
    private WebElement nomeU;
    @FindBy(id = "emailUsuario")
    private WebElement emailU;
    @FindBy(id = "loginUsuario")
    private WebElement loginU;
    @FindBy(id = "senhaUsuario")
    private WebElement senhaU;
    @FindBy(id = "botao")
    private WebElement botao;

    public CadastroUsuarioPage(WebDriver driver) {
        super(driver);
    }


    public CadastroUsuarioPage cadastroNome(String nome) {
        nomeU.sendKeys(nome);
        return this;
    }

    public CadastroUsuarioPage cadastroEmail(String email) {
        emailU.sendKeys(email);
        return this;
    }

    public CadastroUsuarioPage cadastroLogin(String login) {
        loginU.sendKeys(login);
        return this;
    }

    public CadastroUsuarioPage cadastroSenha(String senha) {
        senhaU.sendKeys(senha);
        return this;
    }


    public String buscarResultadoCadastro() {
        return driver.getPageSource();
    }


    public CadastroUsuarioPage clicarCadastrar() {
        botao.click();
        return this;
    }


}
