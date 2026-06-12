# TPIntegradorFeria

Proyecto final de Metodología de Sistemas 2 — TUP San José

## Requisitos

- Java 17 o superior
- Apache Maven

## Cómo ejecutar el programa

```bash
cd feria-emprendedores-main/feria-emprendedores-main
mvn compile -q
java -cp target/classes com.feria.Main
```

## Cómo correr los tests

```bash
cd feria-emprendedores-main/feria-emprendedores-main
mvn test
```

Luego de ejecutar los tests se genera un reporte de cobertura en `target/site/jacoco/index.html`.

## Decisiones técnicas

Se utiliza **Maven** como gestor de dependencias y build. Los tests se escriben con **JUnit 5** y **Mockito** para mocking. Se aplica **JaCoCo** para medir cobertura. El diseño separa responsabilidades en paquetes (`modelos`, `servicios`, `utils`) y usa el patrón **Strategy** para los descuentos (`DescuentoPorCantidad`, `DescuentoPorMonto`). Las dependencias externas (ej. envío de emails) se modelan con interfaces para facilitar el testeo. El pipeline de **CI** se ejecuta con GitHub Actions en cada push a `main`.
