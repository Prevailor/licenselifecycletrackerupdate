package com.training.licenselifecycletracker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.licenselifecycletracker.dto.DeviceDTO;
import com.training.licenselifecycletracker.dto.SoftwareDTO;
import com.training.licenselifecycletracker.entities.Device;
import com.training.licenselifecycletracker.entities.RequestLog;
import com.training.licenselifecycletracker.entities.Software;
import com.training.licenselifecycletracker.repositories.DeviceRepository;
import com.training.licenselifecycletracker.repositories.LifecycleEventRepository;
import com.training.licenselifecycletracker.repositories.RequestLogRepository;
import com.training.licenselifecycletracker.repositories.SoftwareRepository;
import com.training.licenselifecycletracker.repositories.UserRepository;
@Service
public class RegularUserServiceImpl implements RegularUserService {

	@Autowired
    DeviceRepository deviceRepository;
    
    @Autowired
    SoftwareRepository softwareRepository;
    
    @Autowired
    LifecycleEventRepository lifecycleEventRepository;
    
    @Autowired
    ModelMapper modelMapper;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
	RequestLogRepository requestrepo;
	
	
	@Override
    @Transactional(readOnly = true)
    public List<DeviceDTO> getDevicesByUserId(Integer userId) {
        List<Device> devices = deviceRepository.findByUserUserId(userId);
        return devices.stream()
                .map(device -> modelMapper.map(device, DeviceDTO.class))
                .collect(Collectors.toList());
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<SoftwareDTO> getSoftwareByDeviceName(String deviceName) {
        List<Software> softwareList = softwareRepository.findByDeviceDeviceName(deviceName);
        return softwareList.stream()
                .map(software -> modelMapper.map(software, SoftwareDTO.class))
                .collect(Collectors.toList());
    }
    
    
    
    @Override
	public String requestRenew(SoftwareDTO softwareDTO) {
		RequestLog requestLog=new RequestLog();
		
		requestLog.setType("Renew");
		requestLog.setAssetid(softwareDTO.getSoftwareId());
		requestLog.setItem(softwareDTO.getSoftwareName());
		requestLog.setDetails(softwareDTO.getVersion());
		requestLog.setRequestDate(LocalDate.now());
		
		requestrepo.save(requestLog);
		
		return "Renewal Request send  succesfully";
	}

}
