package com.qianyitian.blockly.poc.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

// 当月个税 = （累计收入 -累计五险一金 -累计专项附加扣除 -累计减除费用） x 预扣税率 -速算扣除数 -累计已缴纳税额
public class TaxService {
  // 累计信息表
  Map<Long, TaxInfo> personAllMap = new HashMap() {
    {
      // 员工号，累计收入，累计五险一金,累计缴税
      put(1001L, new TaxInfo(10000, 2000, 50000, 10000, 450));
      put(1002L, new TaxInfo(100000, 20000, 500000, 100000, 70000));
    }
  };

  public BigDecimal 获取当月个税(Long userId) {
    TaxInfo taxInfo = personAllMap.get(userId);
    // 当月个税 = （累计收入 -累计五险一金 -累计专项附加扣除 -累计减除费用） x 预扣税率 -速算扣除数 -累计已缴纳税额
    BigDecimal temp = taxInfo.currentIncome.subtract(taxInfo.currentBenefit)
        .subtract(taxInfo.currentSpec).subtract(taxInfo.currentDeduction);

    BigDecimal allBase = temp.add(taxInfo.allIncome).subtract(taxInfo.allBenefit)
        .subtract(taxInfo.allSpec).subtract(taxInfo.allDeduction);
    double[] taxRate = 获取该计税基数的对应税率扣除数(allBase);
    BigDecimal currentTax = allBase.multiply(BigDecimal.valueOf(taxRate[0]))
        .subtract(BigDecimal.valueOf(taxRate[1])).subtract(taxInfo.allTax);
    return currentTax;
  }

  public void 计算退税表(Long userId) {
    System.out.println("系统正在为用户 " + userId + " 计算退税表");
  }

  // 模拟数据库存储的数据
  class TaxInfo {
    BigDecimal currentIncome;
    BigDecimal currentBenefit;
    BigDecimal currentSpec = BigDecimal.valueOf(0);
    BigDecimal currentDeduction = BigDecimal.valueOf(5000);
    // 累计收入
    BigDecimal allIncome;
    // 累计五险一金
    BigDecimal allBenefit;
    // 计专项附加扣除
    BigDecimal allSpec = BigDecimal.valueOf(0);
    // 累计减除费用
    BigDecimal allDeduction = BigDecimal.valueOf(5 * 5000);
    // 累计纳税额
    BigDecimal allTax = BigDecimal.valueOf(2000);

    TaxInfo(double currentIncome, double currentBenefit, double allIncome, double allBenefit,
        double allTax) {
      this.currentIncome = BigDecimal.valueOf(currentIncome);
      this.currentBenefit = BigDecimal.valueOf(currentBenefit);
      this.allIncome = BigDecimal.valueOf(allIncome);
      this.allBenefit = BigDecimal.valueOf(allBenefit);
      this.allTax = BigDecimal.valueOf(allTax);
    }
  }



  // //税率/扣除数 = 获取该计税基数的对应税率扣除数(计税基数);
  // 级数 累计预扣预缴应纳税所得额 预扣税率 速算扣除数
  // 1 不超过36000元的部分 3% 0
  // 2 超过36000元至144000元的部分 10% 2520
  // 3 超过144000元至300000元的部分 20% 16920
  // 4 超过300000元至420000元的部分 25% 31920
  // 5 超过420000元至660000元的部分 30% 52920
  // 6 超过660000元至960000元的部分 35% 85920
  // 7 超过960000元的部分 45% 181920
  double[] taxRange =
      new double[] {36000, 144000, 300000, 420000, 660000, 960000, Double.MAX_VALUE};
  // 累计应纳税所得额
  Map<Long, double[]> taxRangeMap = new HashMap() {
    {
      put("36000", new double[] {0.03, 0});
      put("144000", new double[] {0.1, 2520});
      put("300000", new double[] {0.2, 16920});
      put("420000", new double[] {0.25, 31920});
      put("660000", new double[] {0.3, 52920});
      put("960000", new double[] {0.35, 85920});
      put(String.valueOf(Double.MAX_VALUE), new double[] {0.45, 181920});
    }
  };

  public double[] 获取该计税基数的对应税率扣除数(BigDecimal taxBase) {
    String taxRangeKey = null;
    for (int i = 0; i < taxRange.length; i++) {
      if (taxBase.compareTo(BigDecimal.valueOf(taxRange[i])) != 1) {
        taxRangeKey = String.valueOf(Double.valueOf(taxRange[i]).longValue());
        break;
      }
    }
    return taxRangeMap.get(taxRangeKey);
  }
}
