package com.relate.Relate.Service;

import com.relate.Relate.Model.Following;
import com.relate.Relate.Repo.FollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowingService {
    private FollowingRepo followingRepo;
    private UtilService utilService;
    @Autowired
    public void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }

    @Autowired
    public void setFollowingRepo(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }
    public List<Following> getFollowers(String username) throws Exception{
        if(username == null){
            throw  new Exception("Username is null");
        }else if(!utilService.checkUser(username)){
            throw new Exception("User not found.");
        }
        return followingRepo.findAllByFollowedUserName(username);
    }
    public List<Following> getFollowing(String username) throws Exception {
        if(username == null){
            throw  new Exception("Username is null");
        }else if(!utilService.checkUser(username)){
            throw new Exception("User not found.");
        }
        return followingRepo.findAllByFollowingUserName(username);
    }


}
