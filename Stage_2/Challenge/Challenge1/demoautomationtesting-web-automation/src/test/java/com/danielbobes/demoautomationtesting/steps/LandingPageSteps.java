package com.danielbobes.demoautomationtesting.steps;

import com.danielbobes.demoautomationtesting.config.DriverManager;
import com.danielbobes.demoautomationtesting.pages.LandingPage;
import com.danielbobes.demoautomationtesting.pages.RegisterPage;
import com.danielbobes.demoautomationtesting.utils.DataFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LandingPageSteps {

    private LandingPage landingPage = new LandingPage(DriverManager.getDriver());
    private RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());

    @Given("que estoy en la página principal")
    public void verificarPaginaPrincipal() {
        Assert.assertTrue(landingPage.isLandingPage(), "Deberíamos estar en la página principal");
    }

    @When("no informo el email")
    public void noInformoEmail() {
        landingPage.typeEmail("");
    }

    @When("informo el email con un email no válido")
    public void informoEmailInvalido() {
        landingPage.typeEmail("test");
    }

    @When("informo el email con un email válido")
    public void informoEmailValido() {
        landingPage.typeEmail(DataFactory.getValidEmail());
    }

    @And("hago clic en el botón continuar")
    public void pulsarEnContinuar() {
        landingPage.clickOnEnterButton();
    }

    @Then("el campo email debe marcarse como inválido")
    public void verificarEmailInvalido() {
        Assert.assertTrue(landingPage.isEmailInvalid(), "El campo debería estar marcado como inválido");
    }

    @Then("debería ser redirigido a la página de registro")
    public void verificarAccesoPaginaRegistro() {
        Assert.assertTrue(registerPage.isRegisterPage(), "Deberíamos estar en la página de registro");
    }

    @And("el botón continuar no debe estar habilitado")
    public void verificarBotonContinuarDeshabilitado() {
        Assert.assertFalse(landingPage.isEnterButtonEnabled(),
                "El botón continuar debería estar deshabilitado");
    }

}
