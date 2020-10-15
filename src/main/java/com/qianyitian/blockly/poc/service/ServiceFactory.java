package com.qianyitian.blockly.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceFactory {

//  @Autowired
//  private DataSource dataSource;
//  public void run(String sql){
//    PreparedStatement statement = dataSource.getConnection().prepareStatement(sql);
//    boolean execute = statement.execute();
//  }
}
