package com.netflix.conductor.pheedpgexporter.kafkaexporter;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.netflix.conductor.model.TaskModel;

@Component
public class PublishTaskMessage {

    private final KafkaTemplate<String, TaskModel> kafkaTemplate;

    public PublishTaskMessage(KafkaTemplate<String, TaskModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(TaskModel model) {
        kafkaTemplate.send("conductor", model.getTaskId(), model);
    }
}
