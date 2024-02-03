package com.bca.ocean.dashboard.erates.repository;

import com.bca.ocean.dashboard.erates.model.dto.EratesDto;
import com.bca.ocean.dashboard.erates.model.entity.Erate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ErateRepository extends JpaRepository<Erate,String> {
    @Query("SELECT e FROM Erate e WHERE e.updateDate = (SELECT MAX(er.updateDate) FROM Erate er WHERE er.currency = e.currency)")
    List<Erate> findLatestDataForEachCurrency();

}
