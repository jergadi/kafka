package com.github.jergadi.protobuf;

import com.avaloq.aip.protobuf.code_Tab.CodeTabOuterClass.CodeTab;
import com.github.javafaker.Faker;
import example.simple.Simple.SimpleMessage;

import java.util.Random;

public class ProtoBuilder {
    String build;
    Faker faker = new Faker();
    Random rand = new Random();

    public String CodeTab() {
        CodeTab.Builder builder = CodeTab.newBuilder();
        builder.setCodeTabName("Test Faker")
                .setId(rand.nextInt(100))
                .setInt1Id(faker.bothify("?#?#?#?#?#"))
                .setUserId(faker.bothify("U######"))
                .setName(faker.name().fullName())
                .setDescn(faker.shakespeare().hamletQuote())
                .setActive(rand.nextBoolean())
                .putFields("dog", faker.dog().name());
        return build = builder.toString();
    }

    public String SimpleTest() {
        SimpleMessage.Builder builder = SimpleMessage.newBuilder();
        builder.setId(rand.nextInt(9999))
                .setIsSimple(rand.nextBoolean())
                .setName(faker.name().fullName());
        return build = builder.toString();
    }
}
