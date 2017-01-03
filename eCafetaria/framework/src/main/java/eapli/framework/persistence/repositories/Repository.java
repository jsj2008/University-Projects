/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package eapli.framework.persistence.repositories;

import eapli.framework.persistence.DataConcurrencyException;
import eapli.framework.persistence.DataIntegrityViolationException;

/**
 * A generic interface for repositories.
 *
 * @param T the class we want to manage in the repository
 * @param PK the class denoting the primary key of the entity
 * @author Paulo Gandra Sousa
 */
public interface Repository<T, K> {

	/**
	 * Saves an entity either by creating it or updating it in the persistence.
	 * store.
	 *
	 * @param entity
	 * @return
	 * @throws eapli.framework.persistence.DataConcurrencyException
	 */
	T save(T entity) throws DataConcurrencyException;

	/**
	 * Creates a new an entity in the persistence layer. if the entity already
	 * exists it will throw an exception.
	 *
	 * FIXME check which exception to throw. it should not be a persistence
	 * layer exception.
	 *
	 * @param entity
	 * @return
	 * @throws eapli.framework.persistence.DataIntegrityViolationException
	 */
	boolean add(T entity) throws DataIntegrityViolationException;

	/**
	 * gets all entities from the repository.
	 *
	 * @return
	 */
	Iterable<T> all();

	/**
	 * gets the entity with the specified id
	 *
	 * @param id
	 * @return
	 */
	T findById(K id);

	/**
	 * returns the number of entities in the repository.
	 *
	 * @return
	 */
	long size();

	/**
	 * Delete an entity in the persistence layer.
	 *
	 * @param entity
	 * @throws eapli.framework.persistence.DataIntegrityViolationException
	 */
	void delete(T entity) throws DataIntegrityViolationException, DataConcurrencyException;
}
