package com.berndbartholmei.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.berndbartholmei.app.EmployeeManager;
import com.berndbartholmei.app.model.AccessLevel;
import com.berndbartholmei.app.model.Employee;

/**
 * Servlet implementation class EmployeeManagerServlet
 */
@WebServlet("/EmployeeManagerServlet")
public class EmployeeManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public EmployeeManager employeeManager;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeManagerServlet() {
		super();

		employeeManager = new EmployeeManager();

		employeeManager.addEmployee(new Employee(1, 23, "John Doe", AccessLevel.NORMAL));
		employeeManager.addEmployee(new Employee(2, 29, "Ion Popescu", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(3, 18, "Gigel Minel", AccessLevel.EXTENDED));
		employeeManager.addEmployee(new Employee(5, 56, "John Donalescu", AccessLevel.ADMIN));
		employeeManager.addEmployee(new Employee(6, 40, "John Smith", AccessLevel.NORMAL));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		AccessLevel accessLevel = determineAccessLevel(request.getParameter("access"));

		employeeManager.addEmployee(new Employee(id, age, name, accessLevel));

		// Print employees
		PrintWriter writer = response.getWriter();
		for (Employee employee : employeeManager.getAllEmployees()) {
			writer.println(employee + "<br>");
		}
		writer.close();
	}

	private AccessLevel determineAccessLevel(String accessLevelString) {
		for (AccessLevel accessLevel : AccessLevel.values()) {
			if (accessLevel.toString().equals(accessLevelString)) {
				return accessLevel;
			}
		}
		return AccessLevel.NORMAL;
	}

}
