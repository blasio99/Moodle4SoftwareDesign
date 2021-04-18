package dev.blasio99.moodle.server.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import dev.blasio99.moodle.server.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance, Long> {
	public List<Attendance> findByWeek(Integer week);
	public List<Attendance> findByUsername(String username);
	public Attendance findByUsernameAndWeek(String username, Integer week);
}
