# FitBook :bicyclist: :mountain_bicyclist:

Repositorio del proyecto FitBook, que busca gestionar las clases de los gimnasios de Crossfit teniendo encuenta la pandemia que estamos viviendo

## Mockups

[Mockups] (https://app.moqups.com/lH5QmmXTxY/view)

## Diagrama de Clases

## Casos de Uso

![Administrador de Box](./img/casosdeusouno.png)

![Usuario Comun](./img/casosdeusodos.png)

## Correr proyecto

Primero Clonaremos el repositorio, para eso desde nuestro navegador nos dirigiremos al siguiente link

```sh
https://github.com/FitBook-ARSW/FitBook.git
```

Para clonar el repositorio debemos de correr el siguiente comando en cmd o en la terminal 

```sh
git clone https://github.com/FitBook-ARSW/FitBook.git
 ```

 Y luego entraremos a la carperta Consumer_Server

```sh
$ cd Fitbook
 ```
Descargaremos y compilaremos el proyecto con el siguiente comando
Este comando nos descargara la dependencias necesarias, como lo son JUnit y Spark

 ```sh
$ mvn package
 ```
 Y finalmente para ejecutar la aplicación.

 ```sh
$ mvn spring-boot:run
 ```

### Prerequisitos

* Tener conocimientos básicos en la terminal o CMD
* Java SE Development Kit 8 -Java SE Runtime Environment 8 -Apache Maven.


## Despliegue en Heroku

[![Deployed to Heroku](https://www.herokucdn.com/deploy/button.png)](https://secure-lake-15708.herokuapp.com/)

## Integración Continua

[![CircleCI](https://circleci.com/gh/FitBookApp/Back_FitBook.svg?style=svg)](https://app.circleci.com/pipelines/github/FitBookApp/Back_FitBook)

## Correr Pruebas

Para correr las pruebas, ejecutamos el siguiente comando

```sh
$ mvn test
 ```

## Construido con

* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://mvnrepository.com/artifact/junit/junit) - Test framework
* [VIM](https://www.vim.org/download.php) - Editor de Texto VIM

## Authors

 - Santiago Martínez Martínez 
    - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito 
    - Noveno Semestre

 - Javier Esteban Lopez
    - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito 
    - Noveno Semestre

 - Nikolas Bernal Giraldo
    - Estudiante de la Escuela Colombiana De Ingeniería Julio Garavito 
    - Noveno Semestre

## License

Este proyecto está licenciado bajo la GNU v3.0 - ver el archivo LICENSE.md para más detalles
 