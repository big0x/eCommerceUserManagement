import business.abstracts.UserService;
import business.concretes.UserManager;
import core.exceptions.BusinessException;
import dataAccess.concretes.UserHibernateDao;
import entities.concretes.User;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"Mehmet","Yurdakul","mhmtyrdkl1@gmail.com","123123123");
        User user2 =new User(1,"Mehmet","Yurdakul","mehmetyurdakul.ym@gmail.com","12121233");
        User user3 =new User(1,"Engin","Demiroğ","mehmetyurdakul.ym@gmail.com","1212312331");
        UserService userManager = new UserManager(new UserHibernateDao());
        try {
            userManager.add(user1);
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }
        try{
            userManager.update(user2);
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }
        try {
            userManager.add(user3);
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }
    }
}
