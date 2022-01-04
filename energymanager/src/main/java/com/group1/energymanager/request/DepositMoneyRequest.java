package com.group1.energymanager.request;


public class DepositMoneyRequest {
    private String id;
    private float money;
    private Operation operation;

    public DepositMoneyRequest(String ragSociale, float money, Operation operation) {
        this.id = id;
        this.money = money;
        this.operation = operation;
        ;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }
}

