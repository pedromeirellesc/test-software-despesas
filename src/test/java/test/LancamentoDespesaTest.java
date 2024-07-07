package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LancamentoDespesaPage;

public class LancamentoDespesaTest extends BaseTest {

    public LancamentoDespesaTest() {
        super("\\src\\main\\resources\\form_cadastro_despesas.html");
    }

    @BeforeClass
    public void setup() {
        super.preCond();
    }

    @Test
    public void realizarLancamentoDespesa() {
        LancamentoDespesaPage page = new LancamentoDespesaPage(getDriver());

        page.selectIdBase(1)
                .selectIdCredor(1)
                .nomeDespesa("Nome teste")
                .competenciaDespesa("07-2024")
                .dataVencimento("10-07-2024")
                .valorLiquido("10.00")
                .submitForm();

        String resultsPage = page.findResult();

        Assert.assertTrue(resultsPage.contains("Base física: Base física Norte"));
        Assert.assertTrue(resultsPage.contains("Credor: Giovanni Gustavo da Rocha"));
        Assert.assertTrue(resultsPage.contains("Nome despesa: Nome teste"));
        Assert.assertTrue(resultsPage.contains("Mês competência: 2024-07"));
        Assert.assertTrue(resultsPage.contains("Data vencimento: 2024-07-10"));
        Assert.assertTrue(resultsPage.contains("Valor líquido: 10.00"));
        Assert.assertTrue(resultsPage.contains("Valor multa:"));
        Assert.assertTrue(resultsPage.contains("Valor correção:"));
    }
    @Test
    public void realizarLancamentoDespesaSemValorLiquido() {
        LancamentoDespesaPage page = new LancamentoDespesaPage(getDriver());

        page.selectIdBase(1)
                .selectIdCredor(1)
                .nomeDespesa("Nome teste")
                .competenciaDespesa("07-2024")
                .dataVencimento("10-07-2024")
                .submitForm();

        String resultsPage = page.findResult();

        Assert.assertTrue(resultsPage.contains("Base física: Base física Norte"));
        Assert.assertTrue(resultsPage.contains("Credor: Giovanni Gustavo da Rocha"));
        Assert.assertTrue(resultsPage.contains("Nome despesa: Nome teste"));
        Assert.assertTrue(resultsPage.contains("Mês competência: 2024-07"));
        Assert.assertTrue(resultsPage.contains("Data vencimento: 2024-07-10"));
        Assert.assertTrue(resultsPage.contains("Valor líquido:"));
        Assert.assertTrue(resultsPage.contains("Valor multa:"));
        Assert.assertTrue(resultsPage.contains("Valor correção:"));
    }

}
