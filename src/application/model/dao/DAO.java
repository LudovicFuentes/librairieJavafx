
package application.model.dao;

import java.sql.Connection;


import javafx.collections.ObservableList;




public abstract class DAO<T> {
// Les methodes seront des observableList car le tableview n'accepte que ce format//
	    public static Connection connect = MysqlConnection.getInstance();
	    // Permet l'affichage de toutes les entrée de la base//
	    public abstract  ObservableList <T> findall();
	    // Permet la creation d'une entrée de la base * @param obj //
	    public abstract ObservableList <T> Create(T obj);
	    // Permet la modification d'une entrée de la base * @param obj //
	    public abstract ObservableList<T>update(T obj);
	    // Permet la suppression d'une entrée de la base * @param obj //
	    public abstract ObservableList<T>delete(T obj);

	    
	}

