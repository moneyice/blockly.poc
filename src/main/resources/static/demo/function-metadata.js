var annualMonthlyTaxableSalary = ['myfunction', 'annualMonthlyTaxableSalary', '年度月薪计税工资'];
var annualAllowance = ['myfunction', 'annualAllowance', '年度免税额'];
var annualChildrenEducation = ['myfunction', 'annualChildrenEducation', '年度子女教育'];
var annualContinuingEducation = ['myfunction', 'annualContinuingEducation', '年度继续教育'];
var annualSeriousIllnessTreatment = ['myfunction', 'annualSeriousIllnessTreatment', '年度大病医疗'];
var annualMortgageInterest = ['myfunction', 'annualMortgageInterest', '年度房贷利息'];
var annualHousingRent = ['myfunction', 'annualHousingRent', '年度住房租金'];
var annualSupportForElderly = ['myfunction', 'annualSupportForElderly', '年度赡养老人'];
var annualSpecialDeductionAdjustment = ['myfunction', 'annualSpecialDeductionAdjustment', '年度专项扣减调整'];
var personalTaxPaid = ['myfunction', 'personalTaxPaid', '已纳个人所得说'];
var calculateTax = ['myfunction_1', 'calculateTax', '计算个人所得税'];

var folder_salary = [annualMonthlyTaxableSalary, annualAllowance, annualChildrenEducation, annualContinuingEducation, annualSeriousIllnessTreatment, annualMortgageInterest, annualHousingRent];
var folder_tax = [annualSupportForElderly, annualSpecialDeductionAdjustment, personalTaxPaid, calculateTax];

function getFuncData() {
    var data = { folder_salary: folder_salary, folder_tax: folder_tax };
    // var funcData = folder_salary.concat(folder_tax);
    return data;
};
function getVariablesData() {
    var variablesData = [['工资标准', 'salaryStandard'], ['执行系数', 'factor'], ['本月工资', 'monthSalary'], ['计税基数', 'taxBase'], ['应纳个人所得税', 'personalTaxPayable'], ['工资个人所得税', 'personalTaxOnWages']];
    return variablesData;
};