package com.relate.Relate.Controller;

import com.relate.Relate.Model.FollowRequest;
import com.relate.Relate.Model.Following;
import com.relate.Relate.Service.FollowRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class FollowRequestController {
    private FollowRequestService followRequestService;
    @Autowired
    public void setFollowRequestService(FollowRequestService followRequestService) {
        this.followRequestService = followRequestService;
    }
    @GetMapping("/Request")
    public ResponseEntity<?> getAllFollowRequests(){
        List<FollowRequest> list = followRequestService.getAllFollowRequests();
        if(list.isEmpty ()){
            return new ResponseEntity<>("No requests found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/Request/received/{username}")
    public ResponseEntity<?> getReceivedFollowRequests(@PathVariable String username){
        List<FollowRequest> list = followRequestService.getFollowRequestsByReceiverUserName(username);
        return ResponseEntity.ok().body(list);
    }
    @GetMapping("/Request/sent/{username}")
    public ResponseEntity<?> getSentFollowRequest(@PathVariable String username){
        List<FollowRequest> list = followRequestService.getFollowRequestsBySenderUserName(username);
        return ResponseEntity.ok().body(list);
    }
    @PostMapping("/Request/accept")
    public ResponseEntity<?> acceptFollowRequest(@RequestBody FollowRequest followRequest){
        try {
            followRequestService.acceptFollowRequest(followRequest);
            return new ResponseEntity<>("Request accepted", HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/Request")
    public ResponseEntity<?> followRequest(@RequestBody FollowRequest followRequest){
        if(followRequest.getSenderUserName()==null ||
        followRequest.getReceiverUserName()==null){
            return ResponseEntity.badRequest().build();
        }
        followRequestService.createFollowRequest(followRequest);
        return ResponseEntity.ok().build();
    }
}
