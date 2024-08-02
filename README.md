# dev-test-sofka-transactions


**Desarrollado por [Cristian Loaiza](https://cloaiza1997.github.io/CristianLoaiza/).**

----

## Iniciar el proyecto

**Consideraciones previas**

* Tener una equipo con Java y Docker instalado. El servicio de Docker se debe de estar ejecutando.
* Antes de ejecutar los comandos de inicialización, indicar en el archivo [`src/main/docker/Dockerfile.jvm`](src/main/docker/Dockerfile.jvm) la IP de la máquina donde se ejecutará el proyecto, para que desde el del API pueda haber conexión con los servicios de MongoDB y RabbitMQ. Esto en caso de que se ejecute el API desde un contenedor de Docker, en caso de iniciar el API de forma local, no sería necesaria la inclusión de la IP ya que ese archivo solo es usado al momento de la compilación.

    ```
    ENV HOST_IP="192.168.80.15"
    ```

**Ejecución**

* Ejecutar el archivo [`init.sh`](init.sh) que se encuentra en la raíz del proyecto.
* El archivo `init.sh` tiene los comandos necesarios para ejecutar el archivo `docker/docker-compose.yml` que crea los contenedores para MongoDB y RabbitMQ. Además, de tener los comandos para compilar e iniciar un contenedor con el API de Quarkus.

**Servicios**

* API: [`http://localhost:8080`](http://localhost:8080)
* Documentación interactiva del API:
  * Swagger: [`http://localhost:8080/q/swagger-ui`](http://localhost:8080/q/swagger-ui)
  * OpenAPI: [`http://localhost:8080/q/openapi`](http://localhost:8080/q/openapi)
  * Se habilita la documentación interactiva del API con Swagger para propósitos de prueba.
  * Al interior de la documentación de Swagger se pueden probar los servicios del API, además tiene la explicación de los servicios generados.
* RabbitMQ Manager: [`http://localhost:15672`](http://localhost:15672)
  * Al crear la imagen se habilita una consola de administración. Esto es a modo informativo, no tiene influencia en el funcionamiento del API.
  * Usuario: `guest`
  * Contraseña: `guest`

---

## Reporte diario

El reporte diario se puede generar de 2 formas, ejecutando el servicio GET manualmente o configurando el scheduler para que se ejecute de forma automática.

* Para el caso del scheduler, se programa el cron dentro del archivo [src/main/java/org/cloaiza/core/scheduler/Scheduler.java](src/main/java/org/cloaiza/core/scheduler/Scheduler.java).
* La configuración de la frecuencia de ejecución está definida en la constante `SCHEDULER_CRON` que se encuentra en el archivo [src/main/java/org/cloaiza/core/constants/CoreConstants.java](src/main/java/org/cloaiza/core/constants/CoreConstants.java).
* La cofiguración está dada para que la tarea se ejecute diariamente a las 00:00 horas.
* Para efecto de las pruebas se puede modificar el valor de la frecuencia para ejecutar a una hora diferente y poder comprobar el funcionamiento. Si se hace esto se debe de volver a compilar el proyecto y subirlo de nuevo al contenedor de Docker.
