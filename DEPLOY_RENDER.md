# Deploy en Render

La forma mas facil es subir este proyecto a GitHub y crear 2 servicios en Render: uno para Spring Boot y otro para Angular.

## 1. Subir a GitHub

Desde la carpeta raiz del proyecto:

```powershell
git init
git add .
git commit -m "Mini core envios Spring Boot Angular"
git branch -M main
git remote add origin https://github.com/TU-USUARIO/minicore-envios-spring-angular.git
git push -u origin main
```

Si ya tienes repositorio, solo usa:

```powershell
git add .
git commit -m "Config deploy"
git push
```

## 2. Deploy backend Spring Boot en Render

En Render crear un servicio tipo Web Service.

Configuracion:

- Repository: tu repositorio de GitHub
- Root Directory: minicore-envios-backend
- Runtime: Java
- Build Command:

```bash
chmod +x mvnw && ./mvnw clean package -DskipTests
```

- Start Command:

```bash
java -jar target/minicore-envios-backend-0.0.1-SNAPSHOT.jar
```

Cuando termine, copia la URL del backend. Ejemplo:

```text
https://minicore-envios-backend.onrender.com
```

Prueba el endpoint en el navegador:

```text
https://TU-BACKEND.onrender.com/api/envios/costos?fechaInicio=2025-05-01&fechaFin=2025-05-31
```

## 3. Deploy frontend Angular en Render

En Render crear un servicio tipo Static Site.

Configuracion:

- Repository: el mismo repositorio
- Root Directory: minicore-envios-frontend
- Build Command:

```bash
npm install && npm run build
```

- Publish Directory:

```text
dist/minicore-envios-frontend
```

Si Render no encuentra archivos en esa ruta, usar:

```text
dist/minicore-envios-frontend
```

Variable de entorno:

```text
API_URL=https://TU-BACKEND.onrender.com/api/envios/costos
```

Ejemplo:

```text
API_URL=https://minicore-envios-backend.onrender.com/api/envios/costos
```

## 4. Probar

Abrir la URL del frontend y probar:

- Fecha Inicio: 2025-05-01
- Fecha Fin: 2025-05-31

Debe aparecer la tabla con Andres Molina y Camila Torres.

