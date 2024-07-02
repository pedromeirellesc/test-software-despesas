package test;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LancamentoDespesaPage;

public class LancamentoDespesaTest extends BaseTest {

    @Test
    public void realizarLancamentoDespesa() {
        LancamentoDespesaPage page = new LancamentoDespesaPage(getDriver());

        page.selectIdBase(1).selectIdCredor(1).nomeDespesa("Nome teste").valorLiquido("10,00").submitForm();
    }

}
