package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算个人所得税
 */
public class CalcuateTaxFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg) {
        Number salaryBase = FunctionUtils.getNumberValue(arg, env);
        BigDecimal salaryBaseBD = BigDecimal.valueOf(salaryBase.doubleValue());
        return new AviatorDecimal(calcuateTax(salaryBaseBD));
    }

    /**
     * 税率
     *
     * @param salaryBaseBD
     * @return
     */
    private BigDecimal calcuateTax(BigDecimal salaryBaseBD) {
        double[] taxRate = taxRate(salaryBaseBD);
        BigDecimal currentTax = salaryBaseBD.multiply(BigDecimal.valueOf(taxRate[0]))
                .subtract(BigDecimal.valueOf(taxRate[1]));
        return currentTax;
    }

    @Override
    public String getName() {
        return "calculateTax";
    }

    public double[] taxRate(BigDecimal taxBase) {
        String taxRangeKey = null;
        for (int i = 0; i < taxRange.length; i++) {
            if (taxBase.compareTo(BigDecimal.valueOf(taxRange[i])) != 1) {
                taxRangeKey = String.valueOf(Double.valueOf(taxRange[i]).longValue());
                break;
            }
        }
        return taxRangeMap.get(taxRangeKey);
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
            new double[]{36000, 144000, 300000, 420000, 660000, 960000, Double.MAX_VALUE};
    // 累计应纳税所得额
    Map<Long, double[]> taxRangeMap = new HashMap() {
        {
            put("36000", new double[]{0.03, 0});
            put("144000", new double[]{0.1, 2520});
            put("300000", new double[]{0.2, 16920});
            put("420000", new double[]{0.25, 31920});
            put("660000", new double[]{0.3, 52920});
            put("960000", new double[]{0.35, 85920});
            put(String.valueOf(Double.MAX_VALUE), new double[]{0.45, 181920});
        }
    };
}