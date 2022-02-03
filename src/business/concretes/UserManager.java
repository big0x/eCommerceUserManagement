package business.concretes;

import business.abstracts.UserService;
import core.exceptions.BusinessException;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

import java.util.ArrayList;

public class UserManager implements UserService {

    private UserDao userDao;
    ArrayList<User> users = new ArrayList<User>();

    private boolean isUserPasswordCorrect(User user) throws BusinessException {
        //en az 6 karakter
        if (user.getPassword().length() <= 5) {
            throw new BusinessException("Password must be at least 6 character.");
        } else {
            return true;
        }
    }

    private boolean isEmailContainsChar(User user) throws BusinessException {
        //email @ içermeli
        if (!user.getEmail().contains("@")) {
            throw new BusinessException("Invalid e-mail format.");
        } else {
            return true;
        }
    }


    private boolean isEmailExist(User existedUser) throws BusinessException {
        //email kayıtlı mı
        for (User user : users) {
            if (user.getEmail()==existedUser.getEmail()) {
                throw new BusinessException("User already exist.");
            }
        }
        return true;
    }


    private boolean isFirstNameCorrect(User user) throws BusinessException {
        //isim en az 2 karakter
        if (user.getFirstName().length() <= 1) {
            throw new BusinessException("First name must be at least 2 characters");
        } else {
            return true;
        }
    }

    private boolean isLastNameCorrect(User user) throws BusinessException {
        //soyisim en az 2 karakter
        if (user.getLastName().length() <= 1) {
            throw new BusinessException("Last name must be at least 2 characters");
        } else {
            return true;
        }
    }

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) throws BusinessException {
        if (isEmailContainsChar(user) && isFirstNameCorrect(user) && isLastNameCorrect(user) && isUserPasswordCorrect(user) && isEmailExist(user)) {
            this.userDao.add(user);
            users.add(user);
        } else {
            throw new BusinessException("An unknown error occured");
        }

    }

    @Override
    public void update(User updatedUser) throws BusinessException {
        for (User user : users) {
            if (user.getId() == updatedUser.getId()) {
                users.set(users.indexOf(user), updatedUser);
                this.userDao.update(updatedUser);
            } else {
                throw new BusinessException("An unknown error occured");
            }
        }
    }
    @Override
    public void delete(User user) throws BusinessException {

    }

    @Override
    public ArrayList<User> getAll() {
        return this.users;
    }
}
