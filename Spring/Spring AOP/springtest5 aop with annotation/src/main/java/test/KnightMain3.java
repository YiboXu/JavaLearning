package test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import concert.Performance2;
import tacos.DefaultEncoreable;
import tacos.Encoreable;
import tacos.EncoreableIntroducer;
import tacos.Performance;
import tacos.SampleConfig;

public class KnightMain3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SampleConfig.class);
		
		Performance movie = (Performance)context.getBean(Performance.class);
		
		System.out.println("***************Basic AOP sample output***************");
		movie.perform();
		
		System.out.println("***************Basic AOP with parameter sample output***************");
		movie.report("Good Forever");
		
		System.out.println("***************Basic introducer sample output***************");
		Encoreable enco = (Encoreable)movie;
		enco.performEncore();
		
		//Performance2 drama = context.getBean(Performance2.class);
		//drama.perform();
		
		context.close();
	}

}
