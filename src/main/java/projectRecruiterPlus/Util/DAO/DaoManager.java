package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import projectRecruiterPlus.Entities.Roles.Manager;
import projectRecruiterPlus.Entities.Roles.Recruiter;
import projectRecruiterPlus.Util.Interface.Dao.DaoInterfaceSupportClass;

public class DaoManager implements DaoInterfaceSupportClass<Manager>{

	private Session session;
	private Transaction transaction;

	public DaoManager(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
	}
	
	@Override
	public boolean save(Manager manager) {
		try {
			session.save(manager);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Manager getById(int id) {
		Manager manager = session.get(Manager.class, id);
		return manager;
	}

	@Override
	public Manager getByName(String name) {
		Query<Manager> query = session.createQuery("from Manager where name = :parameter1");
		query.setParameter("parameter1", name);
		ArrayList<Manager> list = (ArrayList<Manager>) query.list();
		Manager manager = list.get(0);
		return manager;
	}

	@Override
	public List<Manager> getAll() {
		Query<Manager> query = session.createQuery("from Manager");
		ArrayList<Manager> managers = (ArrayList<Manager>) query.list();	
		return managers;
	}

	@Override
	public boolean delete(Manager manager) {
		Query query = session.createQuery("Delete from Manager where id = :par1");
		query.setParameter("par1", manager.getId());
		if(query.executeUpdate()==1) {
			return true;
		} else {
			return false;
		}
	}

}
