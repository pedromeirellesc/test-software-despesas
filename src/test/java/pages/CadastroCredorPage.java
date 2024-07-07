package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CadastroCredorPage extends BasePage {

    @FindBy(id = "creditorName")
    private WebElement nomeCredor;
    @FindBy(id = "creditorCelular")
    private WebElement celular;
    @FindBy(id = "creditorTelefone")
    private WebElement telefone;
    @FindBy(id = "creditorEmail")
    private WebElement email;
    @FindBy(id = "creditorBase")
    private WebElement base;
    @FindBy(id = "cep")
    private WebElement cep;
    @FindBy(id = "creditorBanco")
    private WebElement banco;
    @FindBy(id = "creditorAgencia")
    private WebElement agencia;
    @FindBy(id = "creditorCC")
    private WebElement cc;
    @FindBy(id = "creditorDigito")
    private WebElement digito;
    @FindBy(id = "botao")
    private WebElement botao;

    public CadastroCredorPage(WebDriver driver) {
        super(driver);
    }


    public CadastroCredorPage cadastroCredor(String nome) {
        nomeCredor.sendKeys(nome);
        return this;
    }

    public CadastroCredorPage cadastroCelular(Integer idCelular) {
        this.celular.sendKeys(idCelular.toString());
        return this;
    }

    //public void acessarPagina() {
    //    driver.get("https://www.google.com.br/");
    // }

    public CadastroCredorPage cadastroTelefone(Integer idTelefone) {
        this.telefone.sendKeys(idTelefone.toString());
        return this;
    }

    public CadastroCredorPage cadastroEmail(String idEmail) {
        email.sendKeys(idEmail);
        return this;
    }

    public CadastroCredorPage cadastroBase(String idBase) {
        base.sendKeys(idBase);
        return this;
    }

    public CadastroCredorPage cadastroCEP(Integer idCep) {
        this.cep.sendKeys(idCep.toString());
        return this;
    }

    public CadastroCredorPage cadastroBanco(String idBanco) {
        banco.sendKeys(idBanco);
        return this;
    }

    public CadastroCredorPage cadastroAgencia(Integer idAgencia) {
        this.agencia.sendKeys(idAgencia.toString());
        return this;
    }

    public CadastroCredorPage cadastroCC(Integer idCC) {
        this.cc.sendKeys(idCC.toString());
        return this;
    }

    public CadastroCredorPage cadastroDigito(Integer idDigito) {
        this.digito.sendKeys(idDigito.toString());
        return this;
    }

    public String buscarResultadoCadastro() {
        return driver.getPageSource();
    }


    public CadastroCredorPage clicarCadastrar() {
        botao.click();
        return this;
    }


}
