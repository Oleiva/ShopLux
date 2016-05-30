package io.github.Oleiva.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

import io.github.Oleiva.entity.ProductEntity;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

public interface ProductJpa extends JpaRepository<ProductEntity, Long> {

    Collection<ProductEntity> findByName(String Name);
}
