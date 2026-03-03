# 🛒 Localizadores: Flujo de Compra E2E (Online Shop)

En este documento se detallan los localizadores necesarios para completar un flujo de compra desde la selección del producto hasta la confirmación del pedido en [TestingYes - OnlineShop](http://www.testingyes.com/onlineshop/).

## 1. Selección del producto
| Acción                                                         | Estrategia de localización | Selector                      |
|----------------------------------------------------------------|----------------------------|-------------------------------|
| Seleccionar un producto                                        | `LinkText`                 | `Hummingbird printed sweater` |

## 2. Añadir el producto al carro
| Acción                                                         | Estrategia de localización | Selector             |
|----------------------------------------------------------------|----------------------------|----------------------|
| Esperar a que sea visible el título con el nombre del producto | `Tag`                      | `h1`                 |
| Añadir producto al carro                                       | `CSS`                      | `button.add-to-cart` |

## 3. Ir al proceso de pago
| Acción                                                                                              | Estrategia de localización | Selector              |
|-----------------------------------------------------------------------------------------------------|----------------------------|-----------------------|
| Esperar a que sea visible el título indicando que se ha añadido el producto al carrito de la compra | `CSS`                      | `h4.modal-title`      |
| Ir al checkout                                                                                      | `LinkText`                 | `Proceed to checkout` |


## 3. Ir al proceso de compra
| Acción                                                                                                   | Estrategia de localización | Selector              |
|----------------------------------------------------------------------------------------------------------|----------------------------|-----------------------|
| Esperar a que sea visible el título indicando que se ha añadido el producto al carrito de la compra      | `CSS`                      | `h4.modal-title`      |
| Ir al checkout                                                                                           | `LinkText`                 | `Proceed to checkout` |
| Esperar a que sea visible el título la pantilla donde se muestra los productos que tenemos en el carrito | `Tag`                      | `h1`                  |
| Ir al checkout                                                                                           | `LinkText`                 | `Proceed to checkout` |


## 4. Informar datos personales
| Acción                                                            | Estrategia de localización | Selector                             |
|-------------------------------------------------------------------|----------------------------|--------------------------------------|
| Seleccionar tipo de tratamiento                                   | `CSS`                      | `input[name='id_gender'][value='1']` |
| Nombre                                                            | `CSS`                      | `input[name='firstname']`            |
| Appellidos                                                        | `CSS`                      | `input[name='lastname']`             |
| Email                                                             | `CSS`                      | `input[name='email']`                |
| Contraseña                                                        | `CSS`                      | `input[name='password']`             |
| Fecha de nacimiento                                               | `CSS`                      | `input[name='birthday']`             |
| Check para recibir ofertas de los socios comerciales              | `CSS`                      | `input[name='optin']`                |
| Check para suscribirse a la newsletter                            | `CSS`                      | `input[name='newsletter']`           |
| Aceptar los términos y condiciones de la política de privacidad   | `CSS`                      | `input[name='psgdpr']`               |
| Pulsar el botón continuar para continuar con el proceso de compra | `CSS`                      | `button[name='continue']`            |

## 5. Informar datos de la dirección
| Acción                                                            | Estrategia de localización | Selector                           |
|-------------------------------------------------------------------|----------------------------|------------------------------------|
| Dirección                                                         | `CSS`                      | `input[name='address1']`           |
| Ciudad                                                            | `CSS`                      | `input[name='city']`               |
| Estado                                                            | `CSS`                      | `select[name='id_state']`          |
| Zip/Código postal                                                 | `CSS`                      | `input[name='postcode']`           |
| País                                                              | `CSS`                      | `input[name='id_country']`         |
| Teléfono                                                          | `CSS`                      | `input[name='phone']`              |
| Pulsar el botón continuar para continuar con el proceso de compra | `CSS`                      | `button[name='confirm-addresses']` |

## 6. Informar datos de envió
| Acción                                                            | Estrategia de localización | Selector                               |
|-------------------------------------------------------------------|----------------------------|----------------------------------------|
| Dirección                                                         | `CSS`                      | `textarea[name='delivery_message']`    |
| Pulsar el botón continuar para continuar con el proceso de compra | `CSS`                      | `button[name='confirmDeliveryOption']` |

## 7. Pago
| Acción                                                                       | Estrategia de localización | Selector                                                       |
|------------------------------------------------------------------------------|----------------------------|----------------------------------------------------------------|
| Seleccionar método de pago por cheque                                        | `ID`                       | `payment-option-1`                                             |
| Aceptar los términos del servicio                                            | `ID`                       | `conditions_to_approve[terms-and-conditions]`                  |
| Realizar pedido con obligación de pago                                       | `XPath`                    | `//div[@id='payment-confirmation']//button`                    |
| Esperar a que sea visible el título indicando que el pedido se ha confirmado | `XPath`                    | `//h3[contains(normalize-space(), 'Your order is confirmed')]` |

