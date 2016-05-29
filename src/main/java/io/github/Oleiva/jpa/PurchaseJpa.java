package io.github.Oleiva.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import io.github.Oleiva.entity.ProductEntity;
import io.github.Oleiva.entity.PurchaseEntity;

/**
 * Created by Oleh Ivashko on 27.05.2016.
 */

public interface PurchaseJpa extends JpaRepository<PurchaseEntity, Long> {

    @Query(value = findDataForLastNMonth, nativeQuery = true)
    List<PurchaseEntity> findDataForLastNMonth(long data_kon);
//    String findDataForLastNMonth = "SELECT FROM purchase where purchase_date > purchase_date";
//    String findDataForLastNMonth = "SELECT * FROM purchase WHERE local_date >= DATE_SUB(CURRENT_DATE, INTERVAL purchase_date MONTH)";
    String findDataForLastNMonth = "SELECT * FROM luxofttest.purchase WHERE local_date < CURRENT_DATE -  INTERVAL 1 MONTH";

//    List<PurchaseEntity> findByLocal_date(LocalDate local_date);

}
