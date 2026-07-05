package com.relate.Relate.Repo;

import com.relate.Relate.Model.FollowRequest;
import com.relate.Relate.Model.Following;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FollowingRepo extends JpaRepository<Following, Integer> {
    List<Following> findAllByFollowingUserName(String followingUserName);
    List<Following> findAllByFollowedUserName(String followedUserName);
}
