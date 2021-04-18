package dev.blasio99.moodle.server.api.resource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.blasio99.moodle.common.dto.AttendanceDTO;
import dev.blasio99.moodle.server.api.assembler.AttendanceAssembler;
import dev.blasio99.moodle.server.model.Attendance;
import dev.blasio99.moodle.server.service.AttendanceService;


@CrossOrigin("*")
@RestController
public class AttendanceResource {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private AttendanceAssembler attendanceAssembler;

	
    @GetMapping("teacher/api/attendance/week/{week}")
    public List<AttendanceDTO> getAttendanceByWeek(@PathVariable Integer week) {
        return attendanceAssembler.createDTOList(attendanceService.getAttendanceByWeek(week));
    }

    @GetMapping("teacher/api/attendance/user/{username}")
    public List<AttendanceDTO> getAttendanceByUsername(@PathVariable String username) {
        return attendanceAssembler.createDTOList(attendanceService.getAttendanceByUsername(username));
    }

    @PostMapping("teacher/api/attendance/add")
    public Attendance addAttendance(@RequestBody AttendanceDTO dto) {
        return attendanceService.addAttendance(attendanceAssembler.createModel(dto));
    }

	@GetMapping("teacher/api/attendance/all")
	public List<AttendanceDTO> getAllAttendance() {

		List<AttendanceDTO> list = new ArrayList<>();
		
		for(Integer week = 0; week < 14; ++week){
			List<AttendanceDTO> validList = attendanceAssembler.createDTOList(attendanceService.getAttendanceByWeek(week));
			if(!validList.isEmpty())
				list = Stream.concat(list.stream(), validList.stream()).collect(Collectors.toList());
		}
        return list;
    }

	@GetMapping("/api/attendance")
	public List<Attendance> getMyAttendanceList(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return attendanceService.getMyAttendanceList(authentication);
	}
	

}
