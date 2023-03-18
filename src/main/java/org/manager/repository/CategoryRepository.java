package org.manager.repository;

import org.hibernate.Session;
import org.manager.DbConnection;
import org.manager.entity.Category;


public class CategoryRepository {
    public void insert(Category category) {
        Session session = DbConnection.getSession();
        session.getTransaction().begin();
        session.persist(category);
        session.getTransaction().commit();
        session.close();
    }

    public Category findByName(String categoryName) {
        Session session = DbConnection.getSession();
        Category category = session.createQuery("SELECT c FROM Category WHERE c.name=:categoryName", Category.class)
                .setParameter("categoryName", categoryName).uniqueResult();
        return category;
    }


}