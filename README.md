# Laboratorio 7 AREP - David E. Valencia.

## Como funciona:
En la carpeta de [keys](keys), se encuentran los certificados para poder hacer un acceso seguro con uso del protocolo https, con la caracteristican de que fueron autofirmados por lo que los navegadores dejan claro que son peligrosos y poco fiable.

A travez de spark uso los lambdas para que con la clase url reader hace la conexion a un localhost 5001 con el url requerido y con eso deberia de funcionar el psoible fallo que se encuentre es que el navegador pide que uno confirme que va a permitir la conexion sin certificados seguros, y dos que no encuentra el otro servidor eso se debe mucahs veces con que el segundo servidor no este ejecutado.

## Instalación

1. Clona el repositorio de GitHub:

   ```bash
   git clone https://github.com/DavidVal6/AREP-TALLER7.git
   cd my-spark-project

2. Inicialize el maven
   ```bash
   mvn clean install

## Ejecucion
Una vez se ha instalado es necesario ejecutar tanto [HelloSpark](src/main/java/edu/eci/arep/HelloSpark.java) como la clase [Spark2](src/main/java/edu/eci/arep/Spark2.java) primero la de hellospark y lueog la de hellowspark, una vez se haga esto se puede acceder al link requerido como 
```bash
https://localhost:5000/hello
https://localhost:5000/anotherHello
```
Con esto debera de aparecer las siguientes pantallas:

![image](https://github.com/DavidVal6/AREP-TALLER7/assets/98176834/9b356f08-e3d1-4f39-a45e-452365be3cad)
![image](https://github.com/DavidVal6/AREP-TALLER7/assets/98176834/015b588d-9c8c-41b4-8bdf-30fee860b9a7)


## Colaboradores

- Santiago Rocha


