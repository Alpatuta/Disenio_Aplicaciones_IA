---
name: facade-pattern
description: Generates or updates a Facade pattern implementation, hiding services/subsystems. The facade will delegate calls to the services, exposing the same public methods.
---

# Facade Pattern Generation/Update

This skill helps in generating or updating a Java class that implements the Facade design pattern.

## Workflow

1.  **Identify Subsystems/Services**: Identify the service classes that the Facade will delegate to. These are typically classes in the `modelo` package that are not the `Fachada` itself, for example `SistemaClientes`, `SistemaFacturas`, and `SistemaStock`.

2.  **Identify Facade Class**: Locate the existing `Fachada.java` class or create one if it doesn't exist. It should be a singleton.

3.  **Instantiate Subsystems**: Inside the Facade class, create private final instances of each subsystem.

    ```java
    public class Fachada {
        private final SistemaClientes sc = SistemaClientes.getInstancia();
        private final SistemaFacturas sf = SistemaFacturas.getInstancia();
        private final SistemaStock ss = SistemaStock.getInstancia();
        // ... singleton implementation
    }
    ```

4.  **Analyze and Delegate Public Methods**:
    a. For each subsystem/service class, get the list of all its `public` methods.
    b. For each of these public methods, create a corresponding public method in the `Fachada` class.
    c. The method in the `Fachada` should have the same signature (name, parameters, return type).
    d. The body of the facade method should simply delegate the call to the corresponding method on the subsystem instance.

    **Example:**
    If `SistemaClientes` has:

    ```java
    public boolean agregar(Cliente c) { ... }
    ```

    The `Fachada` should have:

    ```java
    public boolean agregarCliente(Cliente c) {
        return sc.agregar(c);
    }
    ```

    _(Note: Method renaming like `agregar` to `agregarCliente` can improve clarity, but direct delegation with the same name is also acceptable if it's not ambiguous)._

5.  **Review and Refine**: After generating the methods, review the `Fachada` class to ensure all public methods from the subsystems are correctly exposed and delegated. Ensure no subsystem logic is duplicated in the facade. The facade should only be a pass-through.
