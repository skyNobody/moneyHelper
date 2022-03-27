package com.example.apptest.bean;

import android.provider.ContactsContract;

import org.litepal.crud.LitePalSupport;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tenant extends LitePalSupport {
    // 房间id, 是唯一的，后续查找是根据房间Id进行数据查找
    private String roomId;

    // 租客的姓名
    private String name;

    // 租客开始租房的时间，后续满一年续签需要用到
    private String firstYear;

    // 租客开始租房的时间，后续计算每月的房租需要用到
    private String firstMonth;

    // 租客入住的时间，每月这个时间点需要提醒收房租
    private String firstDay;

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
}
