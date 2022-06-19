# tpeProg3
### Objetivo
Partiendo de una colección de libros, se desea implementar una herramienta que permita
simplificar la búsqueda de libros por géneros; además de caracterizar el comportamiento de
los usuarios mientras realizan dichas búsquedas.
Cada libro se compone de un título, un autor, una cantidad de páginas y un conjunto de
géneros, que describen el contenido del libro. Ejemplos de estos géneros son arte, ciencia,
policial, entre otras.

### Etapa 1 Buscador por genero
En esta primera etapa se desea implementar la lógica necesaria para obtener una colección
de libros que contenga un género en particular, ingresado por el usuario.
La herramienta comenzará llevando a memoria la colección completa de libros para luego
realizar un filtrado por un género dado, presentando al usuario la colección de libros
resultante.
Para optimizar el proceso de búsqueda, se requiere implementar un índice por género, el
cual simplificará el acceso a solo un subconjunto de todos los libros existentes.

- Entrada: El programa tomará un archivo .csv de entrada.
- Salida: El programa deberá generar un archivo .csv con los títulos de los libros que cumplen
con el género dado.
