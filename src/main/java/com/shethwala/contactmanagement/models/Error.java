package com.shethwala.contactmanagement.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Error {
	
    private final List<String> messages;

    @JsonCreator
    public Error(@JsonProperty("errorMessages") List<String> messages) {
        this.messages = new ArrayList<>(messages);
    }

    public Error(String message) {
        this.messages = Collections.singletonList(message);
    }

    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                       .append("errorMessages", messages)
                       .toString();
    }

}
