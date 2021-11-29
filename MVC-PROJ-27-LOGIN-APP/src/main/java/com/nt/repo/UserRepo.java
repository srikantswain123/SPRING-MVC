package com.nt.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nt.entity.UserInfo;

public interface UserRepo extends CrudRepository<UserInfo, String> {
	
	/*@Query("SELECT COUNT(*) FROM UserInfo WHERE user=:UN AND pwd=:PW")
	public int Validate(@Param("UN")String UN,@Param("PW")String PW);
	*/
}
