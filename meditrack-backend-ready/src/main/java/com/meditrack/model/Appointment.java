package com.meditrack.model;

import java.util.UUID;

public class Appointment {
    private String id;
    private String patientName;
    private String doctorName;
    private String date; // yyyy-MM-dd
    private String time; // HH:mm
    private String status; // BOOKED

    public Appointment() {
        this.id = UUID.randomUUID().toString();
        this.status = "BOOKED";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getPatientName() { return patientName; }
    public void setPatientName(String patientName) { this.patientName = patientName; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    public void setTime(String time) { this.time = time; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
