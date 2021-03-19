package com.wwsi.ti.idx8558.generator;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Random;

@Component
public class KeyGeneratorImpl implements KeyGenerator {

    Random random;

    public KeyGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public String generateKey(LocalDateTime czasZamowienia) {
        String result = "";
        StringBuilder stringBuilder = new StringBuilder(result);

        stringBuilder.append(getVal());
        stringBuilder.append(czasZamowienia.getSecond());
        stringBuilder.append("-");
        stringBuilder.append(getVal());
        stringBuilder.append(czasZamowienia.getMinute());
        stringBuilder.append("-");
        stringBuilder.append(getVal());
        stringBuilder.append(czasZamowienia.getHour());
        stringBuilder.append("-");
        stringBuilder.append(getVal());
        stringBuilder.append(czasZamowienia.getDayOfWeek().getValue());

        result = stringBuilder.toString();
        System.out.println(result);
        return result;
    }

    private String getVal() {
        String val = "";
        StringBuilder stringBuilder = new StringBuilder(val);

        for(int i = 0 ; i < 3 ; i++) {
            stringBuilder.append((char) (random.nextInt(26) + 65));
        }
        return stringBuilder.toString();
    }
}
