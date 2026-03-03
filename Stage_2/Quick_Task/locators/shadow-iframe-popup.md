# 🕵️ Localizadores: Shadow DOM, IFrames y PopUps

En este documento se detallan los localizadores y necesarios para interactuar con elementos dentro de un Shadow DOM, IFrame y PopUp.
* [Shadow DOM](https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html)
* [IFrame](https://bonigarcia.dev/selenium-webdriver-java/iframes.html)
* [PopUp](https://bonigarcia.dev/selenium-webdriver-java/dialog-boxes.html)

# 1. Interacción con elementos dentro de un Shadow DOM
| Elemento                       | Estrategia de localizacíón | Selector  |
|--------------------------------|----------------------------|-----------|
| Div que actua como ShadowHost  | `ID`                       | `content` |
| Parrafo dentro del shadow-root | `CSS`                      | `p`       |

# 2. Interacción con elementos dentro de un IFrame

## 2.1 Single frame
| Elemento                       | Estrategia de localizacíón | Selector      |
|--------------------------------|----------------------------|---------------|
| Iframe                         | `ID`                       | `singleframe` |
| Título dentro del frame        | `TagName`                  | `h5`          |
| Caja de texto dentro del frame | `TagName`                  | `input`       |

## 2.2 Frame inside frame
| Elemento                                | Estrategia de localizacíón | Selector                   |
|-----------------------------------------|----------------------------|----------------------------|
| Iframe exterior                         | `CSS`                      | `#Multiple iframe`         |
| Título dentro del frame exterior        | `TagName`                  | `h5`                       |
| Iframe interior                         | `CSS`                      | `.iframe-container iframe` |
| Título dentro del frame interior        | `TagName`                  | `h5`                       |
| Caja de texto dentro del frame interior | `TagName`                  | `input`                    |

# 3. Interacción con elementos dentro de un PopUp
| Elemento               | Estrategia de localizacíón | Selector     |
|------------------------|----------------------------|--------------|
| Botón "Launch alert"   | `ID`                       | `my-alert`   |
| Botón "Launch confirm" | `ID`                       | `my-confirm` |
| Botón "Launch prompt"  | `ID`                       | `my-prompt`  |
| Botón "Launch modal"   | `ID`                       | `my-modal`   |
