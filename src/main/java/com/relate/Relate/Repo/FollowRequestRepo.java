package com.relate.Relate.Repo;

import com.relate.Relate.Model.FollowRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowRequestRepo extends JpaRepository<FollowRequest,Integer> {
    List<FollowRequest> findBySenderUserName(String  senderUserName);
    List<FollowRequest> findByReceiverUserName(String  receiverUserName);
}
