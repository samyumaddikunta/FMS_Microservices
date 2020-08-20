package com.capg.us.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.us.dao.UsersDAO;
import com.capg.us.dto.Users;

@Service
public class UsersService 
{
     @Autowired
     UsersDAO udao;
     public void setUdao(UsersDAO udao) { this.udao=udao; }
     
     @Transactional(readOnly=true)
     public Optional<Users> getUser(String username)
     {
    	 return udao.findById(username);
     }
     
     /*@Transactional(readOnly=true)
     public List<Users> getAllUsers()
     {
    	 return udao.findAll();
     } */
     
     @Transactional
     public Users addUser(Users user)
     {
    	 return udao.save(user);
     }
     
     /*@Transactional
     public void updateUser(Users user)
     {
     	udao.save(user);
     }
     
     @Transactional
     public void deleteUser(String username)
     {
    	 udao.deleteById(username);
     } */
}
