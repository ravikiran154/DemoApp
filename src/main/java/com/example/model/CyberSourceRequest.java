package com.example.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "clientReferenceInformation",
    "keyInformation"
})
public class CyberSourceRequest {

    @JsonProperty("clientReferenceInformation")
    private ClientReferenceInformation clientReferenceInformation;
    @JsonProperty("keyInformation")
    private List<KeyInformation> keyInformation = null;

    @JsonProperty("clientReferenceInformation")
    public ClientReferenceInformation getClientReferenceInformation() {
        return clientReferenceInformation;
    }

    @JsonProperty("clientReferenceInformation")
    public void setClientReferenceInformation(ClientReferenceInformation clientReferenceInformation) {
        this.clientReferenceInformation = clientReferenceInformation;
    }

    @JsonProperty("keyInformation")
    public List<KeyInformation> getKeyInformation() {
        return keyInformation;
    }

    @JsonProperty("keyInformation")
    public void setKeyInformation(List<KeyInformation> keyInformation) {
        this.keyInformation = keyInformation;
    }

}