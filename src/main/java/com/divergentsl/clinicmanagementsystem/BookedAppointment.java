package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;

/**
 * This class will access by doctor where they can see their appointments.
 * 
 * @author Jayant
 *
 */
@Component
public class BookedAppointment {

	private static Logger logger = LoggerFactory.getLogger(BookedAppointment.class);
	@Autowired
	private AppointmentDao appointmentDao;

	/**
	 * By this method i.e. bookedAppointment doctor will see the appointment booked
	 * for his/her.
	 * 
	 * @throws SQLException
	 */

	public void bookedAppointment() throws SQLException {

		logger.debug(
				"--------------------------------------Appointment List---------------------------------------------");

		List<Map<String, Object>> list = appointmentDao.read();
		if (list != null) {
			for (Map<String, Object> map : list) {
				for (Entry<String, Object> get : map.entrySet()) {

					System.out.printf("%15s", get.getValue());

				}
				logger.info("\n");
			}
		}
	}
}
