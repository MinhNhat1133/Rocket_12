package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DepartmentDTO;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DepartmentRepository {

	private HibernateUtils hibernateUtils;

	public DepartmentRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
//	public List<Department> getAllDepartments() {
//
//		Session session = null;
//
//		try {
//			// get session
//			session = hibernateUtils.openSession();
//
//			// create hql query
//			Query<Department> query = session.createQuery("FROM Department ");
//
//			return query.list();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
	// Method sẽ return ra object departmentDTO chỉ chứa 3 field: id, name
//	public List<DepartmentDTO> getAllDepartments() {
//
//		Session session = null;
//
//		try {
//			// get session
//			session = hibernateUtils.openSession();
//
//			// create hql query
//			Query<DepartmentDTO> query = session.createQuery("SELECT NEW com.vti.entity.DepartmentDTO(d.id,d.name) FROM Department d  ORDER BY d.id");
//
//			return query.list();
//
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
	// Có 1 thể sort được theo field name
	// Có tham số pageNumber và pageSize để cho phép người dùn có thể paging
	// Có thể search theo field name
	public List<DepartmentDTO> getAllDepartments(int pageNumber, int pageSize) {

		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DepartmentDTO> query = session.createQuery(
					"SELECT NEW com.vti.entity.DepartmentDTO(d.id,d.name) FROM Department d  ORDER BY d.name");
			query.setFirstResult(pageNumber * pageSize + 1);
			query.setMaxResults(pageSize);
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	//Có thể search theo field namer
	@SuppressWarnings("unchecked")
	public List<DepartmentDTO> getAllDepartmentsBYyfieldName(String name) {

		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<DepartmentDTO> query = session.createQuery(
					"SELECT NEW com.vti.entity.DepartmentDTO(d.id,d.name) FROM Department d WHERE name LIKE  :namee ");
			query.setParameter("namee", "%" + name + "%");
			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	@SuppressWarnings("unchecked")
	public int getTotalCount() {

		Session session = null;

		try {
			// get session
			session = hibernateUtils.openSession();

			// create hql query

			Query<DepartmentDTO> query = session.createQuery(
					"SELECT NEW com.vti.entity.DepartmentDTO(d.id,d.name) FROM Department d ");
			return query.list().size();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Department getDepartmentByID(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get department by id
			Department department = session.get(Department.class, id);

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Department getDepartmentByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Department> query = session.createQuery("FROM Department WHERE name = :nameParameter");

			// set parameter
			query.setParameter("nameParameter", name);

			// get result
			Department department = query.uniqueResult();

			return department;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// create
			session.save(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(int id, String newName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// update
			department.setName(newName);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateDepartment(Department department) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// update
			session.update(department);

			session.getTransaction().commit();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteDepartment(int id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get department
			Department department = (Department) session.load(Department.class, id);

			// delete
			session.delete(department);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isDepartmentExistsByID(int id) {

		// get department
		Department department = getDepartmentByID(id);

		// return result
		if (department == null) {
			return false;
		}

		return true;
	}

	public boolean isDepartmentExistsByName(String name) {
		Department department = getDepartmentByName(name);

		if (department == null) {
			return false;
		}
		return true;
	}

}
