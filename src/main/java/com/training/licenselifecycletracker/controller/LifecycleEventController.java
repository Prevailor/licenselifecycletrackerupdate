//package com.training.licenselifecycletracker.controller;
//
//import com.training.licenselifecycletracker.dto.LifecycleEventDTO;
//import com.training.licenselifecycletracker.service.LifecycleEventService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/lifecycle-events")
//public class LifecycleEventController {
//
//    private final LifecycleEventService lifecycleEventService;
//
//    @Autowired
//    public LifecycleEventController(LifecycleEventService lifecycleEventService) {
//        this.lifecycleEventService = lifecycleEventService;
//    }
//
//    @PostMapping
//    public ResponseEntity<LifecycleEventDTO> addLifecycleEvent(@RequestBody LifecycleEventDTO lifecycleEventDTO) {
//        LifecycleEventDTO savedLifecycleEvent = lifecycleEventService.addLifecycleEvent(lifecycleEventDTO);
//        return new ResponseEntity<>(savedLifecycleEvent, HttpStatus.CREATED);
//    }
//
////    @PutMapping("/{eventId}")
////    public ResponseEntity<LifecycleEventDTO> updateLifecycleEvent(@PathVariable Integer eventId, @RequestBody LifecycleEventDTO lifecycleEventDTO) {
////        lifecycleEventDTO.setEventId(eventId);
////        LifecycleEventDTO updatedLifecycleEvent = lifecycleEventService.updateLifecycleEvent(lifecycleEventDTO);
////        return new ResponseEntity<>(updatedLifecycleEvent, HttpStatus.OK);
////    }
//
//    @GetMapping("/{eventId}")
//    public ResponseEntity<LifecycleEventDTO> getLifecycleEventById(@PathVariable Integer eventId) {
//        LifecycleEventDTO lifecycleEventDTO = lifecycleEventService.findLifecycleEventById(eventId);
//        return new ResponseEntity<>(lifecycleEventDTO, HttpStatus.OK);
//    }
//
//    // Other endpoints as needed
//}
