package hiber.service;


import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;

import org.hibernate.Session;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void add(Car car) {
        userDao.add(car);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }




    public static void getUsersByCar() {
        Session session = null;
        session.getSessionFactory().openSession();
        String hql = "FROM Car where model=:model and series=:series";
        Car car =  session.createQuery(hql, Car.class).setParameter("model", 1).uniqueResult();
        car.toString();
//        Query query = session.createQuery(hql);
//        query.getResultList();



    }

}


