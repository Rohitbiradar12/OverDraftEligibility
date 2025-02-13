package com.od.tcs.api.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "TCSReply", namespace = "http://www.tigo.com/TCS")
@XmlAccessorType(XmlAccessType.FIELD)
public class TCSReply {

    @XmlElement(name = "Result", required = true)
    private int result;

    @XmlElement(name = "Message", required = true)
    private String message;

    @XmlElement(name = "Param1")
    private String param1;

    public TCSReply() {}

    public int getResult() { return result; }
    public void setResult(int result) { this.result = result; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getParam1() { return param1; }
    public void setParam1(String param1) { this.param1 = param1; }
}
