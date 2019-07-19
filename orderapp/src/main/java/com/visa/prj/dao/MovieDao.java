package com.visa.prj.dao;

import com.visa.prj.entity.Actor;
import com.visa.prj.entity.Movie;

public interface MovieDao {
	void addMovie(Movie m);
	void addActor(Actor a);
	
	Movie getMovie(int movieId);
	Actor getActor(int actorId);
	void assignActorsToMovie(Movie m);
}
