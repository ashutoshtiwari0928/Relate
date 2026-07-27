package com.relate.Relate;

import com.relate.Relate.Service.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RelateApplication {
	public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(RelateApplication.class, args);
	}

}
