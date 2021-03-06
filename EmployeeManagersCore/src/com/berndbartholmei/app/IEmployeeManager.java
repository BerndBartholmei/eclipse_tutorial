package com.berndbartholmei.app;

import java.util.List;

import com.berndbartholmei.app.model.AccessLevel;
import com.berndbartholmei.app.model.Employee;
import com.berndbartholmei.app.model.IEmployee;

public interface IEmployeeManager {

	/**
	 * @param empl
	 * @return success of operation
	 */
	public boolean addEmployee(IEmployee empl);

	/**
	 * @param empl
	 * @return success of operation
	 */
	public boolean removeEmployee(IEmployee empl);

	/**
	 * @return all employees with ADMIN AccessLevel
	 */
	public List<Employee> getAllEmployees();

	/**
	 * @return all employees with ADMIN AccessLevel
	 */
	public List<IEmployee> getAllAdminLevel();

	/**
	 * @return all employees with EXTENDED AccessLevel
	 */
	public List<IEmployee> getAllExtendedLevel();

	/**
	 * @return all employees with NORMAL AccessLevel
	 */
	public List<IEmployee> getAllNormalLevel();

	/**
	 * @param acc
	 * @param empl
	 * @return success of operation
	 */
	public boolean setAccessLevelOnEmployee(AccessLevel acc, IEmployee empl);
}
