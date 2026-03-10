package com.danielbobes.demoautomationtesting.steps;

import com.danielbobes.demoautomationtesting.config.DriverManager;
import com.danielbobes.demoautomationtesting.pages.LandingPage;
import com.danielbobes.demoautomationtesting.pages.RegisterPage;
import com.danielbobes.demoautomationtesting.pages.WelcomePage;
import com.danielbobes.demoautomationtesting.utils.DataFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class RegisterSteps {

    private LandingPage landingPage = new LandingPage(DriverManager.getDriver());
    private RegisterPage registerPage = new RegisterPage(DriverManager.getDriver());
    private WelcomePage welcomePage = new WelcomePage(DriverManager.getDriver());

    @Given("que estoy en la página de registro")
    public void queEstoyEnLaPaginaDeRegistro() {
        landingPage.typeEmail(DataFactory.getValidEmail());
        landingPage.clickOnEnterButton();
        Assert.assertTrue(registerPage.isRegisterPage(), "Deberíamos estar en la página de registro");
    }

    @When("informo toda la información necesaria para el registro excepto el campo {string} que lo dejo sin informar")
    public void queInformoTodosLosCamposExcepto(String campoExcluido) {
        informarInformacionPersonal(campoExcluido);
        informarInformacionAdicional(campoExcluido);
        informarFechaNacimiento(campoExcluido);
        informarClaves(campoExcluido);
    }

    @When("informo toda la información necesaria para el registro")
    public void informarInformacionNecesariaRegistro() {
        queInformoTodosLosCamposExcepto("Ninguno");
    }

    @And("hago clic en el botón de finalizar registro")
    public void finalizarRegistro() {
        registerPage.clickOnSubmit();
    }

    @And("informo el campo teléfono con {string}")
    public void informarTelefono(String telefono) {
        registerPage.fillPhone(telefono);
    }

    @And("informo el campo contraseña con {string}")
    public void informarClave(String clave) {
        registerPage.fillPassword(clave);
    }

    @And("informo el campo confirmación de contraseña con {string}")
    public void informarConfirmacionClave(String confirmacionClave) {
        registerPage.fillConfirmPassword(confirmacionClave);
    }

    @Then("el botón de registro no debe estar habilitado")
    public void verificarBotonRegistroDeshabilitado() {
        Assert.assertFalse(registerPage.isSubmitButtonEnabled(),
                "El botón de registro debería estar deshabilitado");
    }

    @Then("el campo {string} del formulario de registro debe marcarse como inválido")
    public void verificarCampoInvalidoEnFormularioRegistro(String campo) {
        Assert.assertTrue(registerPage.isFieldInvalid(campo),
                "El campo " + campo + " debería estar marcado como inválido");
    }

    @Then("debería ser redirigido a la página de bienvenida")
    public void verificarAccesoPaginaBienvenida() {
        Assert.assertTrue(welcomePage.isWelcomePage(), "Deberíamos estar en la página de bienvenida");
    }

    private void informarInformacionPersonal(String campoExcluido) {
        String firstName = "nombre".equalsIgnoreCase(campoExcluido)? null: DataFactory.getFirstName();
        String lastName = "apellidos".equalsIgnoreCase(campoExcluido)? null: DataFactory.getLastName();
        String address = "dirección".equalsIgnoreCase(campoExcluido)? null: DataFactory.getAddress();
        String email = "email".equalsIgnoreCase(campoExcluido)? null: DataFactory.getValidEmail();
        String phone = "teléfono".equalsIgnoreCase(campoExcluido)? null: DataFactory.getPhone();
        registerPage.fillPersonalInfo(firstName, lastName, address, email, phone);
    }

    private void informarInformacionAdicional(String campoExcluido) {
        String gender = "genero".equalsIgnoreCase(campoExcluido)? null: DataFactory.getGender();
        String hobby = "hobbies".equalsIgnoreCase(campoExcluido)? null: DataFactory.getHobby();
        String skill = "skills".equalsIgnoreCase(campoExcluido)? null: DataFactory.getSkill();
        String country = "pais".equalsIgnoreCase(campoExcluido)? null: DataFactory.getCountry();
        registerPage.fillAdditionalInfo(gender, hobby, skill, country);
    }

    private void informarFechaNacimiento(String campoExcluido) {
        String year = "año".equalsIgnoreCase(campoExcluido)? null: DataFactory.getYear();
        String month = "mes".equalsIgnoreCase(campoExcluido)? null: DataFactory.getMonth();
        String day = "día".equalsIgnoreCase(campoExcluido)? null: DataFactory.getDay();
        registerPage.selectBirthDate(year, month, day);
    }

    private void informarClaves(String campoExcluido) {
        String password = "contraseña".equalsIgnoreCase(campoExcluido)? null: DataFactory.getPassword();
        String confirmPassword = "confirmación de contraseña".equalsIgnoreCase(campoExcluido)? null: password;
        registerPage.fillSecurityInfo(password, confirmPassword);
    }

}
