package projectRecruiterPlus.Entities;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import projectRecruiterPlus.Entities.Roles.CompanyRole;


//Lombok help
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

//Hibernate
@Entity
@Table
public class User extends Person {

	@Column(unique = true)
	private String username;
	
	@Column 
	private String password;
	
	@Column
	private LocalDate birthday;
	
	@Column
	private LocalDate firstDayWork;
	
	@Column
	@Nullable
	private LocalDate lastDayWork;
	
	@Column
	private boolean activeAccount;
	
	@Column
	private double grossSalary;
	
	@Column
	private double netSalary;
	
	@Column
	private int vacationDays;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private CompanyRole rol;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private TeamOfRecruitment team;
	
	@ManyToMany(mappedBy = "userInteraction")
	List<Candidate> candidateInteration;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.activeAccount=true;
		this.birthday=LocalDate.EPOCH;
		this.firstDayWork=LocalDate.EPOCH;
		this.lastDayWork=LocalDate.EPOCH;
	}

	public void setCompanyRole(CompanyRole role) {
		this.rol = role;
	}
	
	
	
	
	
	
}
