package com.wwsi.ti.idx8558.generator;

import java.time.LocalDateTime;

public interface KeyGenerator {
    String generateKey(LocalDateTime czasZamowienia);
}
