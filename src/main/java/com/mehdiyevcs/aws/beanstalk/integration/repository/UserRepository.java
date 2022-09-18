package com.mehdiyevcs.aws.beanstalk.integration.repository;

import com.mehdiyevcs.aws.beanstalk.integration.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
