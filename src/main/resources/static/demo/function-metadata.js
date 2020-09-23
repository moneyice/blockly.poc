var annualMonthlyTaxableSalary,
    annualAllowance,
    annualChildrenEducation,
    annualContinuingEducation,
    annualSeriousIllnessTreatment,
    annualMortgageInterest,
    annualHousingRent,
    annualSupportForElderly,
    annualSpecialDeductionAdjustment,
    personalTaxPaid,
    rate;





annualMonthlyTaxableSalary = ['myfunction', 'annualMonthlyTaxableSalary', '年度月薪计税工资'];
annualAllowance = ['myfunction', 'annualAllowance', '年度免税额'];
annualChildrenEducation = ['myfunction', 'annualChildrenEducation', '年度子女教育'];
annualContinuingEducation = ['myfunction', 'annualContinuingEducation', '年度继续教育'];
annualSeriousIllnessTreatment = ['myfunction', 'annualSeriousIllnessTreatment', '年度大病医疗'];
annualMortgageInterest = ['myfunction', 'annualMortgageInterest', '年度房贷利息'];
annualHousingRent = ['myfunction', 'annualHousingRent', '年度住房租金'];
annualSupportForElderly = ['myfunction', 'annualSupportForElderly', '年度赡养老人'];
annualSpecialDeductionAdjustment = ['myfunction', 'annualSpecialDeductionAdjustment', '年度专项扣减调整'];
personalTaxPaid = ['myfunction', 'personalTaxPaid', '已纳个人所得说'];
calculateTax = ['myfunction_1', 'calculateTax', '计算个人所得税'];

var folder_salary = [annualMonthlyTaxableSalary, annualAllowance, annualChildrenEducation, annualContinuingEducation, annualSeriousIllnessTreatment, annualMortgageInterest, annualHousingRent];
var folder_tax = [annualSupportForElderly, annualSpecialDeductionAdjustment, personalTaxPaid, calculateTax];

function getFuncData() {
    var data = { folder_salary: folder_salary, folder_tax: folder_tax };
    // var funcData = folder_salary.concat(folder_tax);
    return data;
};
function getVariablesData() {
    var variablesData = [['工资标准', 'salaryStandard'], ['执行系数', 'factor'], ['本月工资', 'monthSalary'], ['计税基数', 'taxBase'], ['应纳个人所得税', 'personalTaxPayable']];
    return variablesData;
};