package dataAccess.abstracts;

import core.dataAccess.CrudRepository;
import core.exceptions.BusinessException;
import entities.concretes.User;

import java.util.ArrayList;

public interface UserDao extends CrudRepository<User> {

    ArrayList<User> getAll();
}
