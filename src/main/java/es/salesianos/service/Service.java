package es.salesianos.service;

import java.util.List;

public interface Service<T> {

	public void insert(T t);

	public List<T> listAll();

	public void delete(String t);

}
