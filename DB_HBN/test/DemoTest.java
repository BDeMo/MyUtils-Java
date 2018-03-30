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
    //����
    @Test
    public void insert() {
        DemoEntity ue = new DemoEntity();
        ue.setName("Anny");
        session.save(ue);
        tx.commit();
    }
    //�޸�
    @Test
    public void update() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(2));
        user.setName("Penny");
        session.update(user);
        tx.commit();
        session.close();
    }
    //����
    @Test
    public void getById() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(4));
        tx.commit();
        session.close();
        System.out.println("ID�ţ�" + user.getId() + "���û�����" + user.getName());
    }
    //ɾ��
    @Test
    public void delete() {
        DemoEntity user = (DemoEntity) session.get(DemoEntity.class, new Integer(5));
        session.delete(user);
        tx.commit();
        session.close();
    }
}
