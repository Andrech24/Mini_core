# Mini Core Envios - Spring Boot y Angular

Aplicacion sencilla para calcular el costo total de envios por repartidor dentro de un rango de fechas.

El backend esta hecho con Spring Boot y expone un endpoint REST. El frontend esta hecho con Angular y muestra un formulario con Fecha Inicio y Fecha Fin.

## Tecnologias

- Backend: Spring Boot
- Frontend: Angular
- Lenguaje backend: Java 17
- Datos: datos semilla en memoria

## Estructura

```text
minicore-envios-backend/
  src/main/java/com/udla/minicoreenvios/
    controller/EnvioController.java
    service/EnvioService.java
    model/Repartidor.java
    model/Envio.java
    model/Zona.java
    dto/ResultadoEnvio.java

minicore-envios-frontend/
  src/app/app.component.ts
  src/app/app.component.html
  src/app/app.component.css
```

## Como ejecutar

### 1. Backend

```bash
cd minicore-envios-backend
./mvnw spring-boot:run
```

En Windows:

```powershell
cd minicore-envios-backend
.\mvnw.cmd spring-boot:run
```

El backend queda en:

```text
http://localhost:8080
```

Endpoint usado por Angular:

```text
http://localhost:8080/api/envios/costos?fechaInicio=2025-05-01&fechaFin=2025-05-31
```

### 2. Frontend

```bash
cd minicore-envios-frontend
npm install
npm start
```

La pantalla queda en:

```text
http://localhost:4200
```

## Logica del calculo

1. El usuario ingresa Fecha Inicio y Fecha Fin.
2. Angular envia las fechas al backend.
3. Spring Boot filtra los envios cuya fecha esta dentro del rango.
4. Por cada envio calcula: pesoKg * tarifaPorKg.
5. Se agrupa por repartidor y zona.
6. Angular muestra repartidor, cantidad de envios, kg, zona, tarifa y costo total.

## Links para entrega

Repositorio GitHub: https://github.com/Andrech24/Mini_core

Video explicativo: https://www.youtube.com/watch?v=F05Xc3aq_Mc

Proyecto deployado: https://minicore-envios-frontend-udla.onrender.com/

## Documentacion oficial

- Spring Boot: https://spring.io/projects/spring-boot
- Angular: https://angular.dev/
## Videos de referencia

- Spring Boot REST API: https://www.youtube.com/results?search_query=spring+boot+rest+api+tutorial
- Angular HTTP Client: https://www.youtube.com/results?search_query=angular+httpclient+tutorial


