package com.example.apptest.utils;

import com.example.apptest.bean.Tenant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeUtils {
    // 租客开始租房的时间，后续满一年续签需要用到
    private String firstYear;

    // 租客开始租房的时间，后续计算每月的房租需要用到
    private String firstMonth;

    // 租客入住的时间，每月这个时间点需要提醒收房租
    private String firstDay;

    public void fillTentTime(Tenant tenant) {
        tenant.setFirstYear(firstYear);
        tenant.setFirstMonth(firstMonth);
        tenant.setFirstDay(firstDay);
    }
}
