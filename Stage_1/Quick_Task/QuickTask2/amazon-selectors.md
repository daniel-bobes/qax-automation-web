## Localización de elementos - Amazon

| # | Elemento Web | Tipo de elemento HTML | Selector por atributo |                  Selector CSS                  | Selector XPath | Selector más estable |
|:--:| --- |:---:|:---:|:----------------------------------------------:|:---:|---|
| 01 | Logotipo de Amazon| `<a>`| `id="nav-logo-sprites"` |                `#nav-logo-link`                | `//a[@id='nav-logo-sprites']` | ID: es el más estable debido a que es único, estático y rara vez cambia|
| 02 | Barra de búsqueda de productos| `<input>`| `id="twotabsearchtextbox"`|             `#twotabsearchtextbox`             | `//input[@id="twotabsearchtextbox"]` | ID: es el más estable debido a que es único y estático |
| 03 | Botón buscar (lupa) | `<input>`| `id="nav-search-submit-button"`|          `#nav-search-submit-button`           | `//input[@id="nav-search-submit-button"]` | ID: es el más estable debido a que es único y estático |
| 04 | Menú "Vender" | `<a>`| `data-csa-c-content-id="nav_cs_sell"`|    `[data-csa-c-content-id="nav_cs_sell"]`     | `//a[contains(text(),"Vender")]` | XPath: El texto del elemento es muy descriptivo por lo que el localizador XPath sería el más estable, los atributos parecen dinámicos por lo que podrian cambiar |
| 05 | Selector de categoria de búsqueda | `<select>`| `id="searchDropdownBox"`|              `#searchDropdownBox`              | `//select[@id="searchDropdownBox"]` | ID: es el más estable debido a que es único y estático |
| 06 | Menú "Todo" | `<a>`| `id="nav-hamburger-menu"`|             `#nav-hamburger-menu`              | `//a[@id="nav-hamburger-menu"]` | ID: es el más estable debido a que es único y estático |
| 07 | Menú "Ofertas del día" | `<a>`| `data-csa-c-slot-id="nav_cs_0"`|       `a[data-csa-c-slot-id="nav_cs_0"]`       | `//a[contains(text(),"Ofertas")]` | XPath: Al no tener atributos estáticos y ser un link de navegación con un texto descriptivo es el más estable  |
| 08 | Carrito de la compra | `<a>`| `id="nav-cart"`|                  `#nav-cart`                   | `//a[@id="nav-cart"]` | ID: es el más estable debido a que es único y estático |
| 09 | Enlace Identificación, cuentas y listas | `<a>`| `data-csa-c-slot-id="nav-link-accountList"`| `a[data-csa-c-slot-id="nav-link-accountList"]` | `//a[@data-csa-c-slot-id="nav-link-accountList"]` | ID: es el más estable debido a que es único y estático |
| 10 | Enlace para elegir ubicación de envío | `<a>`| `id="nav-global-location-popover-link"`|      `#nav-global-location-popover-link`       | `//a[@id="nav-global-location-popover-link"]` | ID: es el más estable debido a que es único y estático |
