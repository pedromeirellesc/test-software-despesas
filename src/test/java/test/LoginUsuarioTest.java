package test;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginUsuarioPage;

public class LoginUsuarioTest extends BaseTest {

    public LoginUsuarioTest() {
        super("\\src\\main\\resources\\form_login_usuario.html");
    }

    @BeforeClass
    public void setup() {
        super.preCond();
    }
    
    @Test
    public void realizarLoginComSucesso() {
        LoginUsuarioPage page = new LoginUsuarioPage(getDriver());

        page.inserirLogin("loginteste")
            .inserirSenha("123456789")
            .submitForm();

        String resultsPage = page.findResult(); 

        Assert.assertTrue(resultsPage.contains("Bem-vindo!"));
    }

    @Test
    public void realizarLoginComCredenciaisInvalidas() {
        LoginUsuarioPage page = new LoginUsuarioPage(getDriver());

        page.inserirLogin("usuarioInvalido")
            .inserirSenha("senhaInvalida")
            .submitForm();

        String resultsPage = page.findResult();

        Assert.assertTrue(resultsPage.contains("Credenciais inválidas."));
    }
}
