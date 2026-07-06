package com.example.blooddonorfinder.Controller;

import com.example.blooddonorfinder.Entity.DonorEntity;
import com.example.blooddonorfinder.Service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    // Add Donor
    @PostMapping
    public DonorEntity addDonor(@RequestBody DonorEntity donor) {
        return donorService.addDonor(donor);
    }

    // Get All Donors
    @GetMapping
    public List<DonorEntity> getAllDonors() {
        return donorService.getAllDonors();
    }

    // Get Donor By ID
    @GetMapping("/{id}")
    public Optional<DonorEntity> getDonorById(@PathVariable Long id) {
        return donorService.getDonorById(id);
    }

    // Search By Blood Group
    @GetMapping("/blood/{bloodGroup}")
    public List<DonorEntity> getDonorsByBloodGroup(@PathVariable String bloodGroup) {
        return donorService.getDonorsByBloodGroup(bloodGroup);
    }

    // Update Donor
    @PutMapping("/{id}")
    public DonorEntity updateDonor(@PathVariable Long id,
                                   @RequestBody DonorEntity donor) {
        return donorService.updateDonor(id, donor);
    }

    // Delete Donor
    @DeleteMapping("/{id}")
    public String deleteDonor(@PathVariable Long id) {
        donorService.deleteDonor(id);
        return "Donor deleted successfully!";
    }
}