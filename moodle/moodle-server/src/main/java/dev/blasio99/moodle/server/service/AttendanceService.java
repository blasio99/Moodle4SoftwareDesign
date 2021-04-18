package dev.blasio99.moodle.server.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.blasio99.moodle.server.exception.ServiceException;
import dev.blasio99.moodle.server.model.Attendance;
import dev.blasio99.moodle.server.repo.AttendanceRepository;

@Service
public class AttendanceService {
	
	@Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAttendanceByUsername(String username) {
        return attendanceRepository.findByUsername(username);
    }

    public List<Attendance> getAttendanceByWeek(Integer week) throws ServiceException {
		return attendanceRepository.findByWeek(week);
    }

    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

	public Attendance updateAttendance(Attendance attendance) throws ServiceException {
        Optional<Attendance> att = attendanceRepository.findById(attendance.getId());
        if (att == null) throw new ServiceException("Attendance does not exist!", HttpStatus.CONFLICT);
        return attendanceRepository.save(attendance);
    }

    public void deleteAttendance(String username, Integer week) {
        Attendance attendance = attendanceRepository.findByUsernameAndWeek(username, week);
        if (attendance == null) return;
        attendanceRepository.delete(attendance);
    }

	public List<Attendance> getMyAttendanceList(Authentication authentication){
		return attendanceRepository.findByUsername(authentication.getName());
	} 

}
