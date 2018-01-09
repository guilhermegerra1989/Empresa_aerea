package br.com.guilherme.lemes.rest.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class PaginatedListDto<T> implements Serializable {

    private final Integer currentPage;
    private final Integer itemsPerPage;
    private final Long totalItems;
    private final List<T> items;

    public PaginatedListDto(Integer currentPage, Integer itemsPerPage, Long totalItems, List<T> items) {
        this.currentPage = currentPage;
        this.itemsPerPage = itemsPerPage;
        this.totalItems = totalItems;
        this.items = items;
    }

    public PaginatedListDto(List<T> items) {
        this.currentPage = null;
        this.itemsPerPage = null;
        this.totalItems = null;
        this.items = items;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getItemsPerPage() {
        return itemsPerPage;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public List<T> getItems() {
        return items;
    }

    public Long getTotalPages() {
        if (currentPage == null || itemsPerPage == null) {
            return 0l;
        } else {
            return (totalItems / itemsPerPage) + 1;
        }
    }

    @JsonProperty("paginated")
    public boolean isPaginated() {
        return true;
    }
}
