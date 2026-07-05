package com.relate.Relate.Controller;

import com.relate.Relate.Model.Following;
import com.relate.Relate.Service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/v1")
public class FollowingController {
    private FollowingService followingService;
    @Autowired
    public void setFollowingService(FollowingService followingService) {
        this.followingService = followingService;
    }
    @GetMapping("/Followers/{username}")
    public List<Following> getFollowers(@PathVariable String username){
        return followingService
                .getFollowers(username);
    }
    @GetMapping("/Following/{username}")
    public List<Following> getFollowings(@PathVariable String username){
        return followingService
                .getFollowing(username);
    }

}
