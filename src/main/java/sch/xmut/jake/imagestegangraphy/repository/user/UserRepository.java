package sch.xmut.jake.imagestegangraphy.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sch.xmut.jake.imagestegangraphy.domain.user.UserEntity;
import java.util.List;

/**
 * Created by jake.lin on 2019/12/24
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByMobile(String mobile);
    @Query(value = "select * from user u where u.mobile like concat('%', :mobile,'%') and u.account_name " +
            "like concat('%', :accountName, '%') and u.company like concat('%', :company, '%')", nativeQuery = true)
    List<UserEntity> findUser(@Param("mobile") String mobile, @Param("company") String company, @Param("accountName") String accountName);
}