package food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringAutoWiringBeansApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAutoWiringBeansApplication.class, args);

		ApplicationContext appContext = new ClassPathXmlApplicationContext("myTestPack/appContext.xml") {
		};

		Meal mySpringMeal = appContext.getBean("meal", Meal.class);
		System.out.println("Spring meal: " + mySpringMeal.whatsInThisMeal());

		Meal myAutowiredByTypeMeal = appContext.getBean("mealAutowired", Meal.class);
		System.out.println("Autowired meal: " + myAutowiredByTypeMeal.whatsInThisMeal());

		Meal myAutowiredByNameMeal = appContext.getBean("mealAutowiredByName", Meal.class);
		System.out.println("Autowired meal: " + myAutowiredByNameMeal.whatsInThisMeal());

		Meal mySpringMeal2 = appContext.getBean("meal2", Meal.class);
		System.out.println("Spring meal: " + mySpringMeal2.whatsInThisMeal());

		Meal myAutowiredByConstructor = appContext.getBean("autowiredByConstructor", Meal.class);
		System.out.println("Autowired meal: " + myAutowiredByConstructor.whatsInThisMeal());

		Meal myAutowiredByDef = appContext.getBean("mealAutowiredDef", Meal.class);
		System.out.println("Autowired meal: " + myAutowiredByDef.whatsInThisMeal());

		((ClassPathXmlApplicationContext) appContext).close();
	}
}
