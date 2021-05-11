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

- El bean tendra un alias en su etiqueta ``@Bean(name="alias")``
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
2. añado el archivo al contenedor (o lo importo en mi main si estoy usando SpringBoot)
3. Defino los Bean en el XML con
    ```
   <bean class="ruta.clase" id="alias">
        <property name="campoBean"></property>
    </bean>
   ```

   ### 4.2 Beans por clase de configuracion Java 

Es el modo intermedio.

1. Creo una clase Java que la llamare claseConfiguracionPorJava (puede ser Otro nombre cualquiera) en la raiz del proyecto **al lado del Main**
1. Le añado la anotacion ``@Configuration``
1. Creo dentro los metodos() que me van a devolver normalmente un objeto y les pongo la anotacion ``@Bean``
    -  Puedo usarlos para tunear mis beans o los objetos
    - Puede tener un alias `@Bean("alias")`
      - Da igual poner el `name=` si solo hay un elemento en el parentesis
    - Puedo ponerle un metodo inicial
    `@Bean(name="alias", initMethod="init")`
1. Necesito que la clase sea escaneada al crear el contenedor configurandolo con un xml
    - Tengo que añadir el XML al contenedor

    ### 4.3 Beans por @Anotaciones 

Es el modo mas acoplado.
    -> **¡Necesito acceso al código!**

1. Pongo la anotacion ``@Component`` en la cabecera de la **clase** que sea un Bean
    - Se hace de la misma manera para las anotaciones que heredan de @component
      - ``@Controller`` -> para la presentacion
      - ``@Service`` -> Para crear servicios
      - ``@Repository`` -> Para Persistir
    - Pueden tener un alias `@Component("alias")`
1. Hago que spring escanee los elementos que tengan la anotacion **@Component** o herederas
  - Por XML
    - Creo un ``config-scan.xml`` donde declaro donde escanear
    - Añado el xml al contenedor

    ### 4.4 Prelacion de Beans

Si tengo dos Beans iguales cargados de diferentes modos, uno me sobreescribira a otro o No sabre a que Bean me estoy refiriendo.
- Prelacion
  - 1º Beans por XML
  - 2º Beans por clase de configuracion Java
  - 3º Beans por anotaciones

  ### 4.5 Desambiguando Beans

Necsesitare usar alias para referirme a un alias concreto

- alias en su anotacion ``@Bean(name="alias")``
- Alias en Etiqueta.xml con atriduto **id** ``<bean class="ruta.clase" id="alias">``

Para recuperar uso el getBean sobrecargado.
```
variableDeMiObjeto = context.getBean("alias", ObjetoTipo.class)
```

## 5. Arrancando con SPRINGBoot

Una vez hecho el proyecto spring con initializer, me crea una serie de anotaciones por defecto
- En el main
``@SpringBootApplication``
    Equivale a: **@Configuration + @EnableAutoConfiguration + @ComponentScan**
  - Automaticamente escanea buscando ``@anotaciones`` en todos los archivos del paquete en el que se encuentra, **y en los que cuelguen de él** . 
  - Lo que esta fuera ¡NO lo escanea! salvo que se lo diga expresamente.
  - Tambien escaneara el ``application.properties`` por defecto de Spring

  ``SpringApplication.run(SpringBasicsApplication.class, args)``

  - Sentencia que genera automaticamente el contenedor y en el que se almacenan los Beans que encuentre.
    - Puedo asignarlo a una variable para poder acceder con ``.getBean()``
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
  ### 5.1 Añadiendo recursos externos a Spring Boot

Como Spring Boot solo escanea lo que este en su mismo paquete, le debo decir donde puede buscar mas recursos que quiera inyectar.

- Insertando por **config.xml**
  1. en el ``main``  le digo que debe escanear el recurso (resource) de mi archivo XML. Agrego la anotacion 
  ``@ImportResource({"classpath:jpa-config.xml"})``
      - Puedo  poner mas archivos separados por comas ``,``
  1. Ahi tendré las configuraciones al estilo Bean (se ve mas adelante)
- **Importando clases** de configuracion por java externas
    - Añado al ``main`` la anotacion ``@Import({ruta.ClaseConfiguracionJava.class})`` con la ruta a la clase 

  ### 5.2 Insertando valores externos en campos de Beans
Voy a insertar con la anotacion ``@Value`` un String proveniente de un fichero ``.properties`` externo al codigo.

  1. Inserto el archivo properties nuevo al main
    ``@PropertySource({"valoresConstantes.properties"}) ``
  1. Creo el archivo ``valoresConstantes.properties`` en la carpeta ``resources``
  1. Introduzco los pares clave valor que quiero insertar despues en mi codigo
  ``campoExterno=valor de campo Externo``
  1. En el Bean que quiero usar el campo externo pongo la anotacion **con el placeHolder** ``@Value("${campoExterno}")`` antes del campo o del parametro del metodo Bean que voy a usar
      -  Me sustiuira el valor de la variable por el almacenado en el archivo properties
      - En el bean tiene que ir como un parametro
      ```
      public String probandoVariablesExternas( 
        @Value("${campoExterno2}") String valor ) {
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
## 6. Logging

Pretendo llevar un registro de sucesos que ocurren con la aplicacion.
Sustituire las salidas que normalmente lanzaba por consola para comprobar a otro lugar, ademas de mensajes de error, etc.

-> fichero.log

- Tambien puedo lanzar una notificacion o mandar un correo ante un evento. 

Podre hacer un log por cada singleton
En la clase que quiera emplear el **log**
1. Creo un objeto Logger estatico final
``private final Logger log = LoggerFactory.getLogger(ClaseAHacerLog.class);``
    - Al importar tengo que importar el logger de **slf4j**
    - Me dara acceso a los metodos de log
1. Donde quiera que me elabore un mensaje de log (donde pondria un System.out.prntln), llamo a mi objeto **Log** y uso sus metodos:
``log.info("Mi mensaje: {}", testString) ``
    - Personalizo el mensaje de salida. Uso String con placeHolders llamados por ``{}``, insertados en orden de los `elementos.toString` separados por las comas
    - Tendre varios niveles de prioridad:
      - 1 ERROR - Errores
      - 2 WARN - Alertas
      - 3 INFO - Nivel Por defecto. Mostrara de info hacia arriba
      - 4 DEBUG - Informacion importante para depuracion
      - 5 TRACE - Capta todo

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

## 7. Autowired

Cuando en un Bean necesito que se inyecte automaticamente otro Bean podré utilizar `@Autowired` en el Bean que vaya a ser inyectado
-> La anotacion solo se debe utilizar en metodos que reciban parametros
Normalmente si solo hay un Bean que sea del tipo necesitado en mi contenedor, no sera necesario.

En un `@Component` puedo Utilizar Autowired en tres sitios:
- En el Constructor -> Cuando el parametro del constructor sea un **campo obligatorio**-> automaticamente pasara al constructor al cargar el Bean inyectado (si no puede crear un null)
- En un setter -> Cuando el campo sea opcional
- En el campo directamente -> Desaconsejado.
```
@Component
class...{
  //...
@Autowired
public TestAutowired(Test testPorConstructor) {
    testInyectado = testPorConstructor;
}
```
    ->Buscara un bean de tipo Test y lo inyectara para su empleo.

  ### 7.1 Conflictos entre bean inyectables(varios candidatos)

Se puede dar el caso que tenga varios Bean del mismo tipo y Spring no sepa cual usar.

#### Conflictos entre constructores del Bean Creado:

Si tengo varios constructores de mi bean con sobrecarga, Spring no va a saver cual usar.

- `@Autowired` == `@Autowired(required=true)` cogera ese constructor por defecto
    - Solo puede haber un required true en mi Bean.
- `@Autowired(required=false)` de entre todos los constructores que tengan esta anotacion cogera el que tenga mayor coincidencia en el numero de parametros pasados.

#### Conflictos entre Bean candidatos a inyectar:

* Si quiero inyectar un Bean en concreto de los candidatos usaré la anotación **Qualifier** en el lugar donde se vaya a inyectar del Bean.
```
public void  setTestAutowired(@Qualifier("aliasDelBean") Test test) {//...}
```
  -> Inyectara el Bean con el alias indicado

  **ó**

Si quiero que en todo el codigo se escoja un Bean por defecto cuando se tenga que inyectar, puedo usar **Primary** En la declaracion del Bean.
```
@Bean
@Primary
public Test miTest() {...}
```
  ->Solo puedo tener un Bean con primary en todos mis candidatos, si no tendre conflictos.