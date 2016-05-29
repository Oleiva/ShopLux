package io.github.Oleiva.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

import io.github.Oleiva.entity.ProductEntity;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

public interface ProductJpa  extends JpaRepository<ProductEntity, Long> {

//
//    @Query(value = findDataForLastNMonth, nativeQuery = true)
//    List<ProductEntity> findDataForLastNMonth();
//    String findDataForLastNMonth = "SELECT PERIOD_ADD(Now, month) FROM purchase";
////

//select fio_work, date_uvolnenie from persona_stor where date_uvolnenie between :data_nach and :data_kon



//    findDataForLastNMonth
}
