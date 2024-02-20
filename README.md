# Proyecto Módulo de Registro Bootcamp

_Este módulo hace parte del entrenamiento en el Bootcamp de Desarrollo Backend de Makaia. Su objetivo es permitir el registro y posterior envío de una prueba técnica a los aspirantes que deseen hacer parte del bootcamp._


### Pre-requisitos 📋

_herramientas necesarias para el correcto funcionamiento:_

```
Java Versión 17.
```

```
Maven.
```

```
MySQL.
```

## Ejecutando las pruebas ⚙️

_Para ejecutar pruebas se usan las siguientes herramientas_

* [Postman](https://www.postman.com) - Pruebas API
* [jUnit](https://junit.org/junit5/) - El framework para pruebas Unitarias

## Construido con 🛠️

Las siguientes herramientas fueron implementadas dentro de este módulo:

* [Java](https://www.java.com/es/) - Lenguaje de Programación :coffee:
* [Spring](https://spring.io/) - El framework web usado :leaves:
* [Maven](https://maven.apache.org/) - Manejador de dependencias 🪶
* [MySQL](https://www.mysql.com/) - Base de datos Relacional :dolphin:
* [Railway](https://railway.app/) - Herramienta de Despliegue :bullettrain_side:

Las principales dependencias utilizadas son : 👩‍💻

- Spring Data JPA (Persiste bases de datos SQL utilizando Java Persistence API mediante Spring Data y Hibernate)
- Spring Web 
- Spring Security (Autenticación con JWT)
- JUnit y Mockito (Testeo de pruebas unitarias)
- Swagger (Documentación de la API)


## Autores ✒️

* **Saray Perez** - *Pruebas Unitarias y Documentación* - [Saraypereez](https://github.com/Saraypereez)
* **Santiago Vargas** - *Seguridad y Documentación* - [SantiagoV25](https://github.com/SantiagoV25)
* **Mateo Espinosa** - *Lógica del Negocio* - [Mate4o25032006](https://github.com/Mate4o25032006)

## Diagrama de Procesos 📈

![Procesos](/Diagramas/Diagrama%20Procesos.png)

## Modelo Entidad/Relación 📈

![Modelo](/Diagramas/MER.png)


## :computer: Endpoints:

## Endpoint de creación de aspirantes :raising_hand:

### POST: /registroaspirantes

🙍 **Registrar** un nuevo aspirante en la base de datos con la información proporcionada en el cuerpo de la solicitud.

##### Parámetros de entrada:

- numero documento: Documento de identidad del aspirante (Cadena de Texto)
- tipo documento: Tipo de documento de identidad del aspirante (Cadena de Texto)
- nombre: nombre del aspirante (cadena de texto)
- genero: genero del aspirante (cadena de texto)
- edad: edad del aspirante (numero)
- fecha nacimiento: fecha de nacimiento del aspirante (Fecha - DATE)
- celular: número de celular del aspirante (cadena de texto)
- correo: dirección de correo electrónico (cadena de texto)
- nacionalidad: nacionalidad del aspirante (cadena de texto)
- bootcampInfo: información del bootcamp (cadena de texto)
- organizacion: organiación a través de la cual conoció el bootcamp (cadena de texto) (opcional)
- suma: operación requerida en el formulario (número)
- programa: OBJETO
- ubicacion: OBJETO
- datos Educativos: OBJETO
- datos contacto externo: OBJETO
- datos socioeconomia: OBJETO
- testtakerId: ID requerido para hacer seguimiento de la evaluación (número) (Primero se envía una invitación a la evaluación usando el correo del aspirante, y posteriormente el ID de dicha evaluación se almacena en este campo)

Ejemplo de solicitud:

```java 
{
    "numDocumento": "31209431",
    "tipoDocumento": "Cédula",
    "nombre": "Saray Perez",
    "genero": "F",
    "edad": 22,
    "fechaNacimiento": "2002-01-01",
    "celular": "3112678321",
    "correo": "saray123",
    "nacionalidad": "Colombiana",
    "bootcampInfo": "Internet",
    "organizacion": "Ninguna",
    "suma": 11,
    "programa": {
        "nombre": "Desarollo Backend"
    },
    "ubicacion": {
        "departamento": "Antioquia",
        "ciudad": "Turbo",
        "direccion": "Calle 23"
    },
    "datosEducativos": {
        "ultimoTitulo": "Universitario",
        "empleoActual": "Ingeniera",
        "nivelEducativo": "Universitario"
    },
    "datosContactoExterno": {
        "nombre": "Manuela Montes",
        "telefono": "3105422118",
        "correo": "manuMon@gmail.com"
    },
    "datosSocioeconomia": {
        "estrato": 2,
        "etnia": "No aplica",
        "discapacidad": "Ninguna",
        "poblacion": "No aplica",
        "Salario": 2300000,
        "ocupacion": "Ingeniera"
    },
    "testtakerId": 1541
}
```

La API devolverá el nuevo aspirante creado en formato JSON:
```json
{
    "numDocumento": "31209431",
    "tipoDocumento": "Cédula",
    "nombre": "Saray Perez",
    "genero": "F",
    "edad": 22,
    "fechaNacimiento": "2002-01-01",
    "celular": "3112678321",
    "correo": "saray123",
    "nacionalidad": "Colombiana",
    "bootcampInfo": "Internet",
    "organizacion": "Ninguna",
    "suma": 11,
    "programa": {
        "nombre": "Desarollo Backend"
    },
    "ubicacion": {
        "departamento": "Antioquia",
        "ciudad": "Turbo",
        "direccion": "Calle 23"
    },
    "datosEducativos": {
        "ultimoTitulo": "Universitario",
        "empleoActual": "Ingeniera",
        "nivelEducativo": "Universitario"
    },
    "datosContactoExterno": {
        "nombre": "Manuela Montes",
        "telefono": "3105422118",
        "correo": "manuMon@gmail.com"
    },
    "datosSocioeconomia": {
        "estrato": 2,
        "etnia": "No aplica",
        "discapacidad": "Ninguna",
        "poblacion": "No aplica",
        "Salario": 2300000,
        "ocupacion": "Ingeniera"
    },
    "testtakerId": 1541
}
```

### GET: /aspirantes

 👤 Este endpoint permite  obtener un listado completo de los aspirantes registrados en la Base de datos


Ejemplo de solicitud:

```https://backendproject-production-6d25.up.railway.app/api/v1/aspirantes```

La API devolverá el listado de aspirantes encontrado en formato JSON (En este caso nos muestra solo un registro):
```json
    {
        "numDocumento": "31209431",
        "tipoDocumento": "Cédula",
        "nombre": "Saray Perez",
        "genero": "F",
        "edad": 22,
        "fechaNacimiento": "2002-01-01",
        "celular": "3112678321",
        "correo": "saray123@gmail.com",
        "nacionalidad": "Colombiana",
        "bootcampInfo": "Internet",
        "organizacion": "Ninguna",
        "suma": 11,
        "programa": {
            "programaId": 24,
            "nombre": "Desarollo Backend"
        },
        "ubicacion": {
            "ubicacionId": 24,
            "departamento": "Antioquia",
            "ciudad": "Turbo",
            "direccion": "Calle 23"
        },
        "datosEducativos": {
            "educacionId": 24,
            "ultimoTitulo": "Universitario",
            "empleoActual": "Ingeniera",
            "nivelEducativo": "Universitario"
        },
        "datosContactoExterno": {
            "contactoId": 24,
            "nombre": "Manuela Montes",
            "telefono": "3105422118",
            "correo": "manuMon@gmail.com"
        },
        "datosSocioeconomia": {
            "socioeconomicoId": 24,
            "estrato": 2,
            "etnia": "No aplica",
            "discapacidad": "Ninguna",
            "poblacion": "No aplica",
            "salario": 0,
            "ocupacion": "Ingeniera"
        },
        "testtakerId": 1541
    }
```

### GET: /aspirantes/{documento}

 🕵 Este endpoint permite  **buscar** un aspirante por cédula, es una funcionalidad que permite a los usuarios obtener los datos de un cliente en particular utilizando su número de identificación.

##### Parámetros de entrada:

- documento: documento de identidad del aspirante (numero)

Ejemplo de solicitud:

```https://backendproject-production-6d25.up.railway.app/api/v1/aspirantes/31209431```

La API devolverá el aspirante encontrado en formato JSON:
```json
    {
        "numDocumento": "31209431",
        "tipoDocumento": "Cédula",
        "nombre": "Saray Perez",
        "genero": "F",
        "edad": 22,
        "fechaNacimiento": "2002-01-01",
        "celular": "3112678321",
        "correo": "saray123@gmail.com",
        "nacionalidad": "Colombiana",
        "bootcampInfo": "Internet",
        "organizacion": "Ninguna",
        "suma": 11,
        "programa": {
            "programaId": 24,
            "nombre": "Desarollo Backend"
        },
        "ubicacion": {
            "ubicacionId": 24,
            "departamento": "Antioquia",
            "ciudad": "Turbo",
            "direccion": "Calle 23"
        },
        "datosEducativos": {
            "educacionId": 24,
            "ultimoTitulo": "Universitario",
            "empleoActual": "Ingeniera",
            "nivelEducativo": "Universitario"
        },
        "datosContactoExterno": {
            "contactoId": 24,
            "nombre": "Manuela Montes",
            "telefono": "3105422118",
            "correo": "manuMon@gmail.com"
        },
        "datosSocioeconomia": {
            "socioeconomicoId": 24,
            "estrato": 2,
            "etnia": "No aplica",
            "discapacidad": "Ninguna",
            "poblacion": "No aplica",
            "salario": 0,
            "ocupacion": "Ingeniera"
        },
        "testtakerId": 1541
    }
```

### DELETE: /api/v1/clientes/{cedula}

❌ Este endpoint permite  **eliminar** un cliente es una funcionalidad que permite a los usuarios eliminar los datos de un cliente existente en la base de datos. Tenga en cuenta que solo se podrá eliminar si este cliente no tiene asociado un envio.

##### Parámetros de entrada:

- cedula: cedula del cliente (numero)

Ejemplo de solicitud:

```https://backendproject-production-6d25.up.railway.app/api/v1/aspirantes/31209431```

La API devolverá el mensaje:
```json
	"Aspirante Eliminado Correctamente"
```
