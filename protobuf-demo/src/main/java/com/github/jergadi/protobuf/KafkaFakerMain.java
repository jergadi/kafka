package com.github.jergadi.protobuf;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class KafkaFakerMain {
    public static void main(String[] args) {
        // 1 to send code_tab.proto
        // 2 to send simple.proto
        KafkaGenerator.Send(2,10);
    }
}
