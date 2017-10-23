package dao.impl;

import dao.DishDao;
import domain.impl.Dish;
import org.hibernate.FlushMode;
import org.springframework.transaction.annotation.Transactional;
import util.CustomHibernateDaoSupport;

import java.util.List;

/**class DishDaoImpl
 *
 * This class realise DAO layer to make connection
 * between database and plain Java classes
 *
 */

@Transactional
public class DishDaoImpl extends CustomHibernateDaoSupport implements DishDao {

    @Transactional
    public void save(Dish dish) {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.COMMIT);
        getHibernateTemplate().save(dish);
    }

    @Transactional
    public void update(Dish dish) {
        getHibernateTemplate().update(dish);
    }

    @Transactional
    public void delete(Dish dish) {
        getHibernateTemplate().delete(dish);
    }

    @Transactional
    public Dish findByDishName(String name) {
        List list = getHibernateTemplate().find("from Dish where name=?",name);
        return (Dish)list.get(0);
    }
}
