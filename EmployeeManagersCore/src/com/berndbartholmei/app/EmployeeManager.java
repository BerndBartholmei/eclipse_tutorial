package com.berndbartholmei.app;

import java.util.ArrayList;
import java.util.List;

import com.berndbartholmei.app.model.AccessLevel;
import com.berndbartholmei.app.model.Employee;
import com.berndbartholmei.app.model.IEmployee;

/**
 * @author jupan
 */
public class EmployeeManager implements IEmployeeManager {

	protected List<IEmployee> employeeList = new ArrayList<IEmployee>();

	@Override
	public boolean addEmployee(IEmployee empl) {
		if (empl == null) {
			return false;
		} else if (employeeList.contains(empl)) {
			return false;
		} else {
			employeeList.add(empl);
			return true;
		}
	}

	@Override
	public boolean removeEmployee(IEmployee empl) {
		if (empl == null) {
			return false;
		} else if (!employeeList.contains(empl)) {
			return false;
		} else {
			employeeList.remove(empl);
			return true;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		for (IEmployee empl : employeeList) {
			employees.add((Employee) empl);
		}
		return employees;
	}

	@Override
	public List<IEmployee> getAllAdminLevel() {
		return getEmployessByLevel(AccessLevel.ADMIN);
	}

	@Override
	public List<IEmployee> getAllExtendedLevel() {
		return getEmployessByLevel(AccessLevel.EXTENDED);
	}

	@Override
	public List<IEmployee> getAllNormalLevel() {
		return getEmployessByLevel(AccessLevel.NORMAL);
	}

	@Override
	public boolean setAccessLevelOnEmployee(AccessLevel acc, IEmployee empl) {
		if (empl == null) {
			return false;
		} else if (empl.getAccessLevel().equals(acc)) {
			return false;
		} else {
			empl.setAccessLevel(acc);
			return true;
		}
	}

	private List<IEmployee> getEmployessByLevel(AccessLevel acc) {
		List<IEmployee> admins = new ArrayList<IEmployee>();
		for (IEmployee empl : employeeList) {
			if (empl.getAccessLevel().equals(acc)) {
				admins.add(empl);
			}
		}
		return admins;
	}

}
