package dao.impl;

import dao.ProductDao;
import domain.impl.Product;
import org.hibernate.FlushMode;
import org.springframework.transaction.annotation.Transactional;
import util.CustomHibernateDaoSupport;

import java.util.List;

/**class ProductDaoImpl
 *
 * This class realise DAO layer to make connection
 * between database and plain Java classes
 *
 */
@Transactional
public class ProductDaoImpl extends CustomHibernateDaoSupport implements ProductDao {

    public ProductDaoImpl() {
    }

    @Transactional
    public void save(Product product){
      getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        getHibernateTemplate().save(product);
    }

    @Transactional
    public void update(Product product){
        getHibernateTemplate().update(product);
    }

    @Transactional
    public void delete(Product product){
        getHibernateTemplate().delete(product);
    }

    @Transactional
    public Product findByProductName(String name){
        List list = getHibernateTemplate().find("from Product where name=?",name);
        return (Product)list.get(0);
    }
}