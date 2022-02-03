package business.abstracts;

import core.exceptions.BusinessException;
import entities.concretes.User;

import java.util.ArrayList;

public interface UserService {
    void add(User user) throws BusinessException;

    void update(User user) throws BusinessException;

    void delete(User user) throws BusinessException;

    ArrayList<User> getAll();
}
