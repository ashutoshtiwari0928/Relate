package com.relate.Relate.Controller;

import com.relate.Relate.Model.Following;
import com.relate.Relate.Service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getFollowers(@PathVariable String username){
        try {
            return ResponseEntity.ok(followingService
                    .getFollowers(username));
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/Following/{username}")
    public ResponseEntity<?> getFollowings(@PathVariable String username){
        try {
            return  ResponseEntity.ok(followingService
                    .getFollowing(username));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
