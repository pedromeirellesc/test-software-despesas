package test;

import base.BaseTest;
import org.awaitility.Awaitility;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.CadastroUsuarioPage;

public class CadastroUsuarioTest extends BaseTest {

    public CadastroUsuarioTest() {
        super("\\src\\main\\resources\\form_cadastro_usuario.html");
    }

    
    @BeforeClass
    public void setup() {
        super.preCond();
    }

    @Test
    public void testeCadastro() {
        CadastroUsuarioPage page = new CadastroUsuarioPage(getDriver());
        page.cadastroNome("Teste").cadastroEmail("teste@gmail.com").cadastroLogin("loginteste").cadastroSenha("123456789").clicarCadastrar();

        Awaitility.await().until(() -> page.buscarResultadoCadastro().contains("Cadastro realizado com sucesso"));

        String testeFinal = page.buscarResultadoCadastro();

        Assert.assertTrue(testeFinal.contains("Cadastro realizado com sucesso"), "A mensagem de sucesso não foi encontrada.");
    }

    @Test
    public void testeCadastro2() {
        CadastroUsuarioPage page = new CadastroUsuarioPage(getDriver());
        page.cadastroNome("Teste").cadastroLogin("loginteste").cadastroSenha("123456789").clicarCadastrar();

        Awaitility.await().until(() -> page.buscarResultadoCadastro().contains("Por favor, preencha todos os campos."));

    }


}