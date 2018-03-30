import Mytraining.DataBase.DemoEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Before;
import org.junit.Test;

public class DemoTest {
    Configuration config = null;
    SessionFactory sessionFactory = null;
    Session session = null;
    Transaction tx = null;
    @Before
    public void init() {
        config = new Configuration().configure("/hibernate.cfg.xml");
        sessionFactory = config.buildSessionFactory();
        session = sessionFactory.openSession();
        tx = (Transaction) session.beginTransaction();
    }
    //增加
    @Test
    public void insert() {
        DemoEntity ue = new DemoEntity();
        ue.setName("Anny");
        session.save(ue);
        tx.commit();
    }
    //修改
    @Test
    public void update() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(2));
        user.setName("Penny");
        session.update(user);
        tx.commit();
        session.close();
    }
    //查找
    @Test
    public void getById() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(4));
        tx.commit();
        session.close();
        System.out.println("ID号：" + user.getId() + "；用户名：" + user.getName());
    }
    //删除
    @Test
    public void delete() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(5));
        session.delete(user);
        tx.commit();
        session.close();
    }
}
