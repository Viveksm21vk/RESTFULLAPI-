package com.johnson.app.rest.repo;
import com.johnson.app.rest.models.User;
import org.springframework.data.jpa.repository.*;

public interface UserRepo extends JpaRepository<User, Long> {

}
