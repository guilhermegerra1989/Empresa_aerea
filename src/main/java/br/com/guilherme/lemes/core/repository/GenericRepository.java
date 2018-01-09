package br.com.guilherme.lemes.core.repository;

import java.io.Serializable;
import java.util.List;

import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;

public interface GenericRepository<E extends Serializable> {

    List<E> findAll();

    PaginatedListDto<E> findAllPaginated(Integer page, Integer amount);

    E findById(Long id);

    E save(E entity);

    E update(E entity);

    void deleteById(Long id);

    void delete(E entity);

    List<E> findAllById(List<Long> equipmentIds);

 	E getBySerialNumber(String serialNumber);

}
