package com.example.blooddonorfinder.Repository;


import com.example.blooddonorfinder.Entity.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DonorRepository extends JpaRepository<DonorEntity, Long> {

    List<DonorEntity> findByBloodGroup(String bloodGroup);

}