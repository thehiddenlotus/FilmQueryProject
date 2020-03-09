package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";	
	private String user = "student";
	private String pass = "student";

	@Override
	public Film findFilmById(int filmID) {
		Film film = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, title, description, release_year, language_id, rental_duration, "
					+ " rental_rate, length, replacement_cost, rating, special_features " + " FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);
			ResultSet filmResult = stmt.executeQuery();
			if (filmResult.next()) {
				int filmId = filmResult.getInt(1);
				String title = filmResult.getString(2);
				String desc = filmResult.getString(3);
				int releaseYear = filmResult.getShort(4);
				int langId = filmResult.getInt(5);
				int rentDur = filmResult.getInt(6);
				double rate = filmResult.getDouble(7);
				int length = filmResult.getInt(8);
				double repCost = filmResult.getDouble(9);
				String rating = filmResult.getString(10);
				String features = filmResult.getString(11);
				film = new Film(filmId, title, desc, releaseYear, langId, rentDur, rate, length, repCost, rating,
						features);

			}
			filmResult.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	public Actor findActorById(int actorID) {
		Actor actor = null;
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorID);
			ResultSet actorResult = stmt.executeQuery();
			if (actorResult.next()) {
				actor = new Actor(actorResult.getInt(1), actorResult.getString(2), actorResult.getString(3));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return actor;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmID) {
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT id, first_name, last_name FROM actor JOIN film_actor "
					+ "ON actor.id = actor.id WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, filmID);
			ResultSet filmActors = stmt.executeQuery();
			while (filmActors.next()) {
				int id = filmActors.getInt(1);
				String firstName = filmActors.getString(2);
				String lastName = filmActors.getString(3);
				Actor actor = new Actor(id, firstName, lastName);
				actors.add(actor);
			}
			filmActors.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

}
