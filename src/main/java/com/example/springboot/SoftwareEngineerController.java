package com.example.springboot;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/software-engineers")
public class SoftwareEngineerController {
    private final SoftwareEngineerService softwareEngineerService;

    public SoftwareEngineerController(SoftwareEngineerService softwareEngineerService) {
        this.softwareEngineerService = softwareEngineerService;
    }

    @GetMapping
    public List<SoftwareEngineer> getEngineers() {
        return softwareEngineerService.getAllSoftwareEngineers();
    }

    @GetMapping("{id}")
    public SoftwareEngineer getEngineerById(@PathVariable Integer id) {
        return softwareEngineerService.getSoftwareEngineerById(id);
    }

    @PostMapping
    public void AddNewSoftwareEngineer(@RequestBody SoftwareEngineer softwareEngineer) {
        softwareEngineerService.insertSoftwareEngineer(softwareEngineer);
    }

    @PutMapping("{id}")
    public void UpdateSoftwareEngineer(@PathVariable Integer id, @RequestBody SoftwareEngineer update) {
        SoftwareEngineer softwareEngineerUpdate = softwareEngineerService.getSoftwareEngineerById(id);

        if (softwareEngineerUpdate == null) {
            throw new RuntimeException("Software Engineer with id " + id + " is not found");
        }

//        softwareEngineerUpdate.setId(id);
        softwareEngineerUpdate.setName(update.getName());
        softwareEngineerUpdate.setTechStack(update.getTechStack());

        softwareEngineerService.updateSoftwareEngineers(softwareEngineerUpdate);
    }

    @DeleteMapping("{id}")
    public void deleteSoftwareEngineer(@PathVariable Integer id) {
        softwareEngineerService.deleteSoftwareEngineer(id);
    }
}
