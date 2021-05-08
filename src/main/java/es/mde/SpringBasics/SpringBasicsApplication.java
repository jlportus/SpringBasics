package es.mde.SpringBasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.mde.SpringBasics.entidades.inyeccionDeBeans.BeanPorXML;

//@SpringBootApplication
public class SpringBasicsApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SpringBasicsApplication.class, args);
		System.out.println("esto de Spring fucniona");
		ApplicationContext context = //mi objeto contenedor
			     new ClassPathXmlApplicationContext(
			          new String[]{
			        		  //aqui pongo mis archivos de configuracion.xml
			        		  "config/config-BeanPorXML.xml", 
			        		  //"configfile2.xml"
			        		  }
			          );
		BeanPorXML objetoBeanPorXML = context.getBean(BeanPorXML.class);
		System.out.println(objetoBeanPorXML.toString());
	}

}
