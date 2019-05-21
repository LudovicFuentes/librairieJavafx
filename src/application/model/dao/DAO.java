
package application.model.dao;

import java.sql.Connection;




public abstract class DAO<T> {

	    public static Connection connect = MysqlConnection.getInstance();
	    /** * Permet de créer une entrée dans la base de données * par rapport à un objet*/
	    
	    public abstract T create(T obj);
	    /** * Permet de mettre à jour les données d'une entrée dans la base  */
	    public abstract T update(T obj);
	    /** * Permet la suppression d'une entrée de la base * @param obj */
	    public abstract void delete(T obj);

	    
	}

