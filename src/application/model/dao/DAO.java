
package application.model.dao;

import java.sql.Connection;
import javafx.collections.ObservableList;



public abstract class DAO<T> {

	    public Connection connect = MysqlConnection.getInstance();
	    /** * Permet de r�cup�rer un objet via son ID * @param id * @return */
	    public abstract ObservableList<T>  findall();
	    /** * Permet de cr�er une entr�e dans la base de donn�es * par rapport � un objet*/
	    public abstract T create(T obj);
	    /** * Permet de mettre � jour les donn�es d'une entr�e dans la base  */
	    public abstract T update(T obj);
	    /** * Permet la suppression d'une entr�e de la base * @param obj */
	    public abstract void delete(T obj);

	    
	}

