# Guia de pasos a seguir para el desarrollo de un proyecto Spring

## Inicializar un proyecto Spring con initialitzer

Ideal → iniciar el proyecto directamente con initializer
↳ Si ya hubiera trabajo hecho → iniciar con lo ya hecho
  ↳ Tendria que inyectar dependencias al proyecto a mano con gradle ⇒ puede generar pegas

1. ir a la pagina [Spring Initalizer](https://start.spring.io/)

Crear con Initializer
→ proyecto gradle + java
→ version spring boot → recomendada
⇒ group es.mde
→ nombre
⇒ packing ⇒ .jar
→ java version → 8
⇒ Añadir dependencias
↳ Se podría añadir con el build.gradle → Spring lo suple
Añadir
⇒ mejor que sobre que no falte
+ Spring Boot Dev Tools
+ Spring Web
+ Spring Hateoas
+ JDBC API
+ Spring JDBC API
+ Spring Data JPA
+ H2 Database
+ Postgre SQL Driver
Opcionales
+ Java mail sender

enlace resumen de lo generado en el inicializer:

https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.4.5.RELEASE&packaging=jar&jvmVersion=1.8&groupId=es.mde&artifactId=SpringBasics&name=SpringBasics&description=SpringBasics&packageName=es.mde.SpringBasics&dependencies=devtools,web,hateoas,jdbc,data-jpa,h2,postgresql,mail

## 1.  Iniciar Proyecto en Eclipse

* abrir eclipse
* En el workspace -> importar proyecto GRADLE
* Seleccionar la carpeta del proyecto
* next...finish
* ! debe tardar porque descarga todas las librerias
* Saldra una estructura de proyecto JAVA-Gradle

Para ejecutar -> **gradle Tasks -> aplication -> boot run**
- hay que acordarse de parar la ejecucion antes de volver a ejecutar

## 2. Añadir mas dependencias a Gradle

añadir a build gradle

```
plugins {
	id 'org.springframework.boot' version '2.4.5'
	id 'io.spring.dependency-management' version '1.0.11.RELEASE'
	id 'java'
	id 'java-library'     
	id 'eclipse'     
	id 'application'
}
```
```
repositories {
	mavenCentral()
	jcenter()
	maven { url 'https://jitpack.io' }
}
```
⇒ Comprobar el paquete main a iniciar
  ⇒ con la anotacion **@SpringBootApplication** en el **main** seria suficiente
```
application {
  mainClassName = ruta.paquete.mainMio
}
```
ejecutar: 
  - **refresh gradle proyect**
  - **boot run**

## 3. Creando la estructura de carpetas de mi proyecto

Tendre la siguiente estructura:
- mde.es.PaqueteBaseAplicacion
  - incluira el **MAIN**
  - mi clase.java de configuracion por java -> contendra los **@bean**
- **paquete.entidades** -> con las entidades propias para persistir con anotaciones **@Entity**
- **paquete.repositorios** -> contendra todo lo relativo a lo que quiera persisitir en mi BD
   - entidadesInterfazDAO
    - Con la anotacion **@RepositoryRestResource** extends **JpaRepository<class, ID>**
  - interfaces DAOCustom + clases DAOCustom implementadas a persistir (para customizar)
  - listeners

- **paquete.rest** -> con los archivos para la implementacion rest (exposicion al front)
  - Clases con anotacion **@RepositoryRestController + @RequestMapping(path = "/ruta/{id}/elemento/search")**
    - Tendran un elementoDAO con las **@GetMaping("/rutaURL/")** (rutas de los metodos a exponer) + **@ResponseBody**
- paquete.main.**resources** (generado por Spring) -> Contendra los archivos **.properties**
  +
  - paquete **config** con:
    - jpa-config.xml -> mi **entity-manager**
    - properties de jackson o de REST
  - paquete **jpa**
    - con todos los archivos.**orm.xml** para cada clase a persistir
   
## 4. Inyectando Beans 

Los Beans son objetos singleton que quiero utilizar, seran las clases que luego quiera persistir o mostrar por REST.

Voy a inyectar Beans a mano sin usar Spring,

-> comento las lineas de mi main 
- //@SpringBootAplication
- //SpringApplication.run(SpringBasicsApplication.class, args);

Añado el contenedor al main en el que voy a inyectar los Bean, pasandole el archivo de configuracion por xml

```
ApplicationContext context = //mi objeto contenedor
     new ClassPathXmlApplicationContext(
          new String[]{"configfile1.xml", //aqui pongo mis archivos de configuracion.xml
                       "configfile2.xml"}
          );
```
* tendre que importar las recomendaciones del eclipse que sean de Springframework
* puedo poner varios archivos de configuracion por XML pasandoselos al array separados por comas.
  * -> Deben estar en la carpeta main resources para que los encuentre. Seran de: 
    * de configuracion donde le paso los beans que debe hacer xml + desacoplado
    * de scaneo- para que busque las anotaciones @component... (necesito acceso al codigo)
* Tambien puedo crear **¡¡¡un solo archivo de configuracion.xml!!!** con toda la informacion que necesite.

Para recuperar un **BEAN**

- creo un objeto del tipo que quiero emplear

```
ObjetoTipo variableDeMiObjeto = new ObjetoTipo();
```
- a mi variable le asigno el bean de mi contenedor mediante el metodo .getBean
```
variableDeMiObjeto = context.getBean(ObjetoTipo.class)
```
* importante el **.class**

Recuperar un **BEAN** con **alias**

- El bean tendra un alias en su etiqueta ``@Bean("alias")``
```
variableDeMiObjeto = context.getBean("alias", ObjetoTipo.class)
```
Creo mis clases que voy a convertir en Bean
- **¡¡¡OBLIGATORIO!!!** Tienen que tener:
  - setters
  - getters
  - constructor() por defecto