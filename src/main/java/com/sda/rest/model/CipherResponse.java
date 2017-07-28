package com.sda.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by RENT on 2017-07-28.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CipherResponse {
    private String encryptedMessage;

    public CipherResponse() {
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(String encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }
}
