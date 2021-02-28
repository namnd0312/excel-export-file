package com.namnd.exportexcel.repositories;

import com.namnd.exportexcel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 28/02/2021 - 7:37 PM
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
