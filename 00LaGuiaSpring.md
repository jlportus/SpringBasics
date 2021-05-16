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

ejecutar:

- **refresh gradle proyect**
- **boot run** -> debe arrancar Spring sin errores

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
- ## paquete.main.**resources** (generado por Spring) -> Contendra los archivos **.properties**
  - paquete **config** con:
    - jpa-config.xml -> mi **entity-manager**
    - properties de jackson o de REST
  - paquete **jpa**
    - con todos los archivos.**orm.xml** para cada clase a persistir

## 4. Inyectando Beans

Los Beans son objetos singleton que quiero utilizar, seran las clases que luego quiera persistir o mostrar por REST.

Voy a inyectar Beans a mano sin usar Spring,

> comento las lineas de mi main

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

- tendre que importar las recomendaciones del eclipse que sean de Springframework
- puedo poner varios archivos de configuracion por XML pasandoselos al array separados por comas.
  - -> Deben estar en la carpeta main resources para que los encuentre. Seran de:
    - de configuracion donde le paso los beans que debe hacer xml + desacoplado
    - de scaneo- para que busque las anotaciones @component... (necesito acceso al codigo)
- Tambien puedo crear **¡¡¡un solo archivo de configuracion.xml!!!** con toda la informacion que necesite.

Para recuperar un **BEAN**

- creo un objeto del tipo que quiero emplear

```
ObjetoTipo variableDeMiObjeto = new ObjetoTipo();
```

- a mi variable le asigno el bean de mi contenedor mediante el metodo .getBean

```
variableDeMiObjeto = context.getBean(ObjetoTipo.class)
```

- importante el **.class**

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
1. Le añado la anotacion `@Configuration`
1. Creo dentro los metodos() que me van a devolver normalmente un objeto y les pongo la anotacion `@Bean`
   - Puedo usarlos para tunear mis beans o los objetos
   - Puede tener un alias `@Bean("alias")`
     - Da igual poner el `name=` si solo hay un elemento en el parentesis
   - Puedo ponerle un metodo inicial
     `@Bean(name="alias", initMethod="init")`
1. Necesito que la clase sea escaneada al crear el contenedor configurandolo con un xml

   - Tengo que añadir el XML al contenedor

   ### 4.3 Beans por @Anotaciones

Es el modo mas acoplado.

> **¡Necesito acceso al código!**

1. Pongo la anotacion `@Component` en la cabecera de la **clase** que sea un Bean
   - Se hace de la misma manera para las anotaciones que heredan de @component
     - `@Controller` -> para la presentacion
     - `@Service` -> Para crear servicios
     - `@Repository` -> Para Persistir
   - Pueden tener un alias `@Component("alias")`
1. Hago que spring escanee los elementos que tengan la anotacion **@Component** o herederas

- Por XML

  - Creo un `config-scan.xml` donde declaro donde escanear
  - Añado el xml al contenedor

  ### 4.4 Prelacion de Beans

Si tengo dos Beans iguales cargados de diferentes modos, uno me sobreescribira a otro o No sabre a que Bean me estoy refiriendo.

- Prelacion

  - 1º Beans por XML
  - 2º Beans por clase de configuracion Java
  - 3º Beans por anotaciones

  ### 4.5 Desambiguando Beans

Necsesitare usar alias para referirme a un alias concreto

- alias en su anotacion `@Bean(name="alias")`
- Alias en Etiqueta.xml con atriduto **id** `<bean class="ruta.clase" id="alias">`

Para recuperar uso el getBean sobrecargado.

```
variableDeMiObjeto = context.getBean("alias", ObjetoTipo.class)
```

## 5. Arrancando con SPRINGBoot

Una vez hecho el proyecto spring con initializer, me crea una serie de anotaciones por defecto

- En el main
  `@SpringBootApplication`
  Equivale a: **@Configuration + @EnableAutoConfiguration + @ComponentScan**

  - Automaticamente escanea buscando `@anotaciones` en todos los archivos del paquete en el que se encuentra, **y en los que cuelguen de él** .
  - Lo que esta fuera ¡NO lo escanea! salvo que se lo diga expresamente.
  - Tambien escaneara el `application.properties` por defecto de Spring

  `SpringApplication.run(SpringBasicsApplication.class, args)`

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

  ### 5.1 Añadiendo recursos externos a Spring Boot

Como Spring Boot solo escanea lo que este en su mismo paquete, le debo decir donde puede buscar mas recursos que quiera inyectar.

- Insertando por **config.xml**
  1. en el `main` le digo que debe escanear el recurso (resource) de mi archivo XML. Agrego la anotacion
     `@ImportResource({"classpath:jpa-config.xml"})` - Puedo poner mas archivos separados por comas `,`
  1. Ahi tendré las configuraciones al estilo Bean (se ve mas adelante)
- **Importando clases** de configuracion por java externas - Añado al `main` la anotacion `@Import({ruta.ClaseConfiguracionJava.class})` con la ruta a la clase

  ### 5.2 Insertando valores externos en campos de Beans

  Voy a insertar con la anotacion `@Value` un String proveniente de un fichero `.properties` externo al codigo.

  1. Inserto el archivo properties nuevo al main
     `@PropertySource({"valoresConstantes.properties"}) `
  1. Creo el archivo `valoresConstantes.properties` en la carpeta `resources`
  1. Introduzco los pares clave valor que quiero insertar despues en mi codigo
     `campoExterno=valor de campo Externo`
  1. En el Bean que quiero usar el campo externo pongo la anotacion **con el placeHolder** `@Value("${campoExterno}")` antes del campo o del parametro del metodo Bean que voy a usar

     - Me sustiuira el valor de la variable por el almacenado en el archivo properties
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

> fichero.log

- Tambien puedo lanzar una notificacion o mandar un correo ante un evento.

Podre hacer un log por cada singleton
En la clase que quiera emplear el **log**

1. Creo un objeto Logger estatico final
   `private final Logger log = LoggerFactory.getLogger(ClaseAHacerLog.class);` - Al importar tengo que importar el logger de **slf4j** - Me dara acceso a los metodos de log
1. Donde quiera que me elabore un mensaje de log (donde pondria un System.out.prntln), llamo a mi objeto **Log** y uso sus metodos:
   `log.info("Mi mensaje: {}", testString) ` - Personalizo el mensaje de salida. Uso String con placeHolders llamados por `{}`, insertados en orden de los `elementos.toString` separados por las comas - Tendre varios niveles de prioridad: - 1 ERROR - Errores - 2 WARN - Alertas - 3 INFO - Nivel Por defecto. Mostrara de info hacia arriba - 4 DEBUG - Informacion importante para depuracion - 5 TRACE - Capta todo

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

> La anotacion solo se debe utilizar en metodos que reciban parametros
> Normalmente si solo hay un Bean que sea del tipo necesitado en mi contenedor, no sera necesario.

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
> ⇒ Necesito un archivo test en el home del usuario
> ↳ ejecuto la BD → `java -jar nombreArchivoH2`  
>  ↳ Me abre el navegador con el acceso a la BD
> ⇒ Seleccionar Generic H2 (Server)
> ⇒ connect - Si da pega cambiar a embebed y volver a Server - Puede dar pega el puerto
> ↳ añadir al properties `server.port = 8082` → Conflicto con Tomcat porque dice que esta ocupado

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

Para omitir campos al almacenar en la BD se usa **TRANSIENT**

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
  - tiene que haber un campo ID **Obligatorio**
    - Si quiero que se cree de manera automatica el ID
      `<generated-value strategy="IDENTITY"/>`
  - El resto si no se ponen nada se almacenan automaticamente
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

1. Añado al `jpa-config.xml` la lista con los archivos orm de cada Clase -> debe ser la ruta completa.
   ```
   <property name="mappingResources">
      <list>
          <value>jpa/IdentificableString.orm.xml</value>
          <!-- Se pueden poner varias entidades en un mismo archivo -->
          <value>jpa/otraClase.orm.xml</value>
      </list>
   </property>
   ```
2. tendre que tener igualmente mi `interfazDAO` de la clase a persistir.

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

### 8.6 Single Table

Puede haber casos de especializacion de entidades que tengan una superclase en comun (Con campos comunes, ID-PK) y cada subclase tenga campos especificos diferentes.
Por rendimiento en las consultas puede ser adecuado almacenar ambas especializaciones en una misma Tabla **Single Table** asumiedo que:

- Necesitaré un campo discriminatorio **TipoSubclase**
- Tendre **null´s** en los campos que no sean comunes

> Prerrequisitos: Existira una `mapped-superclass` de la cual heredaran ambas subclases. Lo normal será que sea la superclase al qeu contenga el ID(PK) de la tabla (seria un campo heredado para ambas)

En una de los `orm.xml` de una de las subclases le indico que va a ser una tabla Single

1. Dentro de la etiqueta `<entity>` existente introduzco como cabecera:

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
     ```

2. Agrego al `<entity-mappings>` la otra entidad como en un orm normal, añadiendo:

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

### 8.7 Persisitencia de clases con relación OneToMany

Cuando tenga una entidad que contenga un campo que sea una lista(colección) de otros elementos usaré el **One to Many**.

Para que la BD mantenga la trazabilidad de los elementos de una tabla a la otra, se hace con la propagacion de la FK.

> Si fuese una relacion muchos a muchos, se podria hacer con una **@Join Table** con ambas PK de cada tabla, usando [**@ManyToMany**. Ver documentación.](https://en.wikibooks.org/wiki/Java_Persistence/ManyToMany)

Para que la BD pueda hacer la relacion entre ambas Tablas, almacenara la PK de la tabla **@One** (se convertirá en FK) en un campo de cada elemento de la coleccion **@Many**.

Como prerrequisito: ambas clases deben ser **@Entity** (tener su ORM y su DAO)y tener ID.

> Lo que voy a guardar en el campo FK será otro objeto.
> JPA solo guarda primitivos u objetos si se estan empleando las relaciones @OneToMany.
> Si no quiero que falle al intentar guardar un tipo objeto que no conoce, antes de hacer las relaciones, debo poner el campo como transient para que lo evite.

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

   - **Por @ManyToOne**. En la clase Elemento de la coleccion, le pongo al campo Contenedor

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
   - por defecto Spring pone nombre sa las rutas que no seran amigables -> personalizar con:

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

   - Para añadir un mixin, se usa el metodo `.addMixin(Clase, Mixin)` -> cuando se crea un objeto del tipo Clase -> se personalizan sus campos con las anotaciones que haya en el Mixin.

   ```
     @Bean
     public ObjectMapper getObjectMapper() {
       ObjectMapper mapper = new ObjectMapper();
         mapper.addMixIn(Cliente.class, Mixins.Cliente.class);
       return mapper;
     }
   ```

1. Los **Mixins** sera una clase java que se guarde en el paquete `rest`
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
   - Para los campos y getters de la clase - Para personalizar el nombre del campo -> Si no se conoce el tipo de dato del getter -> Se puede usar `Object` - para ignorar el campo (Tiene preferencia en las herencias) - Para formatos personalizados (sobre todo en fechas)
     `@JsonProperty("nombreCampoPersonalizado") abstract String getNombre(); @JsonIgnore Object objeto; @JsonFormat( shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") public Date eventDate;`
     > Hay configuraciones de serializacion que se pueden anotar en un properties, para que se realicen sobre todos los objetos

> La serializacion es bidireccional, se aplica en los GET (salida) y en los POST (entrada) desde el front, es decir al mandar objetos tienen que tener la misma estructura con los mismos nombres en los campos.

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

## 10. Servicio Entidad

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

## 11.Listeners

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

2. En la clase ListernerObjetivo tiene que ser un **@Bean** -> en el paquete de repositorios 
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

     > Sera normal que se pase el propio objeto iniciador (va implicito el paso) como parametro a alguno de los metodos objetivo.
     > Tambien puede ser un **@Bean** el que se emplee en el método

 