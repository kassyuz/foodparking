package com.food.parking.business;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractBO<E> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractBO.class);
	private final Class<?> clazz;
	protected EntityManager entityManager;

	public AbstractBO(Class<?> clazz) {
		this.clazz = clazz;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DsFoodParkingDB");
		entityManager = emf.createEntityManager();
	}

	/**
	 * Cria uma nova entidade na base de dados
	 * @param e Objeto a ser persistido
	 * @throws PersistenceException lancado caso o objeto não possa ser salvo
	 */
	public void create(E e) throws PersistenceException {
		this.validateCreate(e);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível incluir a entidade: " + e.toString() + ex);
		}
	}

	/**
	 * Cria uma nova entidade na base de dados
	 * @param e Objeto a ser persistido
	 * @throws PersistenceException lancado caso o objeto não possa ser salvo
	 */
	public E createReturnsEntity(E e) throws PersistenceException {
		this.validateCreate(e);
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(e);
			entityManager.flush();
			entityManager.getTransaction().commit();
			return e;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível incluir a entidade: " + e.toString() + ex);
		}
	}
	
	/**
	 * Exclui a entidade da base de dados
	 * @param e Entidade a ser excluida
	 * @throws PersistenceException lancado caso o objeto não possa ser excluido
	 */
	public void delete(E e) throws PersistenceException {
		this.validateDelete(e);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(e);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível excluir a entidade: " + e.toString() + ex);
		}
	}

	/**
	 * Exclui a entidade da base no ID
	 * @param e Entidade a ser excluida
	 * @throws PersistenceException lancado caso o objeto não possa ser excluido
	 */
	public void delete(Long Id) throws PersistenceException {
		E e = find(Id);
		this.validateDelete(e);
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.getReference(this.clazz, Id));
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível excluir a entidade: " + e.toString() + ex);
		}
	}

	/**
	 * Atualiza na base de dados uma entidade já existente
	 * @param e Objeto a ser atualizado
	 */
	public void update(E e) throws PersistenceException {
		this.validateDelete(e);
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(e);
			entityManager.flush();
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível atualizar a entidade: " + e.toString() + ex);
		}
	}

	/**
	 * Busca uma entidade pela chave primária
	 * @param id Chave do objeto a ser localizado
	 */
	@SuppressWarnings("unchecked")
	public E find(Long id) throws PersistenceException {
		E ret = null;
		try {
			ret = (E) entityManager.find(this.clazz, id);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new PersistenceException("Não foi possível encontrar a entidade: " + this.clazz.getSimpleName() + " com ID: " + id + " " + ex);
		}
		return ret;
	}


	/**
	 * Valida a possibilidade de ser inserida na base
	 * @param e Entidade a ser validada
	 * @throws PersistenceException lancado caso o objeto não possa ser criado
	 */
	protected void validateCreate(E e) throws PersistenceException {}

	/**
	 * Valida a possibilidade de ser atualizada na base
	 * @param e Entidade a ser validada
	 * @throws PersistenceException lancado caso o objeto não possa ser atualizado
	 */
	protected void validateUpdate(E e) throws PersistenceException {}

	/**
	 * Valida a possibilidade de ser excluida da base
	 * @param e Entidade a ser validada
	 * @throws PersistenceException lancado caso o objeto não possa ser excluida
	 */
	protected void validateDelete(E e) throws PersistenceException {}

}
