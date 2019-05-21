
package application.model.dao;

import java.sql.Connection;


import javafx.collections.ObservableList;




public abstract class DAO<T> {

	    public static Connection connect = MysqlConnection.getInstance();
	    public abstract  ObservableList <T> findall();
	    /** * Permet de créer une entrée dans la base de données * par rapport à un objet*/
	    public abstract ObservableList <T> Create(T obj);
	    /** * Permet de mettre à jour les données d'une entrée dans la base  */
	    public abstract ObservableList<T>update(T obj);
	    /** * Permet la suppression d'une entrée de la base * @param obj */
	    public abstract ObservableList<T>delete(T obj);

	    
	}

