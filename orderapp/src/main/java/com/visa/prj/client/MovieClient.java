package com.visa.prj.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.visa.prj.dao.MovieDao;
import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

public class MovieClient {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.visa");
		ctx.refresh();
		
		MovieDao dao = (MovieDao) ctx.getBean("movieDaoJpaImpl");
		Movie m = dao.getMovie(2); // Avengers
		Actor a1 = dao.getActor(2); // Elizabeth
		Actor a2 = dao.getActor(1);	// Michael
		m.getActors().add(a1);
		m.getActors().add(a2);
		
		dao.assignActorsToMovie(m);
		
//		Actor a1 = new Actor();
//		a1.setName("Michael Caine");
//		
//		Actor a2 = new Actor();
//		a2.setName("Elizabeth Olssen");
//		
//		Movie m1 = new Movie();
//		m1.setName("The Dark Knight");
//
//		Movie m2 = new Movie();
//		m2.setName("Avengers");
//		
//		dao.addActor(a1);
//		dao.addActor(a2);
//		dao.addMovie(m1);
//		dao.addMovie(m2);
		
		System.out.println("Movies and actors stored!");
	}
	

}
