package com.divergentsl.clinicmanagementsystem;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.clinicmanagementsystem.dao.AppointmentDao;
import com.divergentsl.clinicmanagementsystem.dto.AppointmentDto;

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
	 */

	public void bookedAppointment() {

		logger.debug(
				"--------------------------------------Appointment List---------------------------------------------");

		try {
			List<AppointmentDto> dtos = appointmentDao.read();
			logger.debug("\n");
			logger.debug(
					"Id                              Name               DoctorId                   Problem               DateofAppointment        Time\n");

			for (AppointmentDto appointmentDto : dtos) {
				System.out.printf(" %s %30s %20s  %28s %20s %25s ", appointmentDto.getAppointmentId(),
						appointmentDto.getPatientname(), appointmentDto.getDrId(), appointmentDto.getProblem(),
						appointmentDto.getAppointmentDate(), appointmentDto.getAppointmentTime());
				System.out.println("\n");

			}
			logger.debug(
					"-----------------------------------*---Appointment List---*--------------------------------------------------- ");
		} catch (SQLException e) {
			System.err.println(e);
			logger.debug("----------Can't read---------");
		}
	}

}
