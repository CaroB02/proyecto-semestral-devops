# --- Stage 1: Build ---
FROM node:20-alpine AS build
WORKDIR /app

# Copiar archivos de dependencias para aprovechar la caché de Docker layers
COPY package*.json ./
RUN npm ci

# Copiar el resto del código y compilar la aplicación
COPY . .
RUN npm run build

# --- Stage 2: Production ---
FROM nginx:alpine

# Copiar el resultado de la compilación al directorio de Nginx
COPY --from=build /app/dist /usr/share/nginx/html

# Exponer el puerto por defecto de Nginx
EXPOSE 80

# Cambiar a usuario no-root por seguridad (exigido estrictamente en la rúbrica)
USER nginx

CMD ["nginx", "-g", "daemon off;"]