package projectRecruiterPlus.Entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import projectRecruiterPlus.Util.Other.CandidateStatus;

/* Lombok */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

/* Hibernate */
@Entity
@Table
public class Candidate extends Person {

	//TODO realizeaza o metodata de a semnala un candidat angajat recent de companie
	@Column
	private String lastRole;

	@Column
	private String lastCompany;

	@Column
	private String description;
	
	@Column
	private String lastUserToEdit;
	
	@Column
	private String linkedInLink;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "canditate_status")
	private CandidateStatus status;
	
	@ManyToMany(mappedBy = "interactetCandidate")
	private List <Project> interactetProjects;
	
	@Nullable
	@OneToOne(mappedBy = "hiredCandidate")
	private Project acceptedRole;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Recruiter_Candidate", joinColumns = { @JoinColumn(name = "employee_id") }, inverseJoinColumns = {
			@JoinColumn(name = "candidate_id") })
	private List<User> userInteraction;
}
