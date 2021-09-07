package projectRecruiterPlus.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
@MappedSuperclass
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	protected int id;
	
	@Column
	protected int contactNumber;
	
	@Column
	protected String firstName;
	
	@Column
	protected String lastName;
	
	@Column
	protected String adress;
	
	@Column
	protected String email;
	
}
