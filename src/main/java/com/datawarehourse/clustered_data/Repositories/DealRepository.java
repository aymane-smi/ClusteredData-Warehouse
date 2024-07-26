package com.datawarehourse.clustered_data.Repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.datawarehourse.clustered_data.Models.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, String>{}