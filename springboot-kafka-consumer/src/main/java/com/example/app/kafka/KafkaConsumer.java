package com.example.app.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.app.payload.User;
import com.example.app.repo.UserRepository;

@Service
public class KafkaConsumer {
	
	@Autowired
    private UserRepository userRepository;
	
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}",
    		properties = {"spring.json.value.default.type=com.example.app.payload.User"})
    public void consume(User user){
        LOGGER.info(String.format("Json message recieved -> %s", user.toString()));
        User savedUser = userRepository.save(user);
        
        System.out.println(savedUser);
    }
}