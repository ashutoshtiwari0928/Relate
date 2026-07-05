package com.relate.Relate.Service;

import com.relate.Relate.Model.FollowRequest;
import com.relate.Relate.Model.Following;
import com.relate.Relate.Repo.FollowRequestRepo;
import com.relate.Relate.Repo.FollowingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FollowRequestService {
    private FollowRequestRepo followRequestRepo;
    private FollowingRepo followingRepo;
    @Autowired
    public void setFollowingRepo(FollowingRepo followingRepo) {
        this.followingRepo = followingRepo;
    }
    @Autowired
    public void setFollowRequestRepo(FollowRequestRepo followRequestRepo) {
        this.followRequestRepo = followRequestRepo;
    }
    public List<FollowRequest> getAllFollowRequests(){
        return followRequestRepo.findAll();
    }
    public List<FollowRequest> getFollowRequestsBySenderUserName(String userName){
        return followRequestRepo.findBySenderUserName(userName);
    }
    public List<FollowRequest> getFollowRequestsByReceiverUserName(String receiverUserName){
        return followRequestRepo.findByReceiverUserName(receiverUserName);
    }

    public void createFollowRequest(FollowRequest followRequest) {
        followRequestRepo.save(followRequest);
    }

    public void acceptFollowRequest(FollowRequest followRequest) throws Exception {
        FollowRequest fromDBRequeset = new FollowRequest();
        List<FollowRequest> followRequestList = followRequestRepo
                .findBySenderUserName(followRequest
                        .getSenderUserName()
                );
        System.out.println("Actual follow request "+followRequest.toString());
        for(FollowRequest f: followRequestList){
            System.out.println("follow request "+f.toString());
            if(f.getReceiverUserName().equals(followRequest.getReceiverUserName())){
                fromDBRequeset = f;
                break;
            }
        }
        System.out.println("From db request "+fromDBRequeset.toString());
        if(followRequest.equals(fromDBRequeset)){
            followRequestRepo.delete(fromDBRequeset);
        }
        else{
            throw new Exception("Follow request not found");
        }
        Following following = new Following();
        following.setFollowedUserName(followRequest.getReceiverUserName());
        following.setFollowingUserName(followRequest.getSenderUserName());
        followingRepo.save(following);

    }
}
