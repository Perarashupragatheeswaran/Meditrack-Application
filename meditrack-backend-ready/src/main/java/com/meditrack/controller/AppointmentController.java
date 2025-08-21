package com.meditrack.controller;

import com.meditrack.model.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    private final List<Appointment> appointments = new ArrayList<>();

    @PostMapping("/book")
    public ResponseEntity<Appointment> book(@RequestBody Appointment appointment) {
        appointments.add(appointment);
        return ResponseEntity.ok(appointment);
    }

    @GetMapping("/doctor/{name}")
    public ResponseEntity<List<Appointment>> byDoctor(@PathVariable("name") String doctorName) {
        List<Appointment> result = appointments.stream()
                .filter(a -> a.getDoctorName() != null && a.getDoctorName().equalsIgnoreCase(doctorName))
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }
}
