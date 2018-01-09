package br.com.guilherme.lemes.core.domain.message;


import br.com.guilherme.lemes.core.domain.enumeration.MessageType;

import java.util.Calendar;

public class EventMessage {

    private String serialEquipment;

    private String serialNumber;

    private Calendar dateCreation;


    private MessageType messageType;

    public EventMessage() {}



    public Calendar getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Calendar dateCreation) {
        this.dateCreation = dateCreation;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSerialEquipment() {
        return serialEquipment;
    }

    public void setSerialEquipment(String serialEquipment) {
        this.serialEquipment = serialEquipment;
    }


    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
