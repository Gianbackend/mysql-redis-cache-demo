<img width="1920" height="1040" alt="image" src="https://github.com/user-attachments/assets/d4d973b1-7592-434e-b8e4-01d34eee3dc6" /># MySQL Redis Cache Demo

## 📌 Descripción

Este proyecto implementa una solución básica de optimización de consultas utilizando Redis como sistema de cache en memoria sobre una base de datos relacional MySQL.

El objetivo es demostrar cómo reducir el tiempo de respuesta en consultas frecuentes evitando acceder constantemente a la base de datos.

---

## 🎯 Objetivo

Implementar un mecanismo de cache que permita mejorar el rendimiento de acceso a datos, comparando el tiempo de respuesta entre MySQL (base de datos) y Redis (cache en memoria).

---

## 🛠️ Tecnologías utilizadas

- Java
- MySQL (Docker)
- Redis (Docker)
- Maven
- JDBC
- Jedis (cliente Redis)

## 🧱 Arquitectura
Aplicación Java
↓
MySQL (persistencia)
↓
Redis (cache en memoria)

## 🔄 Flujo de funcionamiento

1. La aplicación se conecta a MySQL
2. Se ejecuta una consulta (conteo de ciudades)
3. Se obtiene el resultado desde la base de datos
4. El resultado se almacena en Redis
5. Se consulta el valor desde Redis
6. Se comparan los tiempos de respuesta

---

## ⚙️ Implementación

### 🔹 Consulta a MySQL

Se obtiene el total de ciudades mediante la consulta:

```sql
SELECT COUNT(*) FROM city;

🔹 Almacenamiento en Redis

El resultado se guarda como clave-valor:

Key: total_ciudades
Value: 4079

Comparación de rendimiento

Resultados obtenidos en la ejecución:

Total ciudades (MySQL): 4079
Valor desde Redis: 4079
Tiempo MySQL: 31 ms
Tiempo Redis: 1 ms

Análisis
MySQL realiza acceso a datos almacenados en disco, lo que introduce mayor latencia.
Redis trabaja en memoria RAM, permitiendo tiempos de respuesta significativamente menores.
Se evidencia una mejora en el rendimiento al utilizar Redis como cache

Conclusión

El uso de Redis como sistema de cache permite reducir significativamente el tiempo de acceso a datos frecuentes.

MySQL se mantiene como la fuente principal de datos (source of truth), mientras que Redis actúa como una capa de optimización para mejorar el rendimiento.

Repositorio

https://github.com/Gianbackend/mysql-redis-cache-demo

<img width="1429" height="1030" alt="image" src="https://github.com/user-attachments/assets/41528677-370a-4084-95f3-9e1672c31fb5" />

