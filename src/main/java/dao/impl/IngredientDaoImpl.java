package dao.impl;
import dao.IngredientDao;
import domain.impl.Ingredient;
import org.hibernate.FlushMode;
import org.springframework.transaction.annotation.Transactional;
import util.CustomHibernateDaoSupport;

import java.util.List;

/**class IngredientDaoImpl
 *
 * This class realise DAO layer to make connection
 * between database and plain Java classes
 *
 */
@Transactional
public class IngredientDaoImpl extends CustomHibernateDaoSupport implements IngredientDao {

    @Transactional
    public void save(Ingredient ingredient) {
        getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(ingredient);
    }

    @Transactional
    public void update(Ingredient ingredient) {
        getHibernateTemplate().update(ingredient);
    }

    @Transactional
    public void delete(Ingredient ingredient) {
        getHibernateTemplate().delete(ingredient);
    }

    @Transactional
    public Ingredient findByIngredientName(String name) {
        List list = getHibernateTemplate().find("from Ingredient where name=?",name);
        return (Ingredient)list.get(0);
    }
}
