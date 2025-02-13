package com.od.tcs.api.model;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "TCSRequest", namespace = "http://www.tigo.com/TCS")
@XmlAccessorType(XmlAccessType.FIELD)
public class TCSRequest {

    private String UserName;
    private String TerminalType;
    private String Password;

    @XmlElement(name = "Function", namespace = "http://www.tigo.com/TCS") 
    private Function function;

    public TCSRequest() {}

    public TCSRequest(String userName, String terminalType, String password, Function function) {
        this.UserName = userName;
        this.TerminalType = terminalType;
        this.Password = password;
        this.function = function;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getTerminalType() {
        return TerminalType;
    }

    public void setTerminalType(String terminalType) {
        this.TerminalType = terminalType;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Function {

        @XmlAttribute(name = "name") // Ensure proper XML mapping
        private String name;

        @XmlElement(name = "param1", namespace = "http://www.tigo.com/TCS")
        private String param1;

        @XmlElement(name = "param2", namespace = "http://www.tigo.com/TCS")
        private String param2;

        @XmlElement(name = "param3", namespace = "http://www.tigo.com/TCS")
        private String param3;

        public Function() {}

        public Function(String name, String param1, String param2, String param3) {
            this.name = name;
            this.param1 = param1;
            this.param2 = param2;
            this.param3 = param3;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getParam1() {
            return param1;
        }

        public void setParam1(String param1) {
            this.param1 = param1;
        }

        public String getParam2() {
            return param2;
        }

        public void setParam2(String param2) {
            this.param2 = param2;
        }

        public String getParam3() {
            return param3;
        }

        public void setParam3(String param3) {
            this.param3 = param3;
        }
    }
}
