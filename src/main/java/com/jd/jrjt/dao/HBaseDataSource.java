package com.jd.jrjt.dao;

import org.apache.hadoop.hbase.client.HTableInterface;

public interface HBaseDataSource {
    public HTableInterface getTable(String tableName);

    public void close();
}
