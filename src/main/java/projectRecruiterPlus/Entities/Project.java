package projectRecruiterPlus.Entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

/* Lombok */
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter

/* Hibernate */
@Entity
@Table(name = "project")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@Column
	private String name;
	
	@Column
	private String department;
	
	@Column
	private String city;
	
	@Column
	private String description;
	
	@Column
	private float points;
	
	@Column
	private int budget;
	
	@Column
	private Date startDate;
	
	@Column
	private Date endDate;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Project_Candidate", joinColumns = { @JoinColumn(name = "project_id") }, inverseJoinColumns = {
			@JoinColumn(name = "candidate_id") })
	private List <Candidate> interactetCandidate;
	
	@Nullable
	@OneToOne(cascade = CascadeType.ALL)	
	private Candidate hiredCandidate;
	
}
