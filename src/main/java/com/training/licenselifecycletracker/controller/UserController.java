package com.training.licenselifecycletracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.licenselifecycletracker.dto.DeviceDTO;
import com.training.licenselifecycletracker.dto.SoftwareDTO;
import com.training.licenselifecycletracker.service.DeviceService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final DeviceService deviceService;

    @Autowired
    public UserController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/devices/{userId}")
    public ResponseEntity<List<DeviceDTO>> getDevicesByUserId(@PathVariable Integer userId) {
        List<DeviceDTO> devices = deviceService.getDevicesByUserId(userId);
        if (!devices.isEmpty()) {
            return new ResponseEntity<>(devices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @GetMapping("/software/{deviceName}")
    public ResponseEntity<List<SoftwareDTO>> getSoftwareByDeviceName(@PathVariable String deviceName) {
        List<SoftwareDTO> software = deviceService.getSoftwareByDeviceName(deviceName);
        if (!software.isEmpty()) {
            return new ResponseEntity<>(software, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Add other controller methods as needed

}
