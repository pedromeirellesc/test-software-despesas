package test;

import base.BaseTest;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CadastroCredorPage;

public class CadastroCredorTest extends BaseTest {

    public CadastroCredorTest() {
        super("\\src\\main\\resources\\formularioCadastroCredor.html");
    }

    @BeforeClass
    public void setup() {
        super.preCond();
    }

    @Test
    public void testeCadastro() {
        CadastroCredorPage page = new CadastroCredorPage(getDriver());
        page.cadastroCredor("Henrique")
                .cadastroCelular(123456789)
                .cadastroTelefone(987654321)
                .cadastroEmail("teste@email.com")
                .cadastroBase("Base teste")
                .cadastroCEP(91750740)
                .cadastroBanco("Caixa")
                .cadastroAgencia(9999)
                .cadastroCC(88888)
                .cadastroDigito(123456)
                .clicarCadastrar(); // Descomentei essa linha para submeter o formulário

        // Aguarde a submissão e o carregamento da resposta
        Awaitility.await().until(() -> page.buscarResultadoCadastro().contains("Cadastro realizado com sucesso"));

        String testeFinal = page.buscarResultadoCadastro();

        // Verifique a mensagem de sucesso
        Assert.assertTrue(testeFinal.contains("Cadastro realizado com sucesso"), "A mensagem de sucesso não foi encontrada.");
    }

    @Test
    public void testeCadastro2() {
        CadastroCredorPage page = new CadastroCredorPage(getDriver());
        page.cadastroCredor("321654987")
                .cadastroCelular(123456789)
                .cadastroTelefone(987654321)
                .cadastroEmail("teste@email.com")
                .cadastroBase("Base teste")
                .cadastroCEP(91750740)
                .cadastroBanco("Caixa")
                .cadastroAgencia(9999)
                .cadastroCC(88888)
                .cadastroDigito(123456)
                .clicarCadastrar();

        // Espera até que a página tenha a mensagem de err0
        Awaitility.await().until(() -> page.buscarResultadoCadastro().contains("Nome deve conter apenas letras."));

        //Verifica se a mensagem de sucesso não está presente
        String testeFinal2 = page.buscarResultadoCadastro();

        // Verifica se a mensagem de erro está presente
        Assert.assertTrue(testeFinal2.contains("Nome deve conter apenas letras."), "A mensagem de erro para o nome do credor não foi encontrada.");
    }


}