package projectRecruiterPlus.Util.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import projectRecruiterPlus.Entities.RecruiterRank;
import projectRecruiterPlus.Util.Interface.Dao.DaoInterfaceSupportClass;

public class DaoRecruiterRank implements DaoInterfaceSupportClass<RecruiterRank> {

	private Session session;
	private Transaction transaction;

	public DaoRecruiterRank(Session session, Transaction transaction) throws Exception {
		this.session = session;
		this.transaction = transaction;
	}
	
	@Override
	public boolean save(RecruiterRank rank) {
		try {
			session.save(rank);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public RecruiterRank getById(int id) {
		RecruiterRank rank = session.get(RecruiterRank.class, id);
		return rank;
	}

	@Override
	public RecruiterRank getByName(String name) {
		Query<RecruiterRank> query = session.createQuery("from RecruiterRank where name = :parameter1");
		query.setParameter("parameter1", name);
		ArrayList<RecruiterRank> list = (ArrayList<RecruiterRank>) query.list();
		RecruiterRank rank = list.get(0);
		return rank;
	}

	@Override
	public List<RecruiterRank> getAll() {
		Query<RecruiterRank> query = session.createQuery("from RecruiterRank");
		ArrayList<RecruiterRank> ranks = (ArrayList<RecruiterRank>) query.list();	
		return ranks;
	}

	@Override
	public boolean delete(RecruiterRank rank) {
		Query query = session.createQuery("Delete from RecruiterRank where id = :par1");
		query.setParameter("par1", rank.getId());
		if(query.executeUpdate()==1) {
			return true;
		} else {
			return false;
		}
	}

}
