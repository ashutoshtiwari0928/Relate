package com.relate.Relate.Service;

import com.relate.Relate.Model.Following;
import com.relate.Relate.Repo.FollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingService {
    private FollowingRepo followingRepo;
    @Autowired
    public void setFollowingRepo(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }
    public List<Following> getFollowers(String username) {
        return followingRepo.findAllByFollowedUserName(username);
    }
    public List<Following> getFollowing(String username) {
        return followingRepo.findAllByFollowingUserName(username);
    }
}
