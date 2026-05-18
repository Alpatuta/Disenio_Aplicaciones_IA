# AGENTS.md

## Project Snapshot
This is a Spring Boot 3.5.6 app on Java 21. Build and test with `./mvnw test`; run locally with `./mvnw spring-boot:run`.

## Architecture Rules
- Keep business rules in `src/main/java/uy/edu/ort/agenda/dominio/`.
- Keep application services in `src/main/java/uy/edu/ort/agenda/servicios/` and assume in-memory state unless the codebase explicitly adds persistence.
- Keep REST presenters in `src/main/java/uy/edu/ort/agenda/presentadores/`.
- Keep transport helpers and command wrappers in `src/main/java/uy/edu/ort/agenda/utils/`.
- Keep HTML, CSS, and browser-side command handling in `src/main/resources/static/`.
- Do not edit generated output under `target/`.

## Backend and Frontend Contract
- Presenters return `uy.edu.ort.agenda.utils.Commands`, built from `Command(id, parametro)`.
- Frontend views register handlers in `src/main/resources/static/CommandDispatcher.js` and must use the same command ids emitted by the presenters.
- When changing a use case, update the presenter and the matching HTML/JS view together.
- Preserve the command names and payload shapes unless you are deliberately changing both sides of the contract.

## Change Guidelines
- Prefer small, focused edits that preserve the existing Spanish naming and package layout.
- Before adding new behavior, inspect the nearest presenter and the corresponding static view to keep the flow aligned.
- If a controller depends on session state, treat the session attribute as part of the use-case boundary.
- Avoid introducing a persistence layer unless the user explicitly asks for it.

## Useful Files
- `pom.xml`
- `src/main/resources/static/CommandDispatcher.js`
- `src/main/resources/static/login.html`
- `src/main/resources/static/menu.html`
- `src/main/resources/static/busqueda.html`
- `src/main/resources/static/gestionContactos.html`
