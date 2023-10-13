package com.server.services

interface CrudService<T, ID> {
    fun findAll(): MutableList<T>;
    fun findById(id: ID): T;
    fun create(model: T): T;
    fun update(model: T): T;
    fun delete(id: ID);
}
