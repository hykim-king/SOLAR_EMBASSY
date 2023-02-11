package com.community.solar_embassy.mapper;

import com.community.solar_embassy.dto.PagingDto;

import java.util.List;

public interface CRUD<T,P> {
    List<T> findAll();
    List<T> findPaging(PagingDto paging) ;
    int count(PagingDto paging);
    T findById(P id);
    int deleteById(P id);
    int update(T dto);
    int insert(T dto);
}
