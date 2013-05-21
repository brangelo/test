package com.fhoster.test.client.view.grid;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Widget;

public class _DataGrid{

	private DataGrid<Employee> dataGrid;
	
	private static class Employee {
		private final String firstName;
		private final String lastName;

		public Employee(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
	}

	// The list of data to display.
	private static List<Employee> EMPLOYEES = Arrays.asList(
			new Employee("John", "Smith"), 
			new  Employee("Mary", "Lawyer"), 
			new Employee("Pippo", "Smith"), 
			new  Employee("Bella", "Lawyer"), 
			new Employee("John", "Smith"), 
			new  Employee("Mary", "Lawyer"), 
			new Employee("Pippo", "Smith"), 
			new  Employee("Bella", "Lawyer"), 
			new Employee("John", "Smith"), 
			new  Employee("Mary", "Lawyer"), 
			new Employee("Pippo", "Smith"), 
			new  Employee("Bella", "Lawyer"), 
			new  Employee("Zander", "Pod"));

	public _DataGrid() {

		// Create a CellTable.
		dataGrid = new DataGrid<Employee>();

		// Create firstName column.
		TextColumn<Employee> firstNameColumn = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee employee) {
				return employee.firstName;
			}
		};

		// Make the name column sortable.
		firstNameColumn.setSortable(true);
		dataGrid.addColumn(firstNameColumn, "First Name");

		// Create lastName column.
		TextColumn<Employee> lastNameColumn = new TextColumn<Employee>() {
			@Override
			public String getValue(Employee employee) {
				return employee.lastName;
			}
		};
		dataGrid.addColumn(lastNameColumn, "Last Name");

		dataGrid.setRowCount(EMPLOYEES.size(), true);
		dataGrid.setRowData(0, EMPLOYEES);

		dataGrid.setWidth("100%");
		dataGrid.setHeight("300px");
	}
	
	public Widget asWidget(){
		return dataGrid;
	}

}
