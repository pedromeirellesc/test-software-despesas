package pages;

import base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;

public class LancamentoDespesaPage extends BasePage {

    @FindBy(id = "idBase")
    private WebElement selIdBase;

    @FindBy(id = "idCredor")
    private WebElement selIdCredor;

    @FindBy(id = "nomeDespesa")
    private WebElement txtNomeDespesa;

    @FindBy(id = "competenciaDespesa")
    private WebElement dateCompetenciaDespesa;

    @FindBy(id = "dataVencimento")
    private WebElement dateDataVencimento;

    @FindBy(id = "valorLiquido")
    private WebElement txtValorLiquido;

    @FindBy(id = "valorMulta")
    private WebElement txtValorMulta;

    @FindBy(id = "valorCorrecao")
    private WebElement txtValorCorrecao;

    @FindBy(id = "btnSubmit")
    private WebElement btnSubmit;

    public LancamentoDespesaPage(WebDriver drive) {
        super(drive);
    }

    public LancamentoDespesaPage selectIdBase(Integer idBase) {
        Select select = new Select(selIdBase);
        select.selectByIndex(idBase);

        return this;
    }

    public LancamentoDespesaPage selectIdCredor(Integer idCredor) {
        Select select = new Select(selIdCredor);
        select.selectByIndex(idCredor);

        return this;
    }

    public LancamentoDespesaPage nomeDespesa(String nomeDespesa) {
        txtNomeDespesa.sendKeys(nomeDespesa);

        return this;
    }

    public LancamentoDespesaPage competenciaDespesa(String competenciaDespesa) {

        String date[] = competenciaDespesa.split("-");
        String month = date[0];
        String year = date[1];

        dateCompetenciaDespesa.sendKeys(month);
        dateCompetenciaDespesa.sendKeys(Keys.TAB);
        dateCompetenciaDespesa.sendKeys(year);

        return this;
    }

    public LancamentoDespesaPage dataVencimento(String dataVencimento) {
        dateDataVencimento.sendKeys(dataVencimento);

        return this;
    }

    public LancamentoDespesaPage valorLiquido(String valorLiquido) {
        txtValorLiquido.sendKeys(valorLiquido);

        return this;
    }

    public LancamentoDespesaPage valorMulta(String valorMulta) {
        txtValorMulta.sendKeys(valorMulta);

        return this;
    }

    public LancamentoDespesaPage valorCorrecao(String valorCorrecao) {
        txtValorCorrecao.sendKeys(valorCorrecao);

        return this;
    }

    public LancamentoDespesaPage submitForm() {
        btnSubmit.click();

        return this;
    }

    public String findResult() {
        return driver.getPageSource();
    }

}
