# Escenarios de prueba para la página de registro

En este documento se presentan los casos de prueba diseñados e implementados para la página de registro con Java, Selenium WebDriver, Cucumber y Page Object Model (POM),

```gherkin
Feature: Página de registro

  Background: Precondiciones
    Given que estoy en la página de registro

    Scenario Outline: Validar habilitación del boton de registro
      When informo toda la información necesaria para el registro excepto el campo "<campo>" que lo dejo sin informar
      Then el botón de registro no debe estar habilitado

      Examples:
        | campo                             |
        | Nombre                            |
        | Apellidos                         |
        | Dirección                         |
        | Email                             |
        | Teléfono                          |
        | Genero                            |
        | Skills                            |
        | País                              |
        | Año                               |
        | Mes                               |
        | Día                               |
        | Contraseña                        |
        | Confirmación de contraseña        |

  Scenario Outline: Validar campos obligatorios
    When informo toda la información necesaria para el registro excepto el campo "<campo>" que lo dejo sin informar
    And hago clic en el botón de finalizar registro
    Then el campo "<campo>" del formulario de registro debe marcarse como inválido

    Examples:
      | campo                             |
      | nombre                            |
      | apellidos                         |
      | dirección                         |
      | email                             |
      | teléfono                          |
      | genero                            |
      | skills                            |
      | país                              |
      | año                               |
      | mes                               |
      | día                               |
      | contraseña                        |
      | confirmación de contraseña        |

  Scenario: Validar que el campo teléfono no acepta letras
    When informo toda la información necesaria para el registro excepto el campo "teléfono" que lo dejo sin informar
    And informo el campo teléfono con "abcdefghij"
    And hago clic en el botón de finalizar registro
    Then el campo "teléfono" del formulario de registro debe marcarse como inválido

  Scenario: Validar que las contraseñas deben coincidir
    When informo toda la información necesaria para el registro
    And informo el campo contraseña con "Password123"
    And informo el campo confirmación de contraseña con "Diferente456"
    And hago clic en el botón de finalizar registro
    Then el campo "confirmación de contraseña" del formulario de registro debe marcarse como inválido

  Scenario: Registro exitoso
    When informo toda la información necesaria para el registro
    And hago clic en el botón de finalizar registro
    Then debería ser redirigido a la página de bienvenida
```