package com.training.licenselifecycletracker.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.licenselifecycletracker.dto.DeviceDTO;
import com.training.licenselifecycletracker.dto.LifecycleEventDTO;
import com.training.licenselifecycletracker.dto.SoftwareDTO;
import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.LifecycleEvent;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.repositories.DeviceRepository;
import com.training.licenselifecycletracker.repositories.LifecycleEventRepository;
import com.training.licenselifecycletracker.repositories.SoftwareRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository deviceRepository;
    private final SoftwareRepository softwareRepository;
    private final LifecycleEventRepository lifecycleEventRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DeviceServiceImpl(DeviceRepository deviceRepository,
                             SoftwareRepository softwareRepository,
                             LifecycleEventRepository lifecycleEventRepository,
                             ModelMapper modelMapper) {
        this.deviceRepository = deviceRepository;
        this.softwareRepository = softwareRepository;
        this.lifecycleEventRepository = lifecycleEventRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public DeviceDTO addDevice(DeviceDTO deviceDTO) {
        Device device = modelMapper.map(deviceDTO, Device.class);
        Device savedDevice = deviceRepository.save(device);
        return modelMapper.map(savedDevice, DeviceDTO.class);
    }

    @Override
    @Transactional
    public DeviceDTO updateDevice(DeviceDTO deviceDTO) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceDTO.getDeviceId());
        if (optionalDevice.isPresent()) {
            Device deviceToUpdate = optionalDevice.get();
            modelMapper.map(deviceDTO, deviceToUpdate); // Update existing device entity
            deviceRepository.save(deviceToUpdate);
            return modelMapper.map(deviceToUpdate, DeviceDTO.class);
        } else {
            throw new RuntimeException("Device not found with id: " + deviceDTO.getDeviceId());
        }
    }

    @Override
    @Transactional(readOnly = true)
    public DeviceDTO getDeviceById(Integer deviceId) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
        return optionalDevice.map(device -> modelMapper.map(device, DeviceDTO.class)).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DeviceDTO> getAllDevices() {
        List<Device> devices = (List<Device>) deviceRepository.findAll();
        return devices.stream()
                .map(device -> modelMapper.map(device, DeviceDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteDevice(Integer deviceId) {
        deviceRepository.deleteById(deviceId);
    }

    @Override
    @Transactional
    public DeviceDTO addSoftwareToDevice(Integer deviceId, SoftwareDTO softwareDTO) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            Software software = modelMapper.map(softwareDTO, Software.class);
            software.setDevice(device);
            Software savedSoftware = softwareRepository.save(software);
            device.getSoftwareList().add(savedSoftware);
            deviceRepository.save(device);
            return modelMapper.map(device, DeviceDTO.class);
        } else {
            throw new RuntimeException("Device not found with id: " + deviceId);
        }
    }

    @Override
    @Transactional
    public DeviceDTO addLifecycleEventToDevice(Integer deviceId, LifecycleEventDTO lifecycleEventDTO) {
        Optional<Device> optionalDevice = deviceRepository.findById(deviceId);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            LifecycleEvent lifecycleEvent = modelMapper.map(lifecycleEventDTO, LifecycleEvent.class);
            lifecycleEvent.setDevice(device);
            LifecycleEvent savedLifecycleEvent = lifecycleEventRepository.save(lifecycleEvent);
            device.setLifecycleEvent(savedLifecycleEvent);
            deviceRepository.save(device);
            return modelMapper.map(device, DeviceDTO.class);
        } else {
            throw new RuntimeException("Device not found with id: " + deviceId);
        }
    }
}
