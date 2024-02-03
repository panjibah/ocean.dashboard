package com.bca.ocean.dashboard.erates.repository;

import com.bca.ocean.dashboard.erates.model.entity.UserConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
 public interface UserDashboardConfigRepository extends JpaRepository<UserConfig,Long> {

 Optional<UserConfig> findByUserIdAndCorporateId(String userId, String corporateId);

}
