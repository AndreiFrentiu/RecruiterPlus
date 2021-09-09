package projectRecruiterPlus.Entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import projectRecruiterPlus.Entities.Roles.TeamLead;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "TeamOfRecruitment")
@Table(name = "TeamOfRecruitment")
public class TeamOfRecruitment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "team")
	private TeamLead teamLeader;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "team")
	private List<User> members;
	
	@Column(unique = true)
	private String name;
	
	@Column
	private String description;
	
	@Column
	private float semesterTarghet;
	
	@Column
	private Date birthday;
	
}
