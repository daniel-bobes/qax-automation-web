Feature: Página principal

  Scenario: Intentar continuar a registro sin informar email
    Given que estoy en la página principal
    When no informo el email
    Then el campo email debe marcarse como inválido
    And el botón continuar no debe estar habilitado

  Scenario: Intentar continuar a registro informando un email inválido
    Given que estoy en la página principal
    When informo el email con un email no válido
    Then el campo email debe marcarse como inválido
    And el botón continuar no debe estar habilitado

  Scenario: Verificar estado inicial con email vacío
    Given que estoy en la página principal
    When no informo el email
    Then el botón continuar no debe estar habilitado

  Scenario: Acceder al formulario de registro con un email válido
    Given que estoy en la página principal
    When informo el email con un email válido
    And hago clic en el botón continuar
    Then debería ser redirigido a la página de registro