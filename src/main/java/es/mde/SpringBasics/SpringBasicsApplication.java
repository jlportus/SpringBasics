package es.mde.SpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.mde.SpringBasics.entidades.POJO.UsuarioAnotaciones;
import es.mde.SpringBasics.entidades.POJO.UsuarioXML;
import es.mde.SpringBasics.entidades.autowired.AutowiredInterfz;
import es.mde.SpringBasics.entidades.autowired.UsaAutowired;
import es.mde.SpringBasics.entidades.herencia.HijoHerencia;
import es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorAnotaciones;
import es.mde.SpringBasics.entidades.inyeccionDeBeans.ClaseConfiguracionJava;
import es.mde.SpringBasics.entidades.log.LoggingTester;
import es.mde.SpringBasics.repositorios.HijoHerenciaDAO;
import es.mde.SpringBasics.entidades.oneToMany.Elemento;
import es.mde.SpringBasics.entidades.oneToMany.PadreConColeccion;
import es.mde.SpringBasics.repositorios.ElementoDAO;
import es.mde.SpringBasics.repositorios.PadreConColeccionDAO;
import es.mde.SpringBasics.repositorios.UsuarioDAO;
import es.mde.SpringBasics.repositorios.UsuarioXMLDAO;
import es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorXML;

@SpringBootApplication
@ImportResource({ "classpath:config/jpa-config.xml" })
@Import({ ClaseConfiguracionJava.class })
@PropertySource({ "valoresConstantes.properties" })
public class SpringBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext context = // mi objeto contenedor
				SpringApplication.run(SpringBasicsApplication.class, args);
		System.out.println("esto de Spring fucniona");

//			     new ClassPathXmlApplicationContext(
//			          new String[]{
//			        		  //aqui pongo mis archivos de configuracion.xml
////			        		  "config/config-BeanPorXML.xml", 
////			        		  "config/configScan-ConfigXJava.xml",
//			        		  "config/configScan-Anotaciones.xml"
//			        		  }
//			          );

//		BeanPorXML objetoBeanPorXML = context.getBean(BeanPorXML.class);
//		System.out.println(objetoBeanPorXML.toString());

		// tengo que desmbiguar porque me dice que existen dos Ban por ConfigJava->uso
		// el metodo Sobrecargado con el Alias
//		BeanPorClaseConfiguracionJava objetoBeanPorConfigJava = context.getBean("BeanConfigJava", BeanPorClaseConfiguracionJava.class);
//		System.out.println(objetoBeanPorConfigJava.toString());

		BeanPorAnotaciones objetoBeanPorAnotaciones = context.getBean(BeanPorAnotaciones.class);
		System.out.println(objetoBeanPorAnotaciones.toString());
		objetoBeanPorAnotaciones.init();
		objetoBeanPorAnotaciones.probandoVariablesExternas(null);

		LoggingTester testeadorDeLoggingTester = context.getBean(LoggingTester.class);
		testeadorDeLoggingTester.metodoTester();

		System.out.println("Probando Autowired:");
		UsaAutowired autoenlazadoAutowired = context.getBean(UsaAutowired.class);
		autoenlazadoAutowired.init();

		System.out.println("Probando Persistencia POJO por anotaciones");
		UsuarioDAO miUsuario = context.getBean(UsuarioDAO.class);
//		miUsuario.save(new UsuarioAnotaciones());
//		miUsuario.save(new UsuarioAnotaciones());
//		miUsuario.deleteById(3);

//		System.out.println("Probando Persistencia POJO por XML");
//		UsuarioXMLDAO miUsuarioXML = context.getBean(UsuarioXMLDAO.class);
//		miUsuarioXML.save(new UsuarioXML());
//		miUsuarioXML.save(new UsuarioXML());
//		miUsuario.deleteById(3);
		
		System.out.println("Probando Persistencia con herencias");
		HijoHerenciaDAO hijoConHerencia = context.getBean(HijoHerenciaDAO.class);
		hijoConHerencia.save(new HijoHerencia());
		

		System.out.println("Probando Persistencia Pre One to Many");
		PadreConColeccionDAO padreContenedorColeccion = context.getBean(PadreConColeccionDAO.class);
		PadreConColeccion padre = new PadreConColeccion("papa");
		Elemento elemento = new Elemento("hijo");
		padre.addElemento(elemento);
		
		
		
		
		
		
		padreContenedorColeccion.save(padre);
		ElementoDAO elementoElemento = context.getBean(ElementoDAO.class);
		
		elementoElemento.save(elemento);

	}

}
