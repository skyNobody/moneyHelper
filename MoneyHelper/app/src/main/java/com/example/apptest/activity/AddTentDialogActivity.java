package com.example.apptest.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.apptest.R;
import com.example.apptest.activity.manager.TentantManager;
import com.example.apptest.utils.MoneyUtils;
import com.example.apptest.utils.TimeUtils;

public class AddTentDialogActivity extends AppCompatActivity {

    public static AddTentDialogActivity instance = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tent_dialog);
        this.setFinishOnTouchOutside(false);//设置窗口周围触摸不消失
        getWindow().setDimAmount(0f);//设置窗口周围透明
        instance = this;
        Button button = findViewById(R.id.comfirm_addTent);
        EditText roomId = findViewById(R.id.roomId);
        EditText name = findViewById(R.id.name);
        EditText firstYear = findViewById(R.id.firstYear);
        EditText firstMonth = findViewById(R.id.firstMonth);
        EditText firstDay = findViewById(R.id.firstDay);
        EditText rent = findViewById(R.id.rent);
        EditText electricityFee = findViewById(R.id.electricityFee);
        EditText electricity = findViewById(R.id.electricity);
        EditText chargeForWater = findViewById(R.id.chargeForWater);
        EditText otherFee = findViewById(R.id.otherFee);
        EditText deposit = findViewById(R.id.deposit);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeUtils timeUtils = new TimeUtils();
                timeUtils.setFirstYear(firstYear.getText().toString());
                timeUtils.setFirstMonth(firstMonth.getText().toString());
                timeUtils.setFirstDay(firstDay.getText().toString());

                MoneyUtils moneyUtils = new MoneyUtils();
                moneyUtils.setRent(rent.getText().toString());
                moneyUtils.setElectricityFee(electricityFee.getText().toString());
                moneyUtils.setElectricity(electricity.getText().toString());
                moneyUtils.setChargeForWater(chargeForWater.getText().toString());
                moneyUtils.setOtherFee(otherFee.getText().toString());
                moneyUtils.setDeposit(deposit.getText().toString());

                TentantManager.addTentAnt(roomId.getText().toString(),
                        name.getText().toString(), timeUtils, moneyUtils);
                setResult(1);
                finish();
            }
        });
    }
}