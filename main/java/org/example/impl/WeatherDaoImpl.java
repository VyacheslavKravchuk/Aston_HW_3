package org.example.impl;

import org.example.dao.WeatherDao;
import org.example.entity.WeatherData;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.example.hibernate.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

@Service
public class WeatherDaoImpl implements WeatherDao {

    @Autowired
    WeatherData weatherData;

    @Override
    public List<WeatherData> findAll() {
        try(Session session = HibernateSessionFactoryUtil
                .getSessionFactory().openSession()) {
            return session.createQuery("WeatherData", WeatherData.class).list();
        }
    }

    @Override
    public WeatherData create(WeatherData weatherData) {
        if (weatherData != null) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                    .openSession()) {
                Transaction transaction = null;
                WeatherData createdWeatherData = null;
                try {
                    // Создаем транзакцию и начинаем ее
                    transaction = session.beginTransaction();
                    //session.saveOrUpdate(weatherData);
                    Serializable createdId = (Serializable) session.save(weatherData);
                    createdWeatherData = session.get(WeatherData.class, createdId);
                    transaction.commit();
                } catch (Exception e) {
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    throw e;
                }
                return createdWeatherData;
            }
        }
        return null;
    }

    @Override
    public Optional<WeatherData> readById(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(WeatherData.class, id));
        }
    }

    @Override
    public WeatherData updateAmountById(WeatherData weatherData) {
        EntityManager entityManager = (EntityManager) HibernateSessionFactoryUtil.getSessionFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        WeatherData updated = null;
        try {
            entityTransaction.begin();
            updated = entityManager.merge(weatherData);
            entityTransaction.commit();
        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
        return updated;
    }

    @Override
    public Optional<WeatherData> deleteById(WeatherData weatherData) {
        Optional<WeatherData> weatherDataOptional = readById(weatherData.getId());
        if (weatherDataOptional.isPresent()) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                // Для удаления объекта из таблицы нужно передать его в метод delete
                session.delete(weatherDataOptional.get());
                transaction.commit();
                return weatherDataOptional;
            }
        }
        return Optional.empty();
    }
}