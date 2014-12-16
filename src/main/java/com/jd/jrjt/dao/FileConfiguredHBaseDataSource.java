package com.jd.jrjt.dao;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.springframework.stereotype.Repository;

import java.io.IOException;

/**
 * 从hbase-site.xml中读取相关配置的HBase datasource类。
 *
 * @author cdliuliu
 * @see FileConfiguredHBaseDataSource
 */
@Repository("hbaseSource")
public class FileConfiguredHBaseDataSource implements HBaseDataSource {
    private static HTablePool hTablePool = null;
    private static final int POOL_MAX_SIZE = 10;

    public FileConfiguredHBaseDataSource() {
        //此处从配置文件读取配置信息，配置文件在classpath下的hbase-site.xml。
        Configuration configuration = HBaseConfiguration.create();
        // 注意这个值设置的是每个htable表在pool中的最大值，建议根据并发的线程数进行控制。
        hTablePool = new HTablePool(configuration, POOL_MAX_SIZE);
    }

    /**
     * 返回htablepool连接池中的一个htable
     *
     * @param tableName
     * @return
     */
    @Override
    public HTableInterface getTable(String tableName) {
        return hTablePool.getTable(tableName);// 如果hTablePool对象已经存在，直接取出一个htable
    }

    @Override
    public void close() {
        try {
            hTablePool.close();
        } catch (IOException e) {
            e.printStackTrace();// to do log
        }
    }
}
