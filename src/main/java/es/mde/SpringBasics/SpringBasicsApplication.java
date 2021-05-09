package es.mde.SpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorAnotaciones;
import es.mde.SpringBasics.entidades.inyeccionDeBeans.ClaseConfiguracionJava;
import es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorXML;

@SpringBootApplication
@ImportResource({"classpath:config/jpa-config.xml"})
@Import({ClaseConfiguracionJava.class})
@PropertySource({"valoresConstantes.properties"})
public class SpringBasicsApplication {

	public static void main(String[] args) {
		ApplicationContext context = //mi objeto contenedor
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
		
		//tengo que desmbiguar porque me dice que existen dos Ban por ConfigJava->uso el metodo Sobrecargado con el Alias
//		BeanPorClaseConfiguracionJava objetoBeanPorConfigJava = context.getBean("BeanConfigJava", BeanPorClaseConfiguracionJava.class);
//		System.out.println(objetoBeanPorConfigJava.toString());
		
		BeanPorAnotaciones objetoBeanPorAnotaciones = context.getBean(BeanPorAnotaciones.class);
		System.out.println(objetoBeanPorAnotaciones.toString());
		objetoBeanPorAnotaciones.init();
		objetoBeanPorAnotaciones.probandoVariablesExternas(null);
	}

}
