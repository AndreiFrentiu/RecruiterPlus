package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import projectRecruiterPlus.App;
import projectRecruiterPlus.Entities.TeamOfRecruitment;
import projectRecruiterPlus.Entities.User;
import projectRecruiterPlus.Entities.Roles.CompanyRole;
import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Util.Interface.DaoInterfaceUser;
import projectRecruiterPlus.Util.Other.CompanyRoleType;
import projectRecruiterPlus.Util.Other.EncryptPassword;

public class DaoUser implements DaoInterfaceUser {

	private Session session;
	private Transaction transaction;
	private EncryptPassword encryptPass;

	// We create a object with the parameters for easy-use of the Session and
	// Transaction to make the program run faster
	public DaoUser(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
		this.encryptPass = new EncryptPassword();
	}

	@Override
	public User getById(int id) {
		User user = session.get(User.class, id);
		user.setPassword(encryptPass.decrypt(user.getPassword()));
		return user;
	}
	
	@Override
	public User getbyUsername(String username) {
		Query<User> query = session.createQuery("from User where username = :parameter1");
		query.setParameter("parameter1", username);
		ArrayList<User> list = (ArrayList<User>) query.list();
		User user = list.get(0);
		user.setPassword(encryptPass.decrypt(user.getPassword()));
		return user;
	}

	// Verify if the user exists in the database
	// Returns false is the name is used
	@Override
	public boolean verifyIfExists(User user) {
		Query<User> query = session.createQuery("from User where username = :parameter1");
		query.setParameter("parameter1", user.getUsername());
		ArrayList<User> list = (ArrayList<User>) query.list();
		if (list.size() == 1)
			return true;
		return false;
	}

	// delete user
	@Override
	public void deleteUser(User user) {
		Query<User> query = session.createQuery("delete from User where username=:par1");
		query.setParameter("par1", user.getUsername());
		query.executeUpdate();
		transaction.commit();
	}

//<Password management>
	// Change password
	// Return true if the password was chanced
	@Override
	public boolean changePassword(User user, String newPassword) {
		if (verifyPassword(user)) {
			Query<User> query = session
					.createQuery("update User set password=:par1 where username =:par2 and password =:par3");
			query.setParameter("par1", incriptPassword(newPassword));
			query.setParameter("par2", user.getUsername());
			query.setParameter("par3", incriptPassword(user.getPassword()));
			query.executeUpdate();
			return true;
		}
		return false;
	}

	// Verify if the player has this password
	// Returns true if the password and the user are good
	@Override
	public boolean verifyPassword(User user) {
		Query<User> query = session.createQuery("from User where username = :parameter1 and password = :parameter2");
		query.setParameter("parameter1", user.getUsername());
		query.setParameter("parameter2", encryptPass.encrypt(user.getPassword()));
		ArrayList<User> list = (ArrayList<User>) query.list();
		if (list.size() != 1)
			return false;
		else {
			return true;
		}
	}

	// save the user to the database
	@Override
	public void save(User user) throws Exception {
		String toEncrypt = user.getPassword();
		user.setPassword(incriptPassword(toEncrypt));
		session.save(user);
	}

	private String incriptPassword(String pass) {
		return encryptPass.encrypt(pass);
	}

//</Password management>
	@Override
	public List<User> getAll() {
		Query<User> query = session.createQuery("from User");
		ArrayList<User> list = (ArrayList<User>) query.list();
		for (User user : list) {
			user.setPassword(encryptPass.decrypt(user.getPassword()));
		}
		return list;
	}

	@Override
	public List<User> getByCompanyRole(CompanyRoleType role) {
		Query<User> query;
		if (role.equals(CompanyRoleType.APPADMIN)) {
			query = session.createQuery("from AppAdmin");
			System.out.println("Admin");
		} else if (role.equals(CompanyRoleType.MANAGER)) {
			query = session.createQuery("from Manager");
			System.out.println("Manager");
		} else if (role.equals(CompanyRoleType.RECRUITER)) {
			query = session.createQuery("from Recruiter");
			System.out.println("Recruiter");
		} else if (role.equals(CompanyRoleType.TEAMLEAD)) {
			query = session.createQuery("from Teamlead");
			System.out.println("Teamlead");
		} else {
			query = session.createQuery("from Customrole");
			System.out.println("CustomRole");
		}
		List<User> list = query.list();
		for (User user : list) {
			user.setPassword(encryptPass.decrypt(user.getPassword()));
		}
		return list;
	}

	@Override
	public List<User> getTeamOfRecruitment(String teamName) {
		Query<User> query = session.createQuery("from TeamOFRecruitment where ");
		ArrayList<User> list = (ArrayList<User>) query.list();
		for (User user : list) {
			user.setPassword(encryptPass.decrypt(user.getPassword()));
		}
		return list;
	}

	@Override
	public boolean updateUsername(User user, String username) {
		if (verifyPassword(user)) {
			Query<User> query = session
					.createQuery("update User set username=:par1 where username = :par2 and password = :par3");
			query.setParameter("par1", username);
			query.setParameter("par2", user.getUsername());
			query.setParameter("par3", incriptPassword(user.getPassword()));
			query.executeUpdate();
			return true;
		}
		return false;
	}

	@Override
	public boolean promote(User u, CompanyRole role) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean terminate(User u, Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDetails(User u, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
