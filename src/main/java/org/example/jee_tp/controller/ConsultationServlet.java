package org.example.jee_tp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.jee_tp.services.ConsultationService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="consultation", value="/consultations/*")
public class ConsultationServlet extends HttpServlet {
    private ConsultationService consultationService = new ConsultationService();
    PatientServlet patientServlet = new PatientServlet();

    @Override
    public void init() throws ServletException {
        System.out.println("Serveur lancé");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";
        switch (pathInfo) {
            case "/addconsultation":
                String date = request.getParameter("date");
                String doctor = request.getParameter("doctor");
                String instruction = request.getParameter("instruction");
                String caresheet = request.getParameter("caresheet");
                int id = Integer.parseInt(request.getParameter("id"));
                consultationService.addConsultation(LocalDate.parse(date), doctor, instruction, caresheet, id);
                response.sendRedirect(request.getContextPath()+"/patients");
        }
    }
}

