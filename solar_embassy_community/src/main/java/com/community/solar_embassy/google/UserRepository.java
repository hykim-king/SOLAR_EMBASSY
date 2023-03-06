package com.community.solar_embassy.google;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//email을 이용해서 찾을 수 있도록 findByEmail 도 만들어준다.
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}