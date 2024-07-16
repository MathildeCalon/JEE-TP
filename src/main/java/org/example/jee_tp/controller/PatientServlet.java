package org.example.jee_tp.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.jee_tp.model.Patient;
import org.example.jee_tp.services.ConsultationService;
import org.example.jee_tp.services.PatientService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;


@WebServlet(name="patient", value="/patients/*")
@MultipartConfig(maxFileSize = 1024*1024*10)
public class PatientServlet extends HttpServlet {
    private PatientService patientService;
    private ConsultationService consultationService;

    @Override
    public void init() throws ServletException {
        patientService = new PatientService();
        consultationService =  new ConsultationService();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";


        switch (pathInfo) {
            default:
                sendPatientList(request, response);

            case "/login":
                request.getRequestDispatcher("/login.jsp").forward(request, response);

            case "/addpatient":
                request.getRequestDispatcher("/addPatient.jsp").forward(request, response);

            case "/detail":
                int searchedPatient = Integer.parseInt(request.getParameter("id"));
                Patient patient = patientService.getPatient(searchedPatient);
                System.out.println(patient);
                request.setAttribute("patient", patient);
                request.getRequestDispatcher("/patientDetails.jsp").forward(request, response);

            case "/search":
                String searchedName = request.getParameter("search");
                System.out.println(searchedName);
                List<Patient> result = patientService.getPatientByName(searchedName);
                System.out.println("résultats :" + result);
                request.setAttribute("patient", result);
                request.getRequestDispatcher("/patients.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = (request.getPathInfo() != null && !request.getPathInfo().isEmpty()) ? request.getPathInfo() : "";
        switch (pathInfo) {
            case "/addpatient":
                String firstname = request.getParameter("firstname");
                String lastname = request.getParameter("lastname");
                String birthdate = request.getParameter("birthdate");
                Part picture = request.getPart("picture");
                String uploadPath = getServletContext().getRealPath("/")+"image";

                File file = new File(uploadPath);
                if(!file.exists()){
                    file.mkdir();
                }

                String fileName = picture.getSubmittedFileName();
                picture.write(uploadPath+File.separator+fileName);

                patientService.addPatient(firstname, lastname, LocalDate.parse(birthdate), fileName);
                sendPatientList(request, response);
            case "/addconsultation":
                String date = request.getParameter("date");
                String doctor = request.getParameter("doctor");
                String instruction = request.getParameter("instruction");
                String caresheet = request.getParameter("caresheet");
                int id = Integer.parseInt(request.getParameter("id"));

                consultationService.addConsultation(LocalDate.parse(date), doctor, instruction, caresheet, id);
                sendPatientList(request, response);
            case "/login":
                HttpSession session = request.getSession();
                String name = "admin";
                String password = "admin";
                String submittedName = request.getParameter("name");
                String submittedPassword = request.getParameter("password");
                if(name.equals(submittedName) && password.equals(submittedPassword)) {
                    session.setAttribute("isLogged", true);
                    sendPatientList(request, response);
                } else {
                    session.setAttribute("isLogged", false);
                    request.getRequestDispatcher("/login.jsp").forward(request, response);
                }
        }
    }

    public void sendPatientList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("patients", patientService.getAllPatients());
        request.getRequestDispatcher("/patients.jsp").forward(request, response);
    }
}
