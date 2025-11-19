# Java-algorithms

# Taller Evaluativo – Programación Orientada a Objetos

Este taller se divide en cuatro ejercicios. Cada ejercicio debe entregarse en una carpeta independiente (Ejercicio 1, Ejercicio 2, Ejercicio 3, Ejercicio 4).  
En cada carpeta se deben incluir únicamente los archivos `.java` correspondientes, sin comentarios en el código.

---

## 🟦 Ejercicio 1: Recorrido de un Dron

Un dron realiza 50 tramos durante su recorrido. Cada tramo contiene:

- Posición inicial: `xi`, `yi`, `zi`
- Posición final: `xf`, `yf`, `zf`
- Tiempo del tramo (segundos)

### Lo que debes hacer

1. Crear una clase **Tramo** con:
   - Constructor con todos los atributos.
   - Método que calcule la distancia recorrida (3D).
   - Método que calcule la velocidad (distancia / tiempo).
   - Método que determine si el tramo es válido:
     - Tiempo > 0
     - Distancia ≥ 0.5 m

2. En `main`, crear un arreglo de **50 objetos Tramo** y registrar los datos.

3. Mostrar:
   - Número de tramo
   - Distancia
   - Tiempo
   - Velocidad
   - Si es válido

4. Con solo los tramos válidos, calcular:
   - Distancia total
   - Tiempo total
   - Velocidad promedio
   - Tramo más rápido
   - Tramo más lento

5. Si no hay tramos válidos, mostrar mensaje de advertencia.

---

## 🟩 Ejercicio 2: Papalotes (Precios de Venta)

Se procesan 40 artículos, cada uno con:

- Clave del producto (1 a 6)
- Costo de la materia prima

### Lo que debes hacer

1. Crear clase **Articulo** con:
   - Constructor
   - Método para calcular mano de obra según la clave
   - Método para calcular gasto de fabricación según la clave
   - Método para calcular costo de producción
   - Método para calcular precio de venta

2. En `main`, crear un arreglo de **10 artículos** (según enunciado actualizado).

3. Mostrar: número, clave, costo MP, mano de obra, gasto fabricación, costo producción y precio de venta.

4. Calcular:
   - Promedio de precio de venta por clave
   - Artículo más caro y más económico
   - Total de materia prima
   - Total de precios de venta

5. Si no hay datos válidos, mostrar el mensaje correspondiente.

---

## 🟨 Ejercicio 3: Monitoreo de Atletas

Un grupo de **N atletas** registra una vuelta.

Para cada atleta se almacena:

- Nombre
- Distancia (m)
- Tiempo (s)

### Lo que debes hacer

1. Crear una clase **Atleta** con:
   - Constructor
   - Método que calcule la velocidad
   - Método que indique si el registro es válido (distancia > 0 y tiempo > 0)

2. En `main`, crear arreglo de N atletas.

3. Mostrar: número, nombre, distancia, tiempo, velocidad y validez.

4. Con solo válidos, calcular:
   - Velocidad promedio
   - Atleta más rápido y más lento
   - Distancia total válida

5. Si no hay registros válidos, mostrar mensaje.

---

## 🟥 Ejercicio 4: Consumo de Agua en Apartamentos

En un edificio hay **K apartamentos**. Se almacena:

- Número de apartamento
- Consumo en m³
- Costo por m³

### Lo que debes hacer

1. Crear clase **Apartamento** con:
   - Constructor
   - Método que calcule el valor a pagar (consumo × costo/m³)
   - Método que determine si el consumo es alto (> 25 m³)

2. En `main`, crear arreglo de K apartamentos.

3. Mostrar: número, consumo, costo/m³, valor a pagar y si el consumo es alto.

4. Calcular:
   - Consumo total
   - Valor total
   - Apartamento de mayor consumo
   - Apartamento de menor consumo

5. Si el consumo total es 0, mostrar mensaje correspondiente.

---