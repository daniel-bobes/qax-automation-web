# Screenplay


## Escenario 1 - Registro exitoso

### 1. Actor (El prota)
* Nombre: Juan
* Habilidad: Usar un formulario web para registrarse como estudiante de automatización QA Pro Level

### 2. UI (Elementos del formulario)

| Nombre | Descricpión |
| --- | --- |
| CAMPO_FIRSTNAME | El campo de texto donde se escribe el nombre del estudiante.
|CAMPO_LASTNAME | El campo de texto donde se escriben los apellidos del estudiante.
|CAMPO_EMAIL | El campo de texto donde se escribe el email del estudiante.
|CAMPO_GENDER | El campo para elegir el género del estudiante.
|CAMPO_MOBILE | El campo de texto para introducir el móvil del estudiante.
|BOTON_SUBMIT | El botón para enviar el formulario de registro como estudiante.

### 3. Tasks (Tareas de alto nivel)
* CompletarFormularioYRegistrarEstudiante: se rellenan los campos del formulario y se envia el formulario, registrandose así un nuevo estudiante.

### 4. Interactions (Acciones atómicas)
Para completar la tarea anterior, el actor realiza los siguientes pasos:
1. Ingresar "Juan" en CAMPO_FIRSTNAME.
2. Ingresar "Sanchez" en CAMPO_LASTNAME.
3. Ingresar "test@email.com" en CAMPO_EMAIL.
4. Seleccionar "Male" en CAMPO_GENDER.
5. Ingresar "6664774666" en CAMPO_MOBILE.
6. Hacer clic en BOTON_SUBMIT.

### 5. Questions (Validaciones)
* ¿Aparece una ventana modal con el título "Thanks for submitting the form?
* ¿En la ventana modal se muestran los datos que se ingresaron en el formulario?
* Si navego a la lista de estudiantes, ¿aparece el estudiante que acabamos de registrar?
___
## Escenario 2 - Validar obligatoriedad del campo "First name"

### 1. Actor (El prota)
* Nombre: Juan
* Habilidad: Usar un formulario web para registrarse como estudiante de automatización QA Pro Level

### 2. UI (Elementos del formulario)

| Nombre | Descricpión |
| --- | --- |
| CAMPO_FIRSTNAME | El campo de texto donde se escribe el nombre del estudiante.
|CAMPO_LASTNAME | El campo de texto donde se escriben los apellidos del estudiante.
|CAMPO_EMAIL | El campo de texto donde se escribe el email del estudiante.
|CAMPO_GENDER | El campo para elegir el género del estudiante.
|CAMPO_MOBILE | El campo de texto para introducir el móvil del estudiante.
|BOTON_SUBMIT | El botón para enviar el formulario de registro como estudiante.

### 3. Tasks (Tareas de alto nivel)
* CompletarFormularioYRegistrarEstudiante: se rellenan los campos del formulario y se envia el formulario, registrandose así un nuevo estudiante.

### 4. Interactions (Acciones atómicas)
Para completar la tarea anterior, el actor realiza los siguientes pasos:
1. Ingresar "Sanchez" en CAMPO_LASTNAME.
2. Ingresar "test@email.com" en CAMPO_EMAIL.
3. Seleccionar "Male" en CAMPO_GENDER.
4. Ingresar "6664774666" en CAMPO_MOBILE.
5. Hacer clic en BOTON_SUBMIT.

### 5. Questions (Validaciones)
* ¿Se muestra un mensaje de error indicando que es obligatorio informar el campo "First name"?
* ¿El campo "First name" se marca con color borde de color rojo?
___
## Escenario 3 - Validar longitud mínima del campo "Mobile"

### 1. Actor (El prota)
* Nombre: Juan
* Habilidad: Usar un formulario web para registrarse como estudiante de automatización QA Pro Level

### 2. UI (Elementos del formulario)

| Nombre | Descricpión |
| --- | --- |
| CAMPO_FIRSTNAME | El campo de texto donde se escribe el nombre del estudiante.
|CAMPO_LASTNAME | El campo de texto donde se escriben los apellidos del estudiante.
|CAMPO_EMAIL | El campo de texto donde se escribe el email del estudiante.
|CAMPO_GENDER | El campo para elegir el género del estudiante.
|CAMPO_MOBILE | El campo de texto para introducir el móvil del estudiante.
|BOTON_SUBMIT | El botón para enviar el formulario de registro como estudiante.

### 3. Tasks (Tareas de alto nivel)
* CompletarFormularioYRegistrarEstudiante: se rellenan los campos del formulario y se envia el formulario, registrandose así un nuevo estudiante.

### 4. Interactions (Acciones atómicas)
Para completar la tarea anterior, el actor realiza los siguientes pasos:
1. Ingresar "Juan" en CAMPO_FIRSTNAME.
2. Ingresar "Sanchez" en CAMPO_LASTNAME.
3. Ingresar "test@email.com" en CAMPO_EMAIL.
4. Seleccionar "Male" en CAMPO_GENDER.
5. Ingresar "123456789" en CAMPO_MOBILE.
6. Hacer clic en BOTON_SUBMIT.

### 5. Questions (Validaciones)
* ¿Se muestra un mensaje de error indicando que el campo "Mobile" tiene que tener 10 dígitos"?
* ¿El campo "Mobile" se marca con un borde de color rojo?
---
## Escenario 4 - Validar formato del campo "Mobile"

### 1. Actor (El prota)
* Nombre: Juan
* Habilidad: Usar un formulario web para registrarse como estudiante de automatización QA Pro Level

### 2. UI (Elementos del formulario)

| Nombre | Descricpión |
| --- | --- |
| CAMPO_FIRSTNAME | El campo de texto donde se escribe el nombre del estudiante.
|CAMPO_LASTNAME | El campo de texto donde se escriben los apellidos del estudiante.
|CAMPO_EMAIL | El campo de texto donde se escribe el email del estudiante.
|CAMPO_GENDER | El campo para elegir el género del estudiante.
|CAMPO_MOBILE | El campo de texto para introducir el móvil del estudiante.
|BOTON_SUBMIT | El botón para enviar el formulario de registro como estudiante.

### 3. Tasks (Tareas de alto nivel)
* CompletarFormularioYRegistrarEstudiante: se rellenan los campos del formulario y se envia el formulario, registrandose así un nuevo estudiante.

### 4. Interactions (Acciones atómicas)
Para completar la tarea anterior, el actor realiza los siguientes pasos:
1. Ingresar "Juan" en CAMPO_FIRSTNAME.
2. Ingresar "Sanchez" en CAMPO_LASTNAME.
3. Ingresar "test@email.com" en CAMPO_EMAIL.
4. Seleccionar "Male" en CAMPO_GENDER.
5. Ingresar "123456abc@" en CAMPO_MOBILE.
6. Hacer clic en BOTON_SUBMIT.

### 5. Questions (Validaciones)
* ¿Se muestra un mensaje de error indicando que el campo "Mobile" debe informarse solo con dígitos?
* ¿El campo "Mobile" se marca con un borde de color rojo?