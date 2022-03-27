package com.example.apptest.activity.manager;

import com.example.apptest.bean.Tenant;
import com.example.apptest.utils.MoneyUtils;
import com.example.apptest.utils.TimeUtils;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class TentantManager {
    public static void addTentAnt(String roomId, String name, TimeUtils timeUtils, MoneyUtils moneyUtils) {
        List<Tenant> tenants = LitePal.where("roomId = ?", roomId).find(Tenant.class);
        Tenant tenant;
        if (tenants.size() == 0) {
            tenant = new Tenant();
        } else {
            tenant = tenants.get(0);
        }
        tenant.setRoomId(roomId);
        tenant.setName(name);
        timeUtils.fillTentTime(tenant);
        moneyUtils.fillTentMoney(tenant);
        tenant.save();
    }

    public static void deleteTentnt(String roomId) {
        LitePal.deleteAll(Tenant.class, "roomId = ?", roomId);
    }
}
