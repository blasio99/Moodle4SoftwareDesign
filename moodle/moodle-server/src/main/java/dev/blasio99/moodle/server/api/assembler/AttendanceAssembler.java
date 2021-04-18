package dev.blasio99.moodle.server.api.assembler;

import org.springframework.stereotype.Component;

import dev.blasio99.moodle.common.dto.AttendanceDTO;
import dev.blasio99.moodle.server.enums.Status;
import dev.blasio99.moodle.server.model.Attendance;

@Component
public class AttendanceAssembler implements BaseAssembler<AttendanceDTO, Attendance> {

	@Override
	public Attendance createModel(AttendanceDTO dto) {
		Attendance attendance = new Attendance();
        attendance.setId(dto.getId());
		attendance.setUsername(dto.getUsername());
        attendance.setWeek(dto.getWeek());
        attendance.setStatus(Status.valueOf(dto.getStatus()));
		return attendance;
	}

	@Override
	public AttendanceDTO createDTO(Attendance model) {
		AttendanceDTO dto = new AttendanceDTO();
		dto.setId(model.getId());
		dto.setUsername(model.getUsername());
        dto.setWeek(model.getWeek());
        dto.setStatus(model.getStatus().name());
		return null;
	}
}
