package org.example.jee_tp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee_tp.services.PatientService;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name="patient", value="/patients")
public class PatientServlet extends HttpServlet {
    private PatientService patientService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
//        patientService.addPatient("Mathilde", "Calon", LocalDate.parse("1992-03-31"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        switch (pathInfo) {
            case "":
                request.setAttribute("patients", patientService.getAllPatients());
                request.getRequestDispatcher("/patients.jsp").forward(request, response);
        }
    }
}
