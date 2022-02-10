package com.ilkayaktas.readingisgoodgetir.model.db;

/**
 * Created by ilkayaktas on 10.02.2022 at 12:49.
 */

public interface MonthlyOrderStatistics {
    String getMonth();
    Integer getTotalOrderCount();
    Integer getTotalBookCount();
    Double getTotalPurchaseAmount();
}
