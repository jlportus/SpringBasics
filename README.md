# SpringBasics

## GUIA PARA EL DESARROLLO DE UN PROYECTO JAVA-GRADLE-SPRING

### 0.INDICE

- [SpringBasics](#springbasics)
  - [GUIA PARA EL DESARROLLO DE UN PROYECTO JAVA-GRADLE-SPRING](#guia-para-el-desarrollo-de-un-proyecto-java-gradle-spring)
    - [0.INDICE](#0indice)
  - [Inicializar un proyecto Spring con initialitzer](#inicializar-un-proyecto-spring-con-initialitzer)
  - [1. Iniciar Proyecto en Eclipse](#1-iniciar-proyecto-en-eclipse)
  - [2. Añadir mas dependencias a Gradle](#2-añadir-mas-dependencias-a-gradle)
  - [3. Creando la estructura de carpetas de mi proyecto](#3-creando-la-estructura-de-carpetas-de-mi-proyecto)
  - [4. Inyectando Beans](#4-inyectando-beans)
    - [4.1 Beans por XML](#41-beans-por-xml)
    - [4.2 Beans por clase de configuracion Java](#42-beans-por-clase-de-configuracion-java)
    - [4.3 Beans por @Anotaciones](#43-beans-por-anotaciones)
    - [4.4 Prelacion de Beans](#44-prelacion-de-beans)
    - [4.5 Desambiguando Beans](#45-desambiguando-beans)
  - [5. Arrancando con SPRINGBoot](#5-arrancando-con-springboot)
    - [5.1 Añadiendo recursos externos a Spring Boot](#51-añadiendo-recursos-externos-a-spring-boot)
    - [5.2 Insertando valores externos en campos de Beans](#52-insertando-valores-externos-en-campos-de-beans)
  - [6. Logging](#6-logging)
    - [6.1 Configurando el Logging](#61-configurando-el-logging)
        - [Nivel de salida de mensajes](#nivel-de-salida-de-mensajes)
        - [Patron de salida de mensajes](#patron-de-salida-de-mensajes)
        - [Formato de Color de salida de mensajes](#formato-de-color-de-salida-de-mensajes)
        - [Salida de mensajes a fichero](#salida-de-mensajes-a-fichero)
  - [7. Autowired](#7-autowired)
    - [7.1 Conflictos entre bean inyectables(varios candidatos)](#71-conflictos-entre-bean-inyectablesvarios-candidatos)
      - [Conflictos entre constructores del Bean Creado:](#conflictos-entre-constructores-del-bean-creado)
      - [Conflictos entre Bean candidatos a inyectar:](#conflictos-entre-bean-candidatos-a-inyectar)
- [8. PERSISTENCIA DE DATOS](#8-persistencia-de-datos)
    - [8.1 El Entity manager](#81-el-entity-manager)
      - [Por Xml](#por-xml)
      - [Por anotaciones](#por-anotaciones)
    - [8.2 Los repositorios - interfazDAO](#82-los-repositorios---interfazdao)
    - [8.3 Las Entidades - Entity](#83-las-entidades---entity)
      - [8.3.1 Por anotaciones @Entity](#831-por-anotaciones-entity)
      - [8.3.2 Por ORM.XML](#832-por-ormxml)
    - [8.4. Emplear las entidades en el Main](#84-emplear-las-entidades-en-el-main)
    - [8.5 Persisitencia de clases con herencia](#85-persisitencia-de-clases-con-herencia)
    - [8.6 Single Table](#86-single-table)
    - [8.7 Persisitencia de clases con relación OneToMany](#87-persisitencia-de-clases-con-relación-onetomany)
  - [9. REST - Añadir la capa de presentación](#9-rest---añadir-la-capa-de-presentación)
    - [9.0 Prerequisitos para Spring](#90-prerequisitos-para-spring)
    - [9.1 Limitando el acceso a repositorios](#91-limitando-el-acceso-a-repositorios)
    - [9.2 Personalizar los objetos mostrados - Serializador Jackson y mixins](#92-personalizar-los-objetos-mostrados---serializador-jackson-y-mixins)
    - [9.3 Pasar a nivel 3 HATEOAS](#93-pasar-a-nivel-3-hateoas)
    - [9.4 Personalizar Endpoints](#94-personalizar-endpoints)
      - [9.4.1 Personalizar Querys](#941-personalizar-querys)
      - [9.4.2 Recibir parametros por la URL](#942-recibir-parametros-por-la-url)
      - [9.4.3 Añadir los Query personalizados:](#943-añadir-los-query-personalizados)
  - [10. Métodos Personalizados](#10-métodos-personalizados)
    - [10.1 Hacer Métodos Personalizados autodescubribles](#101-hacer-métodos-personalizados-autodescubribles)
    - [10.2 Evitar los filtros del CORS del navegador](#102-evitar-los-filtros-del-cors-del-navegador)
  - [11.Query Dinamicos](#11query-dinamicos)
  - [12.Listeners](#12listeners)
  - [13. Servicio Entidad](#13-servicio-entidad)
  - [14. Integrando Librerias](#14-integrando-librerias)
      - [14.1 Integrar Proyecto Local](#141-integrar-proyecto-local)
      - [14.2 Integrar Proyecto de GitHub](#142-integrar-proyecto-de-github)
      - [14.3 Integrar Proyecto de Repositorio en la nube](#143-integrar-proyecto-de-repositorio-en-la-nube)
      - [14.4 Precedencia y exportacion de dependencias](#144-precedencia-y-exportacion-de-dependencias)

## Inicializar un proyecto Spring con initialitzer

Ideal → iniciar el proyecto directamente con initializer

    ↳ Si ya hubiera trabajo hecho → iniciar con lo ya hecho

    ↳ Tendria que inyectar dependencias al proyecto a mano con gradle ⇒ puede generar pegas

Crear con Initializer → Ir a la pagina [Spring Initalizer](https://start.spring.io/)

    → proyecto gradle + java

    → version spring boot → recomendada

    ⇒ group es.mde → nombre

    ⇒ packing ⇒ .jar

    → java version → 8

    ⇒ Añadir dependencias

    ↳ Se podría añadir con el build.gradle → Spring lo suple

Añadir
⇒ mejor que sobre que no falte

- Spring Boot Dev Tools
- Spring Web
- Spring Web-services
- Spring Rest Repositories
- Spring Hateoas
- JDBC API
- Spring JDBC API
- Spring Data JPA
- H2 Database
- Postgre SQL Driver
  Opcionales
- Java mail sender

enlace resumen de lo [generado en el inicializer](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.4.5.RELEASE&packaging=jar&jvmVersion=1.8&groupId=es.mde&artifactId=SpringBasics&name=SpringBasics&description=SpringBasics&packageName=es.mde.SpringBasics&dependencies=devtools,web,hateoas,jdbc,data-jpa,h2,postgresql,mail,web-services,data-rest,data-jdbc)

[Volver a inicio](#springbasics)

## 1. Iniciar Proyecto en Eclipse

- abrir eclipse
- En el workspace -> importar proyecto GRADLE
- Seleccionar la carpeta del proyecto
- next...finish
- ! debe tardar porque descarga todas las librerias
- Saldra una estructura de proyecto JAVA-Gradle

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

Ejecutar:

- **`refresh gradle proyect`**
- **`boot run`** -> debe arrancar Spring sin errores

[Volver a inicio](#springbasics)

## 3. Creando la estructura de carpetas de mi proyecto

Tendre la siguiente estructura:

- mde.es.**PaqueteBaseAplicacion**
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
- **Resources** (generado por Spring) -> Contendra:
  - los archivos **.properties**
  - paquete **config** con:
    - jpa-config.xml -> mi **entity-manager**
    - properties de jackson o de REST
  - paquete **jpa**
    - con todos los archivos.**orm.xml** para cada clase a persistir

[Volver a inicio](#springbasics)

## 4. Inyectando Beans

Los Beans son objetos singleton que quiero utilizar, seran las clases que luego quiera persistir o mostrar por REST.

Voy a inyectar Beans a mano **sin usar Spring**,

> comento las lineas de mi main
>
> ```
> //@SpringBootAplication
> //SpringApplication.run(SpringBasicsApplication.class, args);
> ```

1. Añado el contenedor al main en el que voy a inyectar los Bean, pasandole el archivo de configuracion por xml

   ```
   ApplicationContext context = //mi objeto contenedor
       new ClassPathXmlApplicationContext(
             new String[]{"configfile1.xml", //aqui pongo mis archivos de configuracion.xml
                         "configfile2.xml"}
             );
   ```

- tendre que importar las recomendaciones del eclipse que sean de Springframework
- puedo poner varios archivos de configuracion por XML pasandoselos al array separados por comas.
  - -> Deben estar en la carpeta main resources para que los encuentre. Seran de:
    - de configuracion donde le paso los beans que debe hacer xml + desacoplado
    - de scaneo- para que busque las anotaciones @component... (necesito acceso al codigo)
- Tambien puedo crear **¡¡¡un solo archivo de configuracion.xml!!!** con toda la informacion que necesite.

Para recuperar un **BEAN**

1. creo un objeto del tipo que quiero emplear

   ```
   ObjetoTipo variableDeMiObjeto = new ObjetoTipo();
   ```

2. a mi variable le asigno el bean de mi contenedor mediante el metodo **`.getBean`**

   ```
   variableDeMiObjeto = context.getBean(ObjetoTipo.class)
   ```

   > importante el **.class**

Recuperar un **BEAN** con **alias**

- El bean tendra un alias en su etiqueta `@Bean(name="alias")`

  ```
  variableDeMiObjeto = context.getBean("alias", ObjetoTipo.class)
  ```

Creo mis clases que voy a convertir en Bean

- **¡¡¡OBLIGATORIO!!!** Tienen que tener:

  - setters
  - getters
  - constructor() por defecto

  ### 4.1 Beans por XML

Es el modo mas desacoplado de todos.

- Obligatorio cuando no tengo acceso al codigo (compilado)
- Me permite sobreescribir codigo ajeno

1. Creo el archivo de configuracion.xml en main/resources/config

   ```
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
                               http://www.springframework.org/schema/beans/spring-beans.xsd">

        <!-- bean definitions here -->
        <!--debo poner la ruta a la clase del Bean-->
        <!--Puedo poner un ID del Bean = Alias-->
        <!--Puedo poner un metodo que se inicie al crearse el Bean con init-method. No puede tener parametros-->

        <bean class="es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorXML" id="test" init-method="init">

          <!--pongo los campos de mi Bean (deben estar declarados en la clase y tener setter) y les puedo asignar valor inicial por defecto-->

          <property name="campoNombre" value="¡He sido inyectada por XML!"></property>
        </bean>
        <!--puedo poner mas beans-->

    </beans>
   ```

2. añado el archivo al contenedor (o lo importo en mi main si estoy usando SpringBoot)
   ```
    [...]ClassPathXmlApplicationContext(
             new String[]{"configfile1.xml", //aqui pongo mis archivos de configuracion.xml
                         "configfile2.xml"}
             );
   ```
3. Defino los Bean en el XML con

   ```
   <bean class="ruta.clase" id="alias">
       <property name="campoBean"></property>
   </bean>
   ```

### 4.2 Beans por clase de configuracion Java

Es el modo intermedio.

1. Creo una clase Java que la llamare claseConfiguracionPorJava (puede ser Otro nombre cualquiera) en la raiz del proyecto **al lado del Main**
1. Le añado la anotacion `@Configuration`
1. Creo dentro los metodos() que me van a devolver normalmente un objeto y les pongo la anotacion `@Bean`
   - Puedo usarlos para tunear mis beans o los objetos
   - Puede tener un alias `@Bean("alias")`
     - Da igual poner el `name=` si solo hay un elemento en el parentesis
   - Puedo ponerle un metodo inicial
     `@Bean(name="alias", initMethod="init")`
1. Necesito que la clase sea escaneada al crear el contenedor configurandolo con un xml

   - Tengo que añadir el XML al contenedor
   - ó
   - @Import({ ClaseConfiguracionJava.class })

   ### 4.3 Beans por @Anotaciones

Es el modo mas acoplado.

> **¡Necesito acceso al código!**

1. Pongo la anotacion `@Component` en la cabecera de la **clase** que sea un Bean
   - Tambien puedo usar las anotaciones que heredan de @component
     - `@Controller` -> para la presentacion
     - `@Service` -> Para crear servicios
     - `@Repository` -> Para Persistir
   - Pueden tener un alias `@Component("alias")`
1. Hago que spring escanee los elementos que tengan la anotacion **@Component** o herederas

   - Por defecto se escanean los que estan en la misma carpeta que el main y hacia abajo.

   - Si hago el escaneo por XML

     - Creo un archivo `config-scan.xml` en `resources` donde declaro que escanear
     - Añado el xml al contenedor `context`

### 4.4 Prelacion de Beans

Si tengo dos Beans iguales cargados de diferentes modos, uno me sobreescribira a otro o No sabre a que Bean me estoy refiriendo.

- Prelacion:

  - 1º Beans por XML
  - 2º Beans por clase de configuracion Java
  - 3º Beans por anotaciones

  ### 4.5 Desambiguando Beans

Necsesitare usar alias para referirme a un Bean concreto

- Alias en su anotacion `@Bean(name="alias")`
- Alias en Etiqueta.xml con atriduto **id** `<bean class="ruta.clase" id="alias">`

Para recuperar uso el **`.getBean`** sobrecargado.

```
variableDeMiObjeto = context.getBean("alias", ObjetoTipo.class)
```

[Volver a inicio](#springbasics)

## 5. Arrancando con SPRINGBoot

Una vez hecho el proyecto spring con initializer, me crea una serie de anotaciones por defecto

En el main

- **`@SpringBootApplication`**
  Equivale a:
  **`@Configuration + @EnableAutoConfiguration + @ComponentScan`**

  - Automaticamente escanea buscando `@anotaciones` en todos los archivos del paquete en el que se encuentra, **y en los que cuelguen de él** .
  - Lo que esta fuera **¡NO lo escanea!** salvo que se lo diga expresamente.
  - Tambien escaneara el `application.properties` por defecto de Spring

- **`SpringApplication.run(SpringBasicsApplication.class, args)`**

  - Sentencia que genera automaticamente el contenedor y en el que se almacenan los Beans que encuentre.
    - Puedo asignarlo a una variable para poder acceder con `.getBean()`
    ```
    ApplicationContext context = //mi variable tipo Contenedor
        SpringApplication.run(SpringBasicsApplication.class, args) //metodo que genera autom el contenedor con SpringBoot
    ```
    - Ya no necesitare mi antiguo contenedor al que le pasaba xml como parametros
    ```
    // new ClassPathXmlApplicationContext(
    		    new String[]{
    		    	//aqui pongo mis archivos de configuracion.xml
    		        }
    	);
    ```

[Volver a inicio](#springbasics)

### 5.1 Añadiendo recursos externos a Spring Boot

Como Spring Boot solo escanea lo que este en su mismo paquete, le debo decir donde puede buscar mas recursos que quiera inyectar.

- Insertando por **config.xml**
  1. en el `main` le digo que debe escanear el recurso (resource) de mi archivo XML.
  2. Agrego la anotacion
     `@ImportResource({"classpath:jpa-config.xml"})`
     - Puedo poner mas archivos separados por comas `,`
  3. Ahi tendré las configuraciones al estilo Bean (se ve mas adelante)
- **Importando clases** de configuracion por java externas

  - Añado al `main` la anotacion
    `@Import({ruta.ClaseConfiguracionJava.class})` con la ruta a la clase

  ### 5.2 Insertando valores externos en campos de Beans

  Voy a insertar con la anotacion `@Value` un String proveniente de un fichero `.properties` externo al codigo.

  1. Inserto el archivo properties nuevo al main:
     `@PropertySource({"valoresConstantes.properties"}) `
  2. Creo en la carpeta `resources` el archivo
     `valoresConstantes.properties`
  3. Introduzco en el los pares clave valor que quiero insertar despues en mi codigo
     `campoExterno=valor de campo Externo`
  4. En el Bean que quiero usar el campo externo, pongo la anotacion **con el placeHolder**
     `@Value("${campoExterno}")` antes del campo o del parametro del metodo Bean que voy a usar

     - Me sustiuira el valor de la variable por el almacenado en el archivo properties
     - En el metodo bean tiene que ir como un parametro

     ```
     public String probandoVariablesExternas(@Value("${campoExterno2}")String valor ) {
         return valor;
     }
     ```

     ```
     Nota:
     1. El application.properties se escanea por defecto.
        ¡El resto no! y hay que decirle a spring que los escanee.
     2. es recomendable separar los properties en funcion
        de la finalidad de lo que almacenen
     3. ¡NO poner contraseñas y subirlos a GitHUB!
         -> .gitignore
     4. las propiedades de logging se establcen por el
         applicationContext
     ```

[Volver a inicio](#springbasics)

## 6. Logging

Pretendo llevar un registro de sucesos que ocurren con la aplicacion.
Sustituire las salidas que normalmente lanzaba por consola para comprobar a otro lugar, ademas de mensajes de error, etc.

> fichero.log

- Tambien puedo lanzar una notificacion o mandar un correo ante un evento.

Podre hacer un log por cada singleton
En la clase que quiera emplear el **log**

1. Creo un objeto Logger estatico final
   `private final Logger log = LoggerFactory.getLogger(ClaseAHacerLog.class);`
   - Al importar tengo que importar el logger de **slf4j** - Me dará acceso a los metodos de log
2. Donde quiera que me elabore un mensaje de log (donde pondria un System.out.prntln), llamo a mi objeto **Log** y uso sus metodos:
   `log.info("Mi mensaje: {}", testString) `

   - Personalizo el mensaje de salida.
     > Uso String con placeHolders llamados por `{}`, insertados en orden de los `elementos.toString` separados por las comas
     > Tendré varios niveles de prioridad:
     >
     > - 1 ERROR - Errores
     > - 2 WARN - Alertas
     > - 3 INFO - Nivel Por defecto. Mostrara de info hacia arriba
     > - 4 DEBUG - Informacion importante para depuracion
     > - 5 TRACE - Capta todo

   ### 6.1 Configurando el Logging

Puedo configurar el logging a traves de un properties

Fuente: https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#common-application-properties

##### Nivel de salida de mensajes

```
 ##Me mostrara todo desde la raiz que sea mensaje warning o mas
logging.level.root=WARN

 ##Me mostrara todo desde el paquete indicado que sea mensaje debug o mayor gravedad
logging.level.es.mde.SprinBasics=DEBUG
```

##### Patron de salida de mensajes

```
##Me mostrara las fechas con ese formato
logging.pattern.dateformat=yyyy-MM-dd HH:mm

## creo una variable para el formato
mde.formatofecha=%date{ddMMM HH:mm:ss, UTC}Z

## aplico el formato con un placeHolder y mas propiedades
logging.pattern.console=${mde.formatofecha} [%thread %clr(${PID:- })] %-5level %logger{15} => %msg %n

```

##### Formato de Color de salida de mensajes

```
 ## aplico el formato con un placeHolder y mas propiedades
logging.pattern.console=${mde.formatofecha} [%thread %clr(${PID:- })] %highlight(%-5level) %cyan(%logger{15}) => %msg %n
```

Fuente http://logback.qos.ch/manual/layouts.html

##### Salida de mensajes a fichero

```
logging.file.name=archivo.log
```

[Volver a inicio](#springbasics)

## 7. Autowired

Cuando en un Bean necesito que se inyecte automaticamente otro Bean podré utilizar `@Autowired` en el Bean que vaya a ser inyectado

> La anotacion solo se debe utilizar en metodos que reciban parametros
> Normalmente si solo hay un Bean que sea del tipo necesitado en mi contenedor, no sera necesario.

En un `@Component` puedo Utilizar Autowired en tres sitios:

- En el **Constructor** -> Cuando el parametro del constructor sea un **campo obligatorio**-> automaticamente pasara al constructor al cargar el Bean inyectado (si no puede crear un null)
- En un **setter** -> Cuando el campo sea opcional
- En el **campo** directamente -> Desaconsejado.

  ```
  @Component
  class...{
    //...
  @Autowired
  public TestAutowired(Test testPorConstructor) {
      testInyectado = testPorConstructor;
  }
  ```

  > Buscara un bean de tipo Test y lo inyectara para su empleo.

### 7.1 Conflictos entre bean inyectables(varios candidatos)

Se puede dar el caso que tenga varios Bean del mismo tipo y Spring no sepa cual usar.

#### Conflictos entre constructores del Bean Creado:

Si tengo varios constructores de mi bean con sobrecarga, Spring no va a saver cual usar.

- `@Autowired` == `@Autowired(required=true)` cogera ese constructor por defecto
  - Solo puede haber un required true en mi Bean.
- `@Autowired(required=false)` de entre todos los constructores que tengan esta anotacion cogera el que tenga mayor coincidencia en el numero de parametros pasados.

#### Conflictos entre Bean candidatos a inyectar:

- Si quiero inyectar un Bean en concreto de los candidatos usaré la anotación **Qualifier** en el lugar donde se vaya a inyectar del Bean.

```
public void  setTestAutowired(@Qualifier("aliasDelBean") Test test) {//...}
```

> Inyectara el Bean con el alias indicado

**ó**

Si quiero que en todo el codigo se escoja un Bean por defecto cuando se tenga que inyectar, puedo usar **Primary** En la declaracion del Bean.

```
@Bean
@Primary
public Test miTest() {...}
```

> Solo puedo tener un Bean con primary en todos mis candidatos, si no tendre conflictos.

[Volver a inicio](#springbasics)

# 8. PERSISTENCIA DE DATOS

Se va a usar Java Persitance API **JPA** Con la implemnetacion **Hibernate**.

Voy a almacenar **clases.java** en un **SGBD Relacional** realizando un mapeo. **ORM** (Object-Relacional Mapping).

### 8.1 El Entity manager

Necesito un fichero de configuracion que me va a decir:

- Donde estan mis **repositorios-interfacesDAO** que van proporcionar los metodos CRUD a BD
- Donde estan las **clases-entidades** a persistir
- Archivos de "mappeo" personalizado de las entidades
- Datos de configuracion del SGBD que voy a emplear

La configuracion se puede hacer por xml o por anotaciones.

#### Por Xml

Pasos:

1. Copio el [archivo `jpa-config.xml`](https://gist.github.com/Awes0meM4n/5bef4d556f960a696823235d188d5387#file-jpa-config-xml) a mi carpeta resources de mi proyecto
1. Marco en el archivo los datos de configuracion
1. Añado al `aplication.properties` las variables de configuracion del Data-Source (H2.jar).
   - Driver a emplear
   - User
   - Pass
   - Url de la BD
     nota: los datos de arrancar deben coincidir con los que muestra la BD al iniciarla
     **+**
   - Dialecto de la Implementacion de Hibernate
1. Tengo que importar al Main el archivo de configuracion de jpa `@ImportResource({"classpath:config/jpa-config.xml"})`

#### Por anotaciones

No recomendado, mejor hacer por Xml, es mas desacoplado y obligatorio para cuando no tengo acceso al codigo. No obstante [ver documentacion de Spring Baeldung](https://www.baeldung.com/the-persistence-layer-with-spring-and-jpa#boot)

Para añadir los repositorios a escanear usar `@EnableJpaRepositories("ruta...")`
Para añadir las entidades a escanear usar
`@EntityScan("ruta...")`

> ### Arrancar la BD Local de H2
>
> Voy a la ruta de la libreria ⇒ H2.jar
> ↳ creo acceso directo a la libreria de la BD en la raiz de mi proyecto (o en el escritorio)
> ↳ doy permisos de ejecución ⇒ cmd → `chmod +x H2`
> ⇒ Necesito archivo `test.mv.db` copiado en el `user/home`
> (archivo de la carpeta BD H2)
> ↳ ejecuto la BD → `java -jar nombreArchivoH2`  
>  ↳ Me abre el navegador con el acceso a la BD
> ⇒ Seleccionar Generic H2 (Server)
> ⇒ connect - Si da pega cambiar a embebed y volver a Server - Puede dar pega el puerto
> ↳ añadir al properties `server.port = 8082` → Conflicto con Tomcat porque dice que esta ocupado

[Volver a inicio](#springbasics)

### 8.2 Los repositorios - interfazDAO

El repositorio va ser el encargado de hacer el CRUD con la BD.
Usare la interfaz [JpaRepository](https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/jpa/repository/JpaRepository.html) que me proporciona todos los metodos de acceso a BD:

- `.save(S entity)`
- `.delete(T entity)`
- `.getById(ID id)`
- `.deleteById(ID id)`
- ...otros

Recibe por un generico la clase java declarada como entidad (con `@Entity` o por `ORM.xml`), la interfaz será la que haga la traslacion entre las clases java y la BD en automatico.

Pasos:
En la carpeta Repositorios:

1. Creo una **interfaz** con el nombre**DAO**
   `NombreClaseAAlmacenarDAO`
1. Le hago que extienda de la interfaz de Spring
   `JpaRepository<T,ID>`, donde: - T => es el tipo de claseEntidad a persistir (debe estar creada antes, puede ser de una libreria. Debe estar **escaneada por Spring**) - ID => es el tipo de variable que va a tener el ID de la clase (Sera la PK-clave primaria) => Sera un **campo obligatorio**
1. Le pongo la anotacion a la interfaz:
   - `@Repository` si sólo se va a almacenar en BD.
   - `@RepositoryRestResource` **<-Recomendado**, si además se va a exponer al front **REST**
1. Debe estar escaneada por el entity-Manager <- jpa-config.xml

### 8.3 Las Entidades - Entity

Sera la clase java que quiero persistir. Tiene que tener:

- Constructor por defecto
- ID -> PK clave primaria que debe cumplir con ser Unica y obligatoria en todas las entidades del tipo.

Se pueden implementar por anotaciones o por xml

#### 8.3.1 Por anotaciones @Entity

1. En la cabecera tendra la anotacion `@Entity` de `javax.persistence`
   - Para personalizar el nombre de la tabla, puede tener la anotacion **@Table**
2. Tiene que tener un campo con la anotacion `@Id` **Obligatorio**
3. - Se puede determinar que el ID sea autogenerado con **Generated Value**
4. Tiene que ser escaneada por el entity-manager

   ```
   @Entity
   @Table(name="NombreTablaPersonalizado")`
   public class Clase {

       @Id
       @GeneratedValue
       int id;

       //setters/getters
       //+ Constructor por defecto
   }
   ```

Para **omitir campos** al almacenar en la BD se usa **TRANSIENT**

- Como anotacion antes del campo `@Transient`
- como modificador de la declaracion de la variable
  `private transient String campo;`
- Para ponerle un nombre personalizado a las colunas usar
  `@Column(name="Mi_Columna")`
- Para personalizar el dato en la BD de las colunas usar `@Column`
  ```
  @Column(length=200,
            scale=10, precision=2,
            unique=true,
            nullable=false)
  ```

#### 8.3.2 Por ORM.XML

**OBLIGATORIO** usar cuando no se tiene acceso al codigo (compilado o librerias externas)

1. En la carpeta `resources/jpa` se crea un archivo nombre:
   `ClaseAPerisitir.orm.xml`

1. En el archivo copiamos el contenido de:

```
<?xml version="1.0" encoding="UTF-8"?>
<entity-mappings xmlns="http://java.sun.com/xml/ns/persistence/orm"
                 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm
                                     http://java.sun.com/xml/ns/persistence/orm_1_0.xsd"
                 version="1.0">
    <!-- ruta completa de la clase a Persistir -->
                      <!-- access:"FIELD" = cuando se va a acceder directamente a los campos  -->
                      <!-- access"POPERTY"=cuando voy a acceder a los campos a traves de setter/getters  -->
  <entity class="es.lanyu.usuarios.repositorios.ClaseAPerisitir" access="FIELD">

      <!-- nombre de la tabla en la BD -->
    <table name="USUARIOS"/>

      <!-- Campos a persistir, apareceran asi en la BD-->
    <attributes>
      <id name="nombre">
        <!-- <generated-value strategy="IDENTITY"/> -->
        <column length="16"/>
      </id>
      <basic name="correo" optional="false" />
    </attributes>
  </entity>
</entity-mappings>
```

- los campos:
  - En la clase tiene que haber un campo ID **Obligatorio**
    - Si quiero que se cree de manera automatica el ID
      `<generated-value strategy="IDENTITY"/>`
  - El resto si no se pone nada se almacenan automaticamente
  - Si pongo alguno uso la etiqueta `<basic>`es para poder ponerle alguna restriccion de campo
    - como atributo xml:
      - `optional="false"` ->campo obligatorio (no puede ser opcional)
    - como sub-nodo xml
      - `<column` + `/>`
      - `length="16"` -> Longitud maxima
      - `unique="true"`
  - Para omitir campos en la BD uso
    `<transient name="campo"/>`
  - Para personalizar el nombre de la tabla
    `<table name="Mi_Tabla"/>`
  - Para personalizar el nombre de las columnas
    `<column name="Mi_Columna"/>`

> ¡NOTA! : Si la tabla esta creada y cambio las caracteristicas de ésta (campos opcionales, not null...) me dará error -> tengo que hacer `DROP TABLE` de la BD

3. Añado al `jpa-config.xml` la lista con los archivos orm de cada Clase -> debe ser la ruta completa.
   ```
   <property name="mappingResources">
      <list>
          <value>jpa/IdentificableString.orm.xml</value>
          <!-- Se pueden poner varias entidades en un mismo archivo -->
          <value>jpa/otraClase.orm.xml</value>
      </list>
   </property>
   ```
4. tendre que tener igualmente mi `interfazDAO` de la clase a persistir.

[Volver a inicio](#springbasics)

### 8.4. Emplear las entidades en el Main

Esto solo se hará en entorno de pruebas. En producción se captaria la entidad del Front u otro.

1. Crear variable del tipo interfazDao y asignarle el Bean del Contenedor de la InterfazDAO.
   `EntidadDAO variableEntidadDAO = context.getBean(EntidadDAO.class);`
1. mediante la variable de tipo interfaz uso los metodos de **JpaRepository** para hacer el **CRUD**.

   - Por ejemplo salvar:
     `variableEntidadDAO.save(new Entidad());`

   - Por ejemplo eliminar por ID:
     `variableEntidadDAO.deleteById(3);`

### 8.5 Persisitencia de clases con herencia

Se dara el caso que existan clases que hereden de otras y determinados campos no esten declarados en la clase hija (lo estarán en la clase padre), pero si sean del objeto.

Las clases padres se han de declarar como si fueran entidades normales, pero se utiliza la etiqueta `<mapped-superclass>` en lugar de `<entity>` (o la anotación **`@MappedSuperclass`** si tengo acceso al codigo)

> Hay que ir buscando las clases padres hasta encontrar las que tienen campos qeu sean heredados por las hijas

1. Crear el `ClasePadre.orm.xml` (El hijo debe estar tambien hecho como si fuera un POJO)

   ```
   <?xml version="1.0" encoding="UTF-8"?>
   <entity-mappings xmlns="http://java.sun.com/xml/ns/persistence/orm"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://java.sun.com/xml/ns/persistence/orm
                                       http://java.sun.com/xml/ns/persistence/orm_1_0.xsd"
                   version="1.0">

     <mapped-superclass class="es.ruta.ClasePadre"
                       access="FIELD">
       <attributes>
         <id name="id" />
       </attributes>
     </mapped-superclass>

   </entity-mappings>
   ```

2. Crear la **interfazDAO** de la clase que vaya a persistir (el Hijo)
3. Agregar el `ClasePadre.orm.xml` al **`Entity-Manager`**

> **El ORM de la clase hija ya no tendra su campo ID, sera heredado**
> El ORM de la clase padre no tendra nombre de tabla.

[Volver a inicio](#springbasics)

### 8.6 Single Table

Puede haber casos de especializacion de entidades que tengan una superclase en comun (Con campos comunes, ID-PK) y cada subclase tenga campos especificos diferentes.
Por rendimiento en las consultas puede ser adecuado almacenar ambas especializaciones en una misma Tabla **Single Table** asumiedo que:

- Necesitaré un campo discriminatorio **TipoSubclase**
- Tendre **null´s** en los campos que no sean comunes

> Prerrequisitos: Existira una `mapped-superclass` de la cual heredaran ambas subclases. Lo normal será que sea la superclase al que contenga el ID(PK) de la tabla (seria un campo heredado para ambas)

Habra un **`orm.xml`** para todas las subclases.
Dentro del `<entity-mappings>` le indico que va a ser una tabla Single y declaro todos los subtipos en el.

1. Dentro de la primera etiqueta `<entity>` de una subclase introduzco como cabecera el **SINGLE_TABLE** y el nombre de la columna discriminatoria:

   - **inheritance strategy="SINGLE_TABLE"** para indicar que es una Single Table (strategy se puede omitir por ser el valor por defecto)
   - **discriminator-column name="NombreColumna"** para indicar el nombre de la columna discriminatoria
   - **`+`** **discriminator value** para cada entidad con su valor correspondiente
   - ...el resto de atributos de la entidad

     ```
     <entity class="es.ruta.Clase" access="FIELD">
          <table name="NombretablaSingle"/>

          <inheritance strategy="SINGLE_TABLE"/>
          <discriminator-column name="TIPO"/>
          <discriminator-value>S</discriminator-value>

          <attributes>
              ...
          </attributes>
     </entity>

     <entity class="es.ruta.otraSubClase" access="FIELD">
     	...
     </entity>
     ```

2. Agrego las otras subentidades como en un orm normal, añadiendo:

   - la declaracion de la entidad con su ruta y sus atributos especificos
   - Una etiqueta que sea el **valor discriminatorio**

     ```
     <entity class="es.ruta.OtraClase" access="FIELD">

         <discriminator-value>T</discriminator-value>

         <attributes>
            ...
         </attributes>
     </entity>
     ```

     > A veces discriminator value Eclipse lo reconoce como error, pero funciona:)

Si lo quisiera hacer por **@anotaciones**, en la subentidades hay que añadir

1. En la entidad que genera la tabla:
   ```
   @Entity
   @Table(name="NombreTablaSINGLE")`
   @Access(value=AccessType.FIELD)
   @DiscriminatorValue("Subclase 1")
   public class ClaseTipo1 extends SuperClasePadre {...}
   ```
2. En el resto de subclases

   ```
   @Entity
   @Access(value=AccessType.FIELD)
   @DiscriminatorValue("Subclase 2")
   public class ClaseTipo2 extends SuperClasePadre {...}
   ```

3. Ambas deben igualmente heradar de la misma Superclase, ya que sera esta la que las vincule por el **Mapped-Superclass** y el **ID-PK**
4. Cada subclase debe tener su **itfzDAO** para poder persistir

[Volver a inicio](#springbasics)

### 8.7 Persisitencia de clases con relación OneToMany

Cuando tenga una entidad que contenga un campo que sea una lista(colección) de otros elementos usaré el **One to Many**.

Para que la BD mantenga la trazabilidad de los elementos de una tabla a la otra, se hace con la propagacion de la FK.

> Si fuese una relacion muchos a muchos, se podria hacer con una **@Join Table** con ambas PK de cada tabla, usando [**@ManyToMany**. Ver documentación.](https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany)

Para que la BD pueda hacer la relacion entre ambas Tablas, almacenara la PK de la tabla **@One** (se convertirá en FK) en un campo de cada elemento de la coleccion **@Many**.

Como prerrequisito: ambas clases deben ser **@Entity** (tener su ORM y su DAO)y tener ID.

> Lo que voy a guardar en el campo FK será otro objeto.
> JPA solo guarda primitivos u objetos si se estan empleando las relaciones @OneToMany.
> Si no quiero que falle al intentar guardar un tipo objeto que no conoce, antes de hacer las relaciones, debo poner el campo **coleccion como transient** para que lo evite.

1. Anotar el **OneToMany** en el **campo coleccion(listado)** que contiene la claseContenedora con:

   - **Por XML**. En el `orm.xml` de la clase que tiene la coleccion (añadir un atributo mas)

     - name: el nombre del campo de la clase contenedora
     - target-entity: ruta a la clase del elemento de la lista (no puede ser una interfaz)
     - mapped-by: campo Objetivo de la clase ElementoDeLaLista en el que se va a lamacenar al padre-> debe ser un objeto y deben llamarse igual
       > Si no pongo el maped by hace una join table

     ```
     <one-to-many name="campoColeccion"
                   target-entity="es.ruta.ClaseElementoDeLista"
                   mapped-by="padreContenedor"/>
     ```

   - **Por @OneToMany**. En la clase que tiene la coleccion, le pongo al campo Coleccion

     - mappedBy: campo Objetivo de la clase Elemento de la lista en el que se va a lamacenar al padre-> debe ser un objeto y deben llamarse igual

     ```
     @OneToMany(mappedBy="nombreCampoDestino")
     private Collection<Elementos> coleccion;
     ```

2. En la clase tipo ElementoDeLaLista **Creo un campo** del tipo ClaseContenedora que tiene la coleccion ("PadreContenedor") .
   -> Aqui sera donde se almacene la FK en los objetos Elementos de la lista
3. Añado el **ManyToOne** al elemento (un atributo mas)

   - **Por XML**. En el `orm.xml` de la clase Elemento de la coleccion

     - name: el nombre del campo tipo claseConColeccion
       - fetch="LAZY"-> (atributo Opcional, mejora rendimiento)hace que no se carque en memoria el objeto con coleccion cada vez que se carque un elemento de la lista
         `+` nodo interno xml
     - join-column name: FK -> valor a almacenar en la BD (no se puede llamar igual que otra columna de la tabla)
     - referencedColumnName: nombre de la columna en la BD que contendra la FK

     ```
     <many-to-one name="campoClaseConColeccion">
                               <!-- fetch="LAZY"> -->

           <join-column name="ID_PARTIDO"
                   referencedColumnName="IDPadre"/>

     </many-to-one>
     ```

   - **PorAnotacion @ManyToOne**. En la clase Elemento de la coleccion, le pongo al campo Contenedor

     ```
     @ManyToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="CampoIDDelContenedor")
     private ElementoContenedor padreContenedor;
     ```

4. Crear un metodo sincronizador en la clase con la coleccion

   -> Cada vez que se añada un elemento a la coleccion se tiene que **propagar el ID** (PK) de la clase que tiene la lista, al elemento de la lista (a su campo Padre Contenedor -> FK)

   ```
   public void addElemento(Elemento elemento) {
    this.coleccionElementos.add(elemento);
    elemento.setPadreoContenedor(this);
   }
   ```

   > Tengo que tener los getters/setters

   > Cuando vaya a añadir un elemento a la lista, tendre que utilizar mi metodo personalizado para que se propage la FK

   > La tabla de los elementos de la lista tendran una nueva columna que hara referencia al elemento que los contiene.

[Volver a inicio](#springbasics)

## 9. REST - Añadir la capa de presentación

**RE**presentational **S**tate **T**ransfer define una interfaz para el acceso a la aplicacion a raves de un protocolo **HTTP**

Mediante las operaciones de http se puede acceder a las operaciones de la BD de CRUD usando url´s.

- **HTTP - BD**
- POST - CREATE
- GET - READ
- PUT - UPDATE
- DELETE - DELETE

Si la API es de nivel 3 (**HATEOAS**), implica que las llamadas a la BD sean autodescubribles mediante enlaces URL

### 9.0 Prerequisitos para Spring

El proyecto Spring debe tener las dependencias de REST para el correcto funcionamiento.

Al arrancar la API en local, en el puerto que inicia TOMCAT [http://localhost:8080](http://localhost:8080) (si no se ha cambiado en el properties con `server.port=`), se podra acceder a todos los elementos del proyecto que sean `@Repository`

> Se puede acceder mediante **POSTMAN**
> Ya no será necesario crear elementos en el main, se harian desde POSTMAN (o el front)

### 9.1 Limitando el acceso a repositorios

Por defecto se muestra todo. Se debe limitar a solo lo que queramos.

1. En el Properties añadir:

   ```
   spring.data.rest.basePath=/api
   spring.data.rest.detection-strategy=annotated
   ```

   - La ruta de acceso pasara a ser `http://url`**`/api`** -> se usa para versionado de api y pruebas
   - Solo se mostraran las entidades que tengan la anotacion **RestResource**

2. Cambiar la anotaciones de las entidaes que se quieran mostrar
   de `@Repository` a `@RepositoryRestResource`
3. Perosnalizar las rutas URL para el acceso en las **intfazDAO**

   - por defecto Spring pone nombres a las rutas que no seran amigables -> personalizar con:

     ```
     @RepositoryRestResource(path="elemento"
           ,itemResourceRel="elemento"
           ,collectionResourceRel="elementos")
                             //,exported=false
     public interface intfzDAO extends JpaRepository<Elemento, Long> {
     }
     ```

     - path: sera la ruta URL personalizada por la que accedo al recurso
     - exported=false: hace que el recurso no se muestre aunque tenga la anotacion
       Las siguientes hacen referencia a como se llamara el recurso dentro del Json devuelto
     - itemResourceRel="elemento"
     - collectionResourceRel="elementos"

> **Muy Importante**: Necesitare serializar los objetos Elementos de una coleccion que se exponen con REST.
> Si no lo hago, al exponerlo, expondria tambien al objeto claseColeccion (Padre), que volveria a exponer a los Elementos de la Lista -> **Entra en Bucle recursivo**
> Hay que **ignorar el campo claseColeccion** (Padre) del elemento de la lista (el campo de la FK).

[Volver a inicio](#springbasics)

### 9.2 Personalizar los objetos mostrados - Serializador Jackson y mixins

Se necesita personalizar el objeto mostrado en las peticiones. habra campos:

- que no se quieran mostrar
- Que se les quiera cambiar el nombre
- Que se quieran mostrar en un orden determinado.

1. En la clase

   ```
   @Configuration
   public class claseConfiguracionPorJava{
       }
   ```

   se añade un Bean de tipo **ObjectMapper** a la que se le añaden los mixins.

   - Para añadir un mixin, se usa el metodo `.addMixin(Clase, Mixin)`
     -> cuando se crea un objeto del tipo Clase -> se personalizan sus campos con las anotaciones que haya en el Mixin.

   ```
     @Bean
     public ObjectMapper getObjectMapper() {
       ObjectMapper mapper = new ObjectMapper();
         mapper.addMixIn(Cliente.class, Mixins.Cliente.class);
       return mapper;
     }
   ```

2. Los **Mixins** sera una clase java que se guarde en el paquete `rest`
   -> esta clase contendra normalmente delcaraciones de intefaces (preferentemente) o clases abstractas con las anotaciones de **@Jackson** para serializar y personalizar los campos. Existen anotaciones de tipo:
   - Para la clase (se pasan en un objeto array):
     - de orden
     - de campos ignorados
     ```
     @JsonPropertyOrder({ "campo1", "campo3", "campo2" })
     @JsonIgnoreProperties(value = { "campo4", "campo5" })
     public static interface Cliente {
       //...campos y getters/setters
     }
     ```
   - Para los campos y getters de la clase - Para personalizar el nombre del campo -> Si no se conoce el tipo de dato del getter
     -> Se puede usar `Object` - para ignorar el campo (Tiene preferencia en las herencias) (Para formatos personalizados (sobre todo en fechas))
     ```
     @JsonProperty("nombreCampoPersonalizado")
     abstract String getNombre();
     @JsonIgnore Object objeto;
     @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") public Date eventDate;
     ```

> Hay configuraciones de serializacion que se pueden anotar en un properties, para que se realicen sobre todos los objetos

> La serializacion es bidireccional, se aplica en los GET (salida) y en los POST (entrada) desde el front, es decir al mandar objetos tienen que tener la misma estructura con los mismos nombres en los campos.

[Volver a inicio](#springbasics)

### 9.3 Pasar a nivel 3 HATEOAS

Hará que los enlaces sean autodescubribles, es decir, donde antes me ponia un objetoConColeccion en un campo de un elemento (me ponia un JSON), y tenia el problema de la recursividad en los objetos
-> me saldra un hipervinculo:

- un enlace al padre en el campo del objetoConColeccion del elemento
- y enlaces a cada uno de los elementos de la coleccion en campo lista del objetoConColeccion
  -> me permite navegar de un objeto a otro

> **ya no tendre que ignorar** el campo del elemento que me generaba la recusividad al elementoConColeccion (el campo de la FK)

Necesito acceder a los campo para hacer anotaciones (**solo se puede hacer con anotaciones**)

> Si no tengo acceso
>
> 1. hago una claseImpl hija que extienda a la que estoy haciendo la persistencia-REST. En la carpeta repositorios (al lado de su DAO).
> 2. Sobreescribo el metodo -> `@Overrride` ... getColeccion()

Pasos:

1. Pongo la anotacion `@OneToMany` y le pongo la **targetEntity** al elemento de la lista(tiene que ser un objeto implementado, no puede ser una interfaz)

   - El metodo devolvera el `super.get()`

     ```
     //@Overrride (si lo estuviese haciendo con la clase heredera)
     @OneToMany(targetEntity=Elemento.class)
     public Collection<Elementos> getColeccion(){
         return super.getColeccion();
     }
     ```

1. Pongo la anotacion `@ManyToOne` en el campo **FK** del Elemento que hace referencia al elementoConColeccion
   - No tiene que estar ignorado con el `ObjectMapper + mixin`
1. Creo el ORM (por anotaciones o xml) si no estubiera hecho ya. (si he hecho la clase heredera -> lo tendre que hacer)

[Volver a inicio](#springbasics)

### 9.4 Personalizar Endpoints

A traves del hiperenlace **Profile** de cada entidad puedo acceder a todos los metodos que se pueden realizar sobre esa entidad desde una llamada HTTP.

`url/api/profile/pathElemento`

Si voy a la IntfzDAO puedo hacer @Override de los metodos heredados de JpaRepository (ClickSecundario - source - Override)

Al sobreescribirlos puedo anotarlos Con **@RestResource** y personalizar:

- **`@RestResource(exported = false)`** -> para que no se muestren
- **`@RestResource(path="name")`** -> para añadir una ruta personalizada al metodo

#### 9.4.1 Personalizar Querys

JPA ofrece por defecto una serie de [metodos **"Query"**](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repository-query-keywords) que permiten realizar operaciones sobre la BD

Puedo hacer metodos personalizados utilizando la sintaxis del enlace en la firma del metodo para que me realice una consulta personalizada.

JPA -> trocea el String del nombre del metodo y lo transforma en una consulta SQL.

> las consultas solo funcionan sobre campos de existentes de las tablas -> Si se necesita hay que exponer con rest controler

Las Consultas generales son:

- findBy
- getBy
- deleteBy
  `+`

  - NombreDeLaColumnaDeLaTabla
    - `AND`, `OR`
      - OtraColumna
        `+` modificadores:
        - IgnoreCase
        - Containing
        - Between

  Quedando asi:

  ```
  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);

  //Equivaldria +/- a:
  SELECT person
  FROM tablaEntidadInterfazDao
  WHERE emailAdress="parametro1" AND lastName="Parametro2"

  ```

> los delete en principio solo funcionan por ID

#### 9.4.2 Recibir parametros por la URL

Se pasarán parametros por la URL, que se han de asignar al metodo personalizado con **@Param**

- Automaticamente coge el valor String de la URL y lo inserta como parametro al metodo donde este la anotacion.

```
ObjetoRetorno metodoFindBy(@Param("ParametroEnlaURL") String parametroLocal);
```

Los parametros por la URL se pasan con el simbolo `?`
`url/search/metodo?nombreParametroEnlaURL=valor&otroParametro=valor`:

#### 9.4.3 Añadir los Query personalizados:

1. Ir a la interfazDAO de la entidad y en el cuerpo de la interfaz añadir el metodo Query con los parametros necesarios
2. Ponerle la anotacion **@RestResource**
3. Añadir Path personalizado y parametros de la URL si hubiera
   ```
   @RestResource(path="personaemail")
   List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
   ```

> Puedo encontrar los metodos personalizados por la URL: en el `path`**`/entidadPath/search`** de cada recurso

[Volver a inicio](#springbasics)

## 10. Métodos Personalizados

Jpa esta limitado a la hora de hacer consultas a la BD, solo ofrece los querys con una pequeña personalizacion a traves de la sintaxis de la firma de los metodos.

En caso de querer hacer consultas mas elaboradas que requieran el **Join** de varias tablas, y que las consultas no esten relacionadas por FK, se ha de hacer un metodo personalizado (**Custom**).

Pasos:

1.  Hacer en `repositorios` una interfaz nombreClaseDAO**Custom**

    ↳ En dicha interfaz incluyo la declaracion de los metodos personalizados.

    ⇒ No tiene que tener ninguna anotacion (la IntzDAO original seguirá siendo la encargada del acceso al repositorio y ofrecer los metodos).

1.  Creo en el paquete `repositorios` una clase **`nombreClaseDAOImpl`**

    ↳ ¡Obligatorio! Tiene que tener al final **`Impl`** -> Permite que Spring la auto detecte para emplear el metodo personalizado implementado.

    > tiene que ser exactamente el mismo nombre que la intfzDAO + Impl

    ↳ La claseDAOImpl **implementara la interfazCustom** ⇒ Sera aqui donde se desarrollen los metodos
    ⇒ Tendra la Anotación encima de la clase **`@Transactional`** -> Permite que se compartan las consultas de la clase en el acceso a la BD

1.  Tendre que acceder a las tablas sencillas para luego poder hacer el Join personalizado. Se puede hacer de dos modos, por la interfazDAO o con Query "A mano".
1.  Para cada tabla "simple" necesitará:

    ↳ Tendra campos tipo:

    - **IntfzDAO** de la entidad sobre la que se quiera hacer la consulta -> Se aprovechara para poder acceder a los metodos query de JPA y poder personalizarlos despues con el resultado
      - Tiene que tener **@Autowired** para que se autoinicialize con el Bean de la IntfzDAO.
      - El metodo findBy..tiene que estar creado en la IntfzDAO
    - **EntityManager** permite crear query personalizados (como consultas clasicas de SQL) para luego tratarlas.
      - Tiene que tener la anotacion **@PersistenceContext** (es ~ un autowired para el EntityManager)
      - Permite hacer las **Query** - SQL a mano (de java Persistance)
        > No es obligatorio usar el entityManager, podrian ser dos IntfzDAO para cada tabla simple usando los queryMethods de JPA, o hacer ambas con entityManager.

    ↳ El join personalizado

    ```
    @Transactional(readOnly = true)
    class PartidoDAOImpl implements EventoDAOCustom<PartidoConId> {

        @Autowired
        ParticipanteDAO participanteDAO;

        @PersistenceContext
        EntityManager entityManager;

        @Override //Desarrolla el metodo de la IntfzCustom
        public List<PartidoConId> getEventosConParticipanteConTexto(String txt) {

            //Uso la EntidadDAO para acceder a un queryJPA
            List<Participante> participantes = participanteDAO.findByNombreIgnoreCaseContaining(txt);

            //creo la variable donde voy a almacenar el resultado
            Set<PartidoConId> partidos = new HashSet<PartidoConId>();

            //Creo un QuerySQL a traves del EntityManger
            Query query = entityManager.createNativeQuery(
                "SELECT p.* FROM partidos as p " +
                "WHERE p.local = ?1 OR p.visitante = ?1", PartidoConId.class);

            //al resultado del queryJPA le aplico mi QuerySQL (estoy haciendo un "join")
            //pasandole los parametros por ~ par clave valor (.setparameter)
            participantes.forEach(p -> {
                query.setParameter(1, p.getIdentificador());
                //los voy almacenando en la variable
                partidos.addAll(query.getResultList());
            });

            return new ArrayList<PartidoConId>(partidos);
        }

    }
    ```

1.  Añado a la **IntfzDAO** normal que implemente tambien la **IntzDAOCustom**
    - Spring buscará la implementacion a traves del **Impl** y el metodo personalizado se podra emplear para atacar la BD desde la IntfzDAO original.
    - El metodo no estará expuesto (link Hateoas) -> Necesito un controlador
1.  Añado el **Controlador**
    ↳ Creo en el paquete `rest` una clase **`EntidadController`**

    - Sera la responsable de exponer el metodo en la API
      → lo expongo con la anotacion **@RepositoryRestControler**
      → Le añado el path a la url con **@RequestMapping(path = /entidad/search)** para toda la clase

    ↳ Tendra un campo del tipo **EntidadDAO**, que se insertara por el constructor -> me permitira acceder al metodo personalizado

    ```
    @RepositoryRestController
    @RequestMapping(path = "/entidad/search")
    public class EntidadController {

      private EntidadDAO EntidadDAO;

      public EntidadController(EntidadDAO EntidadDAO) {
        this.clienteDAO = clienteDAO;
      }
      //Metodos personalizados
    }
    ```

1.  En la clase controlador creo un metodo (con el mismo nombre que mi **metodo personalizado**) que llame al metodo personalizado de la IntfzDao

    ⇒ Tendra las anotaciones en el metodo:

    - **`@GetMapping("/mimetodo")`** - define la ruta al metodo despues del `/search` + `/mimetodo`
      - puede ser Get, Post...
      - Es equivalenete a @RequestMapping(method=GET,path=..).
    - **`@ResponseBody`** -> Spring hace que lo que se devuelva se trate como una respuesta web

      ↳ Devuelve un objeto del tipo `CollectionModel<PersistentEntityResource>`

      ↳ recibe como parametro un objeto del tipo **assembler**

      ↳ Si recibe un parametro por la URL se anota en los parametros con **`@RequestParam`** equivale a **@Param**
      `PersistentEntityResourceAssembler assembler` - sera el encargado de conformar el objeto de salida para que la capte una llamada Http

      ````
      @GetMapping("/por-fecha")
      @ResponseBody
      public CollectionModel<PersistentEntityResource> getMimetodoPersonalizado(
      PersistentEntityResourceAssembler assembler) {

            //aqui llamo a mi emtodo personalizado Custom de la IntfzDAO
            List<Entidad> entidades = intfzDAO.getMimetodoPersonalizadoDelDAO();

            //el assembler.toColletionModel me construye la salida
            return assembler.toCollectionModel(entidades);
          }
          ```
      ````

[Volver a inicio](#springbasics)

### 10.1 Hacer Métodos Personalizados autodescubribles

Para que el link sea autodescubierto hay que añador un Bean (en la clase de configuracion por java por ejemplo)

Se se sobreescribe el objeto de Spring y que gestiona los hiperenlaces y se le añade el enlace a nuestro metodo personalizado.

```
@Bean
RepresentationModelProcessor<RepositorySearchesResource> searchLinks(RepositoryRestConfiguration config) {
    return new RepresentationModelProcessor<RepositorySearchesResource>() {

        @Override
        public RepositorySearchesResource process(RepositorySearchesResource searchResource) {

            //le indico la entidad donde tiene que insertar el enlace
            if (searchResource.getDomainType().equals(MiEntidad.class)) {

              //si el enlace coincide lo insertara con el siguiente bloque

                try {

                    //Le digo el nombre de mi metodo personalizado
                    String nombreMetodo = "getMiMetodoPersonalizado";

                    //busco en la entidad el metodo que coincide con el mio personalizado(impoorto de java reflex)
                    //(le tengo que decir tambien los parametros que recibe + Assembler)
                    Method method = PartidoController.class.getMethod(nombreMetodo, String.class,
                            PersistentEntityResourceAssembler.class);

                    //capto la URI de la entidad con linkTo
                    URI uri = org.springframework.hateoas.server.mvc.WebMvcLinkBuilder
                            .linkTo(method).toUri();

                    //me construyo la url al metodo
                    String url = new URI(uri.getScheme()
                                        , uri.getUserInfo()
                                        , uri.getHost()
                                        , uri.getPort()
                                        , config.getBasePath() + uri.getPath()
                                        , uri.getQuery()
                                        , uri.getFragment()).toString();
                          //el ?txt sera el parametro recibido
                    searchResource.add(new Link(url + "{?txt}", nombreMetodo));
                } catch (NoSuchMethodException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }

            return searchResource;
        }

    };
}
```

> NOTA: la interfazDAO de la entidad que tiene el metodo personalizado -> tiene que tener un QUerymetod de JPA con la anotacion @RestResources(path= "ruta") para que se autodescubra
>
> ```
> @RestResource(path = "nombre")
> List<Elemento> findByNombre(@Param("nombre") String nombre);
> ```

[Volver a inicio](#guia-para-el-desarrollo-de-un-proyecto-java---gradle---spring)

### 10.2 Evitar los filtros del CORS del navegador

Para que la API pueda ser atacada por un navegador se debe añadir el **CORS Filter** como otro Bean (al archivo de configuracion por java)

Copy&Paste:

```
@Bean
	CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
		source.registerCorsConfiguration("/**", config);

		return new CorsFilter(source);
	}
```

[Volver a inicio](#springbasics)
## 11.Query Dinamicos

Para realizar consultas usare los `@Param` pasando valores para hacer busquedas usando los metodos Query nativos de JPA. En determinados casos esto no valdra, puesto que puedo necesitar pasar un numero variable de parametros y que muchas veces estos sean null -> **Parametros Opcionales** -> **Consultas Dinamicas** ( Busqueda por filtros pe.) [Fuente](https://tech.asimio.net/2020/11/21/Implementing-dynamic-SQL-queries-using-Spring-Data-JPA-Specification-and-Criteria-API.html)

El proceso es similar a los metodos personalizados (Custosm)

Prerrequisitos:

Se van a utilizar unas librerias que simplifican las tareas.
Añadir al `build.gradle` 
- En **`plugins{}`**
  - `id "io.freefair.lombok" version "6.2.0"`
- En **`dependencies{}`**:
  - `implementation 'org.mapstruct:mapstruct:1.3.1.Final'` - permite usar los metodos de mapeo de queries a objetos 
  - `compileOnly 'org.projectlombok:lombok:1.18.16'` -> Libreria muy util, con **@anotaciones** genera `@Getter @Setter @Builder` (constructor dinamico con todos los campos posibles)


Pasos:
Partiendo de las Entidades persistidas con JPA y Spring (por anotaciones `@Entity` o por `orm.xml`)
1. **Crear el @StaticMetamodel**
   - De las clases que quiera hacer busquedas dinamicas creo una nueva clase `Entidad_` a la que le pongo la Anotacion `@StaticMetamodel(Entidad.class)` (El nombre se puede usar con la barra baja `_` por convenio)
   - En esa metaEntidad declaro los atributos que seran opcionales en mis busquedas con los modificadores ` public static volatile` del tipo:
     - `SingularAtributte<Entity, TipoCampo>` para campos unicos
     - `SetAttribute<Entity, ClaseColeccion>` para campos de listas o colecciones
    ```
    @StaticMetamodel(Film.class)
    public class Film_ {

      public static volatile SingularAttribute<Film, BigDecimal> rentalRate;
      public static volatile SingularAttribute<Film, String> releaseYear;
      public static volatile SetAttribute<Film, FilmCategory> filmCategories;
    }
    ```
  1. Añadir a extends la **interface**  `JpaSpecificationExecutor<Entity>` en la **interfazDAO** de la entidad origen
  1. En la **interfazDAO** creo un metodo query que llamare desde el controlador. tiene que recibir como parametros `@Nullable Specification<Entity>`. Puede tener la anotacion [`@EntityGraph`](https://tech.asimio.net/2020/11/06/Preventing-N-plus-1-select-problem-using-Spring-Data-JPA-EntityGraph.html)
      ```
      List<Entity> finAll(@Nullable Specification<Entity> especificaciones
      ``` 
  1. Creo una clase **`EntidadSearchCriteria`** 
     - Contendrá todos los criterios posibles de busqueda de la clase `Optional<>`
     - anotaciones de `lombok`
       - `@Getter @setter @Builder`
    ```
    @Getter
    @Setter
    @Builder
    public class ArtefactoSearchCriteria {

      private Optional<String> forma;
      private Optional<String> color;
      private Set<ClaseColeccion> listadoCosas;
    ```
  2. Usare la interfaz `Specification<T> extends Serializable`, ya integrada con Spring-JPA en las dependencias
  3. Creo una clase `EntidadSpecification` donde creo los metodos con los parametros que quiero que use la busqueda y los englobo en un metodo que me devuelva la busqueda personalizada. 
      - Usare las `StaticMetamodel` para acceder a los campos de comparacion 
   
  ```
  //En esta clase se aniaden los diferentes posibles criterios de busqueda

  public class ArtefactoSpecifications {

    private ArtefactoSpecifications() {
    }

    // Aniado los criterios posibles de busqueda a las especificaciones
    public static Specification<ArtefactoImpl> createArtefactoSpecifications(ArtefactoSearchCriteria searchCriteria) {
      return formaEqualTo(searchCriteria.getForma())
          .and(colorEqualTo(searchCriteria.getColor()))
          .and(fabricacionEqualTo(searchCriteria.getFabricacion()))
          .and(marcasFrioEqualTo(searchCriteria.getMarcasFrio()))
          .and(marcasPinturaEqualTo(searchCriteria.getMarcasPintura()))

      // Puedo aniador mas criterios con **and** u **or**
      
      ;
    }

    // declaro cada uno de los posibles criterios de busqueda que agrego al
    // createSpecifications
    public static Specification<ArtefactoImpl> formaEqualTo(Optional<String> forma) {
      return (root, query, builder) -> {
        return forma.map(form -> builder.equal(root.get(ArtefactoImpl_.forma), String.valueOf(form))).orElse(null);
      };
    }

    public static Specification<ArtefactoImpl> colorEqualTo(Optional<String> color) {
      return (root, query, builder) -> {
        return color.map(coloreado -> builder.equal(root.get(ArtefactoImpl_.color), String.valueOf(coloreado)))
            .orElse(null);
      };
    }
    
  }
  ```

   6. En la clase controlador de la clase **EntityController**  creo el metodo que que me proporcione las busquedas con parametros dinamicos. Debe tener:
      - Parametros Opcionales con **required=false** 
      - El `Assembler`
      - Un objeto SearchCriteria que construya los parametros de busqueda
      - Que llame a la interfazDAO al metodo custom pasandole los SearchoCriteria y almacene en un listado el resultado -> assembler.toCollectionModel
      ```
      @GetMapping(path = "filtrar")
      @ResponseBody
          public CollectionModel<PersistentEntityResource> buscarArtefacto(
              //meto los parametros opcionales -> luego los debo meter al builder y tienen que estar en Specifications
              @RequestParam(required = false) 
              Optional<String> forma, 
              @RequestParam(required = false) 
              Optional<String> color,			
              
              //El assembler para que construya la respuesta
              PersistentEntityResourceAssembler assembler

          ) {

            // hago un objeto que construye los criterios de busqueda opcionales.
            ArtefactoSearchCriteria searchCriteria = ArtefactoSearchCriteria.builder()
                // meto aqui los parametros de la clase SearchCriteria
                .forma(forma)
                .color(color)				  	
                  
                // Construyo
                .build();

            // Recupero los artefactos con los criterios seleccionados
            List<ArtefactoImpl> listadoArtefactos = artefactoDAO.getArtefactos(searchCriteria);
            listadoArtefactos = new ArrayList<Mina>

            return assembler.toCollectionModel(listadoArtefactos);
          }
      ```

[Volver a inicio](#springbasics)
## 12.Listeners

Las operaciones con la BD tienen un "Ciclo de Vida" con la operacioens que serealizan en el CRUD de datos:

- PostLoad
- PrePersist
- PostPersist
- PreUpdate
- PostUpdate
- PreRemove
- PostRemove
  > Se pueden poner en una entidad estas anotaciones (**@PostLoad**, ...) sobre alguno de sus metodos para que se inicien a lo largo de su ciclo de Vida

Un listener sera una llamada desde una clase(cuando se instancia) a otra clase para que se ejecute codigo de allí aprovechando las operaciones del ciclo de VIDA.

Pasos

1. Añado a la clase iniciadora la referencia a la clase que se inicia en cascada con **EntityListener**

   - Por anotaciones
     ```
     @EntityListeners(ClaseObjetivo.class)
     public class ClaseIniciadora { ... }
     ```
   - Por XML, en su ORM añado las clases listener

     ```
     <entity name="ClaseIniciadora" class="es.ruta.ClaseIniciadora" access="FIELD">
         <entity-listeners>
             <entity-listener class="es.ruta.ListernerObjetivo"/>
         </entity-listeners>
         ...
     </entity>
     ```

2. En la `ClaseListerner` objetivo tiene que ser una clase java -> en el paquete de repositorios
   - Tiene que ser un **Bean (@Component)**
3. Le añado las anotaciones del ciclo de vida sobre los metodos que se tienenen que lanzar.

   - Por anotaciones

     ```
     @Component
     class ListernerObjetivo{

     @PrePersist
     public void prePersist(Object object) {
         //instrucciones
     }
     @PreUpdate
     public void preUpdate(Object object) {
       //instrucciones
     }
     ```

   - Por XML, en su ORM añado las clases listener

     ```
     <entity name="ListernerObjetivo" class="es.ruta.ListernerObjetivo" access="FIELD">
        <pre-persist method-name="prePersist"/>
        <pre-update method-name="preUpdate"/>
         ...
     </entity>
     ```

     > **¡Es obligatorio que los metodos @PrePersist,... reciban un parametro!**
     > Sera normal que se pase el propio objeto iniciador (va implicito el paso) como parametro a alguno de los metodos objetivo.
     > Tambien puede ser un **@Bean** el que se pase al método

[Volver a inicio](#springbasics)

## 13. Servicio Entidad

Por rendimiento puede hacer falta cargar al iniciar la API determinados elementos de la BD en memoria, que se van a usar con frecuencia y que pueden ser usados por otras entidades. Al cargar en memoria se consigue:

- menos accesos a la BD
- Mayor rapidez al leer los datos (Ya estan en memoria).

Generar un servicio Entidad:

1. Crear un `@Bean` con un **metodo** clase java

   - llamado `getServicioEntidadACargar()`
   - que recibe por parametro las entidades de la BD que equeremos almacenar en memoria.
   - que devuelva el propio objeto **Map<Clase, ID>** servicioEntidad (que almacena pares campo-valor ).
   - Al cargarse en el contenedor, recupera de la BD los elementos que nos interesan y los almacena en una variable.

     - (Se puede crear en el archivo de configuracionPorJava)

     ```
     @Bean
     public Map<Clase, ID> getServicioEntidad(IntfDAO intfDAO){
         Map<Clase, ID> servicioEntidad = new HashMap<>();
         intfDAO.findAll().forEach(p -> {
             servicioEntidad.add(Participante.class, p)
         })
         return servicioEntidad;
     }
     ```

1. Las entidades que necesiten recuperar algun dato de los que se almacenen en el Servicio Entidad

   - Tendran una variable de tipo Servicio Entidad

1. Agrego el **parametro ServicioEntidad** al constructor/setter del resto de entidades que van a a necesitar algun elemento de lo almacenado en él, para que cuando se cree una entidad de ese tipo, recuperen los datos de lo almacenado en él sin acceder a la BD.

   - Al insertar por el constructor se asignara el parametro(que sera un bean a la variable local)

> Esto esta sin probar.

[Volver a inicio](#springbasics)

## 14. Integrando Librerias

Voy a utilizar código de otro proyecto en el mio. Podré desarrollar por un lado el proyecto-**API** para realizar la persistencia y la capa REST y en otro proyecto-**LIB** (mi libreria) desarrollaré la lógica de mi negocio (java "puro")

El código de la libreria se puede obtener de un repositorio en la nube (gradle lo autocompila) o aprovechar el código de un proyecto en local.

Ambos proyectos deberían ser Proyectos Gradle:

- El de la API con Spring con todas las dependencias para REST y pesrsistencia
- El de la LIB sera un proyecto Gradle Spring, sin dependencias (aunque se le quitarán las anotaciones Spring).

#### 14.1 Integrar Proyecto Local

Prerrequisitos:

- Está generado el proyecto API y la libreria con Spring.
- Están en local (clonados o generados).
- Ambos Proyectos deberian tener su propio **GIT**

1. El `proyecto-LIBreria` esta en la misma carpeta donde está mi `proyecto-API` (en carpetas hermanas).
2. Al proyecto **LIB**reria le quito todas las anotaciones e importaciones de Spring
   - En el main
     - @SpringApplication
     - SpringContext = `SpringApplication.run`
   - dependencias y plugins Spring del build.gradle
   - La carpeta de Tests
3. Importar ambos proyectos Gradle en eclipse.
   - Usar valores por defecto
4. En el `build.gradle` del proyecto **LIB**
   - **NO** puede haber plugins de `Springframework`
   - Eclipse Necesita el plugin
     - `id 'java'`
     - `id 'java-library'`
     - `id 'eclipse'`
5. En el **`settings.gradle`** del proyecto **API**
   - Debe coincidir el nombre del directorio con el del preyecto
     `rootProject.name = 'nombreProyectoAPI'` (si esta hecho con Spring lo genera automáticamente)
   - Introduzco una linea nueva con:
     `includeFlat 'proyecto-LIBreria'`
     > Debe ser el mismo nombre que tiene el proyectoLIB en su settings.gradle
6. En el **`build.gradle`** del proyecto **API**
   - Introduzco en el apartado **`dependencias`**
     ```
     dependencies {
       //
       implementation project(':proyecto-LIBreria')
     }
     ```
7. Ejecutar **Refresh gradle project**
   - en propiedades de mi proyecto en java build path → saldrá la librería como una dependencia
8. Ejecutar en eclipse gradle
   **gradle task ide ⇒ generate all eclipse files**

> En propiedades de mi proyecto en java build path (o en la carpeta Project and External Dependencies) → saldrá la librería como una dependencia

> Comprobar llamando desde la API a una clase de la libreria

#### 14.2 Integrar Proyecto de GitHub

Se podrá integrar una libreria de un repositorio de codigo abierto como **MAVEN Central** (Compilado), o de un repositorio publico de **GitHub** (Sin compilar) para lo que se necesita compilar con **jit-pack**.

Eclipse Necesita el plugin
`id 'application'`

1. Añado el repositorio y JitPack

   ```
   repositories {
         mavenCentral()
         maven { url 'https://jitpack.io' }
   }
   ```

2. Ir a dependencias y añadir linea
   `implementation:'Grupo : artefacto : Versión'` - grupo: es la ruta al usuario de GitHub - artefacto: es el proyecto del usuario - versión: es el tag-release - en version se puede poner - 1 version concreta - `sanapshot` (ultima versión) - 1 commit concreto > puedo poner varias versiones que se crearan en sus carpetas correspondientes

3. ejecutar gradle → refresh project

   - Saldrán en `project and external dependencies` las que haya añadido, pudiendo emplearlas en mi codigo

#### 14.3 Integrar Proyecto de Repositorio en la nube

Podre integrar una API o una dependencia.

Api vs Dependencia

- una api alguien puede utilizar los métodos de la api desde mi librería
- una dependencia No se puede → solo los puede usar mi librería en local

1.  Ir a dependencias y añadir linea
    `implementation/api:'Grupo : artefacto : Versión'`

#### 14.4 Precedencia y exportacion de dependencias

Existe precedencia cuando hay conflicto entre clases iguales

- 1° la mas arriba del build path → order export
- **export** ⇒ cualquiera que use mi liberia tendrá acceso a las librerias externas que esa integre.

[Volver a inicio](#springbasics)
