package com.training.licenselifecycletracker.service;

import com.training.licenselifecycletracker.dto.DeviceDTO;
import com.training.licenselifecycletracker.dto.LifecycleEventDTO;
import com.training.licenselifecycletracker.dto.SoftwareDTO;

import java.util.List;

public interface DeviceService {

    DeviceDTO addDevice(DeviceDTO deviceDTO);

    DeviceDTO updateDevice(DeviceDTO deviceDTO);

    DeviceDTO getDeviceById(Integer deviceId);

    List<DeviceDTO> getAllDevices();

    void deleteDevice(Integer deviceId);

    DeviceDTO addSoftwareToDevice(Integer deviceId, SoftwareDTO softwareDTO);

    DeviceDTO addLifecycleEventToDevice(Integer deviceId, LifecycleEventDTO lifecycleEventDTO);
}