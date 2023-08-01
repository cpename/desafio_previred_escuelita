package com.cpena.previred.backend.apirest.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class ServiceTest {
	
	protected final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	
	protected Date getDate(int year, int month, int day) {
		return Date.from(LocalDate.of(year, month, month).atStartOfDay(ZoneId.systemDefault()).toInstant());
		
	}

}
