package com.ilkayaktas.readingisgoodgetir.model.db;

/**
 * Created by ilkayaktas on 06.02.2022 at 01:06.
 */

public enum OrderStatus {
   CANCELLED(0),
   ON_GOING(1),
   COMPLETED(2);

   public int status;

   OrderStatus(int status) {
      this.status = status;
   }
}
