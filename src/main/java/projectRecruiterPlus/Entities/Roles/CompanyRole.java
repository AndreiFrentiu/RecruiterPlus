package projectRecruiterPlus.Entities.Roles;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import projectRecruiterPlus.Entities.User;

//lombok help
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//hibernate
@Entity(name = "companyRole")
@Table(name = "companyRole")
@DiscriminatorColumn(name = "CompanyRoleTag", discriminatorType = DiscriminatorType.STRING)
public class CompanyRole {
	
	@Id 
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;

	@Column(name = "RoleName")
	protected String name;
	
	@Column(name = "points")
	protected float points;
	
	@Column(name = "description")
	protected String description;
	
	@Column(name = "AccesLevel")
	protected int acessLevel;
	
	@OneToOne(cascade = CascadeType.ALL)
	protected User user;
}
