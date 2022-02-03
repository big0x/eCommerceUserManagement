package dataAccess.concretes;

import core.exceptions.BusinessException;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;

public class UserHibernateDao implements UserDao {
    ArrayList<User> users = new ArrayList<User>();

    @Override
    public void add(User user) throws BusinessException {
        System.out.println("Added with Hibernate");
        users.add(user);
    }

    @Override
    public void update(User updatedUser) throws BusinessException {
        for (User user : users) {
            if (user.getId() == updatedUser.getId()) {
                users.set(users.indexOf(user), updatedUser);
                System.out.println("Updated with Hibernate");
            }
        }

    }

    @Override
    public void delete(User user) throws BusinessException {
        users.remove(user);
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }
}
