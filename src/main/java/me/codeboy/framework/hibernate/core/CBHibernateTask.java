package me.codeboy.framework.hibernate.core;

import me.codeboy.framework.hibernate.util.CBHibernateSessionFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * hibernate控制执行,同步进行
 * <p/>
 * Created by yuedong.li on 11/6/15.
 */
public abstract class CBHibernateTask<T> {
    private T t;  //所需结果类型

    /**
     * 执行数据库操作
     * @param session db session
     * @return data
     */
    public abstract T doTask(Session session);

    /**
     * 执行成功时的操作
     *
     * @param t
     *         任务执行成功后的结果
     * @return 修改后的结果
     */
    public T onTaskSuccess(T t) {
        return t;
    }

    /**
     * 执行结束时的操作
     *
     * @param t
     *         任务执行结束后的结果
     * @return 最终的结果
     */
    public T onTaskEnd(T t) {
        return t;
    }

    /**
     * 执行失败时的操作
     * @param e exception
     * @return t
     */
    public T onTaskFailed(Exception e){
        return null;
    }

    /**
     * hibernate任务执行
     *
     * @return 执行结果
     */
    public T execute() {
        Session session = null;
        Transaction tx = null;
        try {
            session = CBHibernateSessionFactory.getInstance().openSession();
            tx = session.beginTransaction();
            t = doTask(session); //执行任务
            tx.commit();
            tx = null;
            t = onTaskSuccess(t); //成功的操作
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            t = onTaskFailed(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return onTaskEnd(t);
    }
}