package com.shinn.sneakersshop.converter;

public interface Converter<T, U> {
    public T toEntity(U dtoObject);
    public U toDto(T entity);
}
