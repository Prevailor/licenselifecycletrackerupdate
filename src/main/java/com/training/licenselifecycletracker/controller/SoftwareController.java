//package com.training.licenselifecycletracker.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.training.licenselifecycletracker.dto.SoftwareDTO;
//import com.training.licenselifecycletracker.service.SoftwareService;
//
//@RestController
//@RequestMapping("/api/software")
//public class SoftwareController {
//
//    private final SoftwareService softwareService;
//
//    @Autowired
//    public SoftwareController(SoftwareService softwareService) {
//        this.softwareService = softwareService;
//    }
//
//    @PostMapping
//    public ResponseEntity<SoftwareDTO> addSoftware(@RequestBody SoftwareDTO softwareDTO) {
//        SoftwareDTO savedSoftware = softwareService.addSoftware(softwareDTO);
//        return new ResponseEntity<>(savedSoftware, HttpStatus.CREATED);
//    }
//
////    @PutMapping("/{softwareId}")
////    public ResponseEntity<SoftwareDTO> updateSoftware(@PathVariable Integer softwareId, @RequestBody SoftwareDTO softwareDTO) {
////        softwareDTO.setSoftwareId(softwareId);
////        SoftwareDTO updatedSoftware = softwareService.updateSoftware(softwareDTO);
////        return new ResponseEntity<>(updatedSoftware, HttpStatus.OK);
////    }
//
//    @GetMapping("/{softwareId}")
//    public ResponseEntity<SoftwareDTO> getSoftwareById(@PathVariable Integer softwareId) {
//        SoftwareDTO softwareDTO = softwareService.findSoftwareById(softwareId);
//        return new ResponseEntity<>(softwareDTO, HttpStatus.OK);
//    }
//
//    // Other endpoints as needed
//}
//
//
