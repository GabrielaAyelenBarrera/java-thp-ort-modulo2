# Módulo 2 – Refugio de Animales 🐾  
## Taller de Herramientas de Programación (THP) – ORT Argentina

Este repositorio contiene la resolución del **Segundo Parcial** de la materia **Taller de Herramientas de Programación**, desarrollada en **Java**, aplicando los conceptos de **programación orientada a objetos**, encapsulamiento, uso de enumerados, colecciones y corrección de errores según la consigna.

---

## 📄 Enunciado del ejercicio

El sistema del **Refugio de Animales “Huellitas”** permite administrar el registro de cuidadores y animales, y generar un informe de ocupación del refugio según el tipo de animal.

El objetivo del programa es **gestionar de forma equilibrada la asignación de animales a cuidadores** y **brindar información actualizada sobre la ocupación del refugio**, respetando las buenas prácticas vistas durante la cursada.

---

## 🧩 Clases que componen la solución

- **Refugio**: clase principal que coordina los registros y genera los informes.
- **Cuidador**: representa a la persona responsable de cuidar animales de un tipo determinado.
- **Animal**: modela a cada animal rescatado.
- **InfoTipoAnimal**: estructura auxiliar para los informes.
- **TipoAnimal (enum)**: define los tipos posibles de animales (PERRO, GATO, CONEJO, HAMSTER).

---

## 🛠️ Tareas realizadas sobre el proyecto base

La solución entregada incluía un código incompleto con errores de compilación y fallas de lógica.

### 🔧 Corrección de errores de compilación
- Se corrigieron los errores que impedían la ejecución del programa.

### 🐞 Corrección de bugs
- Se resolvió el `NullPointerException` al registrar el primer cuidador.
- Se corrigió el problema que provocaba que el programa se “congele” al buscar cuidadores.
- Se ajustó la lógica de asignación de animales para que se asignen al cuidador con **menor carga**.
- Se corrigió el informe por tipo de animal, que mostraba menos animales de los realmente registrados.

> Para la detección de errores se utilizó el **depurador** y la consola de **Eclipse**, analizando el flujo de ejecución del programa.

---

## ✨ Nuevas funcionalidades incorporadas

- **Número de chapita en la clase Animal**:
  - Se agregó el atributo `numeroChapita` como identificador único.
  - La asignación del número es automática y correlativa al registrar un nuevo animal.

- **Adopción de animales**:
  - Se incorporó el método `adoptar(int numeroChapita)` en la clase `Refugio`.
  - Permite buscar un animal por su número de chapita, removerlo del cuidador correspondiente y devolver el animal adoptado.
  - Se informa por pantalla si la adopción fue exitosa o si el número no corresponde a ningún animal.

- **Informe de ocupación por tipo de animal**:
  - Para cada tipo se calcula:
    - Cantidad total de animales.
    - Cantidad de cuidadores activos (con al menos un animal asignado).
  - Los datos se agrupan en objetos `InfoTipoAnimal` y se muestran por pantalla.

---

## 🧪 Pruebas realizadas

Se actualizaron las pruebas para validar las ampliaciones realizadas, contemplando:

- Creación y registro de animales con número de chapita único y correlativo.
- Adopción de animales con:
  - Número de chapita existente (caso exitoso).
  - Número de chapita inexistente (caso negativo con mensaje informativo).

---

## 💻 Implementación en Java

La solución fue implementada en Java respetando:

- Encapsulamiento y ocultamiento de información.
- Uso adecuado de clases, enumerados y colecciones.
- Correcta asignación de responsabilidades.
- Modularización del código mediante métodos reutilizables.
- Buenas prácticas de control de flujo enseñadas en la materia.

---

## 🧩 Diagrama de Clases

El siguiente diagrama de clases fue utilizado como base para el diseño y la implementación del sistema:
<img width="1190" height="788" alt="image" src="https://github.com/user-attachments/assets/47d1aa6e-98c6-4176-9a08-9d63ce782882" />


---

## 👩‍💻 Autora

**Gabriela Ayelén Barrera**  
Estudiante de Analista de Sistemas – ORT Argentina
