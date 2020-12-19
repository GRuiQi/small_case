package com.db.util;

import java.sql.Connection;

public interface PoolClose {
    public  void release(Connection conn);
}
