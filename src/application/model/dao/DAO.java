
package application.model.dao;

import java.sql.Connection;


import javafx.collections.ObservableList;




public abstract class DAO<T> {

	    public static Connection connect = MysqlConnection.getInstance();
	    public abstract  ObservableList <T> findall();
	    /** * Permet de cr�er une entr�e dans la base de donn�es * par rapport � un objet*/
	    public abstract ObservableList <T> Create(T obj);
	    /** * Permet de mettre � jour les donn�es d'une entr�e dans la base  */
	    public abstract ObservableList<T>update(T obj);
	    /** * Permet la suppression d'une entr�e de la base * @param obj */
	    public abstract ObservableList<T>delete(T obj);

	    
	}

