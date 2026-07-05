package com.relate.Relate.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FollowRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String senderUserName;
    private String receiverUserName;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof FollowRequest)) return false;
        FollowRequest that = (FollowRequest) o;
        return this.getSenderUserName().equals(that.getSenderUserName()) &&
                this.getReceiverUserName().equals(that.getReceiverUserName());
    }
    @Override
    public int hashCode(){
        return Objects.hash(getSenderUserName(), getReceiverUserName());
    }
}
