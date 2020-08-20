package com.capg.us.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.us.dto.Users;
@Repository
public interface UsersDAO extends JpaRepository<Users,String>
{

}
