package com.training.licenselifecycletracker.service;

import java.util.List;

import com.training.licenselifecycletracker.entities.RequestLog;

public interface TechnicalService {
	
	List<RequestLog> getAllRequestLogs();

}
