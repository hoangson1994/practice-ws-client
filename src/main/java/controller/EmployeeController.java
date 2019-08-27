package controller;

import mypackage.Employee;
import mypackage.EmployeeService;
import mypackage.EmployeeServiceServiceLocator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(EmployeeController.class.getSimpleName());

    private static EmployeeServiceServiceLocator locator = new EmployeeServiceServiceLocator();
    private static EmployeeService service;

    static {
        try {
            if (service == null) {
                service = locator.getEmployeeServicePort();
            }
        } catch (javax.xml.rpc.ServiceException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("create") && req.getParameter("id") != null) {
            String id = req.getParameter("id");
            Employee employee = service.getById(Long.parseLong(id));
            LOGGER.log(Level.INFO, String.format("Content: %s", employee.getName()));

            req.setAttribute("employee", employee);
            req.getRequestDispatcher("create.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("create")) {
            req.getRequestDispatcher("create.jsp").forward(req, resp);
        } else if (req.getRequestURI().contains("list")) {
            Employee[] employees = service.getListEmloyees();
            req.setAttribute("employees", employees);
            req.getRequestDispatcher("list.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getRequestURI().contains("create")) {
            String name = req.getParameter("name");
            String salary = req.getParameter("salary");
            Employee employee = new Employee();
            employee.setName(name);
            employee.setSalary(Long.parseLong(salary));
            Employee employee1 = service.createEmployee(employee);
            if (employee1 == null) {
                resp.sendError(400, "Bad request");
            } else {
                Employee[] employees =  service.getListEmloyees();
                req.setAttribute("employees", employees);
                req.getRequestDispatcher("list.jsp").forward(req, resp);
            }
        }
    }
}
