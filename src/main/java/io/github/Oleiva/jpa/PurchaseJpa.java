package io.github.Oleiva.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.Oleiva.entity.ProductEntity;
import io.github.Oleiva.entity.PurchaseEntity;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

public interface PurchaseJpa extends JpaRepository<PurchaseEntity, Long> {

}
