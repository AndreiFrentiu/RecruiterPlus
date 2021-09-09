package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Util.Interface.Dao.DaoInterfaceSupportClass;

public class DaoRecruiter implements DaoInterfaceSupportClass<Recruiter> {

	private Session session;
	private Transaction transaction;

	public DaoRecruiter(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
	}
	
	@Override
	public boolean save(Recruiter recruiter) {
		try {
			session.save(recruiter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Recruiter getById(int id) {
		Recruiter recruiter = session.get(Recruiter.class, id);
		return recruiter;
	}

	@Override
	public Recruiter getByName(String name) {
		Query<Recruiter> query = session.createQuery("from Recruiter where name = :parameter1");
		query.setParameter("parameter1", name);
		ArrayList<Recruiter> list = (ArrayList<Recruiter>) query.list();
		Recruiter recruiter = list.get(0);
		return recruiter;
	}

	@Override
	public List<Recruiter> getAll() {
		Query<Recruiter> query = session.createQuery("from Recruiter");
		ArrayList<Recruiter> recruiters = (ArrayList<Recruiter>) query.list();	
		return recruiters;
	}

	@Override
	public boolean delete(Recruiter recruiter) {
		Query query = session.createQuery("Delete from Recruiter where id = :par1");
		query.setParameter("par1", recruiter.getId());
		if(query.executeUpdate()==1) {
			return true;
		} else {
			return false;
		}
	}

}
