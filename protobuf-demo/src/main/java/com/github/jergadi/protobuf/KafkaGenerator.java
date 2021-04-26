package com.github.jergadi.protobuf;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaGenerator {
    public static void Send (int choice, int itr) {
        ProtoBuilder proto = new ProtoBuilder();
        String value;

        // create Producer properties
        String bootstrapServer = "127.0.0.1:9092";
        String topic = "demo_topic";
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // loop into kafka send
        for (int i=0; i<itr; i++) {
            if (choice == 1) {
                value = proto.CodeTab();
            } else if (choice == 2) {
                value = proto.SimpleTest();
            } else {
                value = proto.SimpleTest();
            }
            // create producer
            KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

            // create protobuf data
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, value);

            // send data
            producer.send(record);

            // flush data
            producer.flush();
            producer.close();
        }
    }
}
