const fs = require('fs');
const path = require('path');

const apiUrl = process.env.API_URL || 'http://localhost:8080/api/envios/costos';
const filePath = path.join(__dirname, '..', 'src', 'environments', 'environment.ts');
const content = `export const environment = {\n  apiUrl: '${apiUrl}'\n};\n`;

fs.writeFileSync(filePath, content);
console.log(`API_URL configurado: ${apiUrl}`);
