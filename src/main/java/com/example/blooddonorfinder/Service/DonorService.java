package com.example.blooddonorfinder.Service;

import com.example.blooddonorfinder.Entity.DonorEntity;
import com.example.blooddonorfinder.Repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    // Add Donor
    public DonorEntity addDonor(DonorEntity donor) {
        return donorRepository.save(donor);
    }

    // Get All Donors
    public List<DonorEntity> getAllDonors() {
        return donorRepository.findAll();
    }

    // Get Donor By ID
    public Optional<DonorEntity> getDonorById(Long id) {
        return donorRepository.findById(id);
    }

    // Search By Blood Group
    public List<DonorEntity> getDonorsByBloodGroup(String bloodGroup) {
        return donorRepository.findByBloodGroup(bloodGroup);
    }

    // Update Donor
    public DonorEntity updateDonor(Long id, DonorEntity donor) {
        donor.setId(id);
        return donorRepository.save(donor);
    }

    // Delete Donor
    public void deleteDonor(Long id) {
        donorRepository.deleteById(id);
    }
}
