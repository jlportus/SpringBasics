package es.mde.SpringBasics.entidades.selfJoin;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmpleadoConEmpleado {

	@Id
	@Column(name = "EMPLOYEE_ID")
	@GeneratedValue
	private UUID employeeId;

	@Column(name = "FIRSTNAME")
	private String firstname;

	@Column(name = "LASTNAME")
	private String lastname;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "manager_id")
	private EmpleadoConEmpleado manager;

	@OneToMany(mappedBy = "manager")
	private Set<EmpleadoConEmpleado> subordinates = new HashSet<EmpleadoConEmpleado>();

	public UUID getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(UUID employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public EmpleadoConEmpleado getManager() {
		return manager;
	}

	public void setManager(EmpleadoConEmpleado manager) {
		this.manager = manager;
	}

	public Set<EmpleadoConEmpleado> getSubordinates() {
		return subordinates;
	}

	public void setSubordinates(Set<EmpleadoConEmpleado> subordinates) {
		this.subordinates = subordinates;
	}

	public EmpleadoConEmpleado() {
	}

	public EmpleadoConEmpleado(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

}
