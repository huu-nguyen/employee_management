package Group.Employee.Management.System.Employee_API.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group.Employee.Management.System.Employee_API.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
