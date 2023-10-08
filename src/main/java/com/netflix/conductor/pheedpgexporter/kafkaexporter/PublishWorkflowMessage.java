package com.netflix.conductor.pheedpgexporter.kafkaexporter;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.netflix.conductor.model.WorkflowModel;

@Component
public class PublishWorkflowMessage {

    private final KafkaTemplate<String, WorkflowModel> kafkaTemplate;

    public PublishWorkflowMessage(KafkaTemplate<String, WorkflowModel> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(WorkflowModel model) {
        kafkaTemplate.send("conductor", model.getWorkflowId(), model);
    }
}
