package org.example.it210_ss13_hw04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MedicineRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Medicine> findExpiredMedicines(Date currentDate) {
        Session session = sessionFactory.getCurrentSession();

        String hql = "FROM Medicine m WHERE m.expiryDate < :currentDate";

        Query<Medicine> query = session.createQuery(hql, Medicine.class);
        query.setParameter("currentDate", currentDate);

        return query.getResultList();
    }
}
