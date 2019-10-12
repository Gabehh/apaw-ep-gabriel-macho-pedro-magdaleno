## [Máster en Ingeniería Web por la Universidad Politécnica de Madrid (miw-upm)](http://miw.etsisi.upm.es)
## Arquitectura y Patrones para Aplicaciones Web (APAW). API Rest
> Este proyecto es un apoyo docente de la asignatura. Se quiere mostrar un ejemplo completo de un API-Rest para comprender la arquitectura y su proceso evolutivo

### Estado del código
[![Build Status](https://travis-ci.org/Gabehh/apaw-ep-gabriel-macho-pedro-magdaleno.svg?branch=develop)](https://travis-ci.org/Gabehh/apaw-ep-gabriel-macho-pedro-magdaleno)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=es.upm.miw%3Aapaw-ep-gabriel-macho-pedro-magdaleno&metric=alert_status)](https://sonarcloud.io/dashboard?id=es.upm.miw%3Aapaw-ep-gabriel-macho-pedro-magdaleno)
[![BCH compliance](https://bettercodehub.com/edge/badge/Gabehh/apaw-ep-gabriel-macho-pedro-magdaleno?branch=develop)](https://bettercodehub.com/)
[![Heroku broken](https://apaw-ep-gabriel-pedro.herokuapp.com/system/version-badge)](https://apaw-ep-gabriel-pedro.herokuapp.com/swagger-ui.html)

### Tecnologías necesarias
* Java
* Maven
* GitHub
* Travis-ci
* Sonarcloud
* Better Code Hub
* Spring-Boot
* MongoDB
* Heroku
* OpenAPI

### Crear el proyecto
1. Descomprimir la plantilla en una carpeta **apaw-ep-_nombre-apellido_**
1. Cambiar la **id** del **artefacto** en el fichero **pom.xml**
1. Importar el proyecto mediante **IntelliJ IDEA**
   1. **Import Project**, y seleccionar la carpeta del proyecto.
   1. Marcar **Create Project from external model**, elegir **Maven**.
   1. **Next** … **Finish**.
1. **Travis-CI**. En el fichero **.travis.yml** cambiar la cuenta de correo
1. **Sonar**. En el fichero **.travis.yml**, cambiar en nombre de la organización de Sonarcloud 
y crear la variable de entorno **SONAR** en la cuenta de Travis-CI asociado al proyecto
1. **Heroku**. En el fichero **Procfile**, cambiar el nombre del *.jar para despliegue


