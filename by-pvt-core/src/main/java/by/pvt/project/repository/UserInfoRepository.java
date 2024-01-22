package by.pvt.project.repository;

import by.pvt.project.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    @Query("SELECT u FROM UserInfo u ORDER BY u.email ASC")
    List<UserInfo> getAllUsers();

    @Query("SELECT u FROM UserInfo u WHERE u.name=:name and u.surname=:surname")
    Optional<UserInfo> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
