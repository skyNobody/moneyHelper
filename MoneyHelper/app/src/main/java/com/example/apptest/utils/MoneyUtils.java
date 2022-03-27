package com.example.apptest.utils;

import com.example.apptest.bean.Tenant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyUtils {
    // 房间的房租
    private String rent;

    // 电费
    private String electricityFee;

    // 用电量
    private String electricity;

    // 水费
    private String chargeForWater;

    // 其它费用
    private String otherFee;

    // 押金
    private String deposit;

    public void fillTentMoney(Tenant tenant) {
        tenant.setRent(rent);
        tenant.setElectricityFee(electricityFee);
        tenant.setElectricity(electricity);
        tenant.setChargeForWater(chargeForWater);
        tenant.setOtherFee(otherFee);
        tenant.setDeposit(deposit);
    }
}
