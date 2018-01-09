package br.com.guilherme.lemes.core.service;


import java.io.Serializable;
import java.util.List;

import br.com.guilherme.lemes.rest.domain.dto.PaginatedListDto;

public interface Service<E extends Serializable> {

    PaginatedListDto<E> getAllPaginated(Integer page, Integer itemsPerPage);

    E getById(Long id);

    E save(E entity);

    E update(E entity);

    void delete(Long id);

    List<E> getAllById(List<Long> equipmentIds);
}
