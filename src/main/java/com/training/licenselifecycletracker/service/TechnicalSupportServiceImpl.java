package com.training.licenselifecycletracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.licenselifecycletracker.entities.RequestLog;
import com.training.licenselifecycletracker.repositories.RequestLogRepository;
@Service
public class TechnicalSupportServiceImpl implements TechnicalService{
	
	@Autowired
	RequestLogRepository requestLogRepository;

	@Override
	public List<RequestLog> getAllRequestLogs() {
		// TODO Auto-generated method stub
		return (List<RequestLog>) requestLogRepository.findAll();
	}
	
	
	

	

}
