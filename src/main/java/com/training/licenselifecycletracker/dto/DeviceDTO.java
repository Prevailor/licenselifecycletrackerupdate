package com.training.licenselifecycletracker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeviceDTO {

    private Integer deviceId;
    private String deviceName;
    private String deviceType;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private LocalDate endOfSupportDate;
    private String status;
    private UserDTO user; // Representing UserDTO instead of User entity
    private List<SoftwareDTO> softwareList;
    private LifecycleEventDTO lifecycleEvent;

}
