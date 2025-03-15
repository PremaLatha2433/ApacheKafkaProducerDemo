package com.apache.kafka.controller;

import com.apache.kafka.pojo.Customer;
import com.apache.kafka.services.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher kafkaMessagePublisher;


    @GetMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message){
        try {
            for(int i=0;i<10000;i++) {
                kafkaMessagePublisher.sendMessageToTopic(message+":"+i);
            }
            return new ResponseEntity<>("message published sucessfully..", HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/publish")
    public ResponseEntity<?> publishMessage(@RequestBody Customer customer){
        try {
                kafkaMessagePublisher.sendMessageObjectToTopic(customer);
            return new ResponseEntity<>("message published sucessfully..", HttpStatus.OK);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
