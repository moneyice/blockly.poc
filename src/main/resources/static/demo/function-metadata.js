var annualMonthlyTaxableSalary = ['TAX', 'myfunction', 'annualMonthlyTaxableSalary', '年度月薪计税工资'];
var annualAllowance = ['myfunction', 'annualAllowance', '年度免税额'];
var annualChildrenEducation = ['myfunction', 'annualChildrenEducation', '年度子女教育'];
var annualContinuingEducation = ['myfunction', 'annualContinuingEducation', '年度继续教育'];
var annualSeriousIllnessTreatment = ['myfunction', 'annualSeriousIllnessTreatment', '年度大病医疗'];
var annualMortgageInterest = ['myfunction', 'annualMortgageInterest', '年度房贷利息'];
var annualHousingRent = ['myfunction', 'annualHousingRent', '年度住房租金'];
var annualSupportForElderly = ['SALARY', 'myfunction', 'annualSupportForElderly', '年度赡养老人'];
var annualSpecialDeductionAdjustment = ['myfunction', 'annualSpecialDeductionAdjustment', '年度专项扣减调整'];
var personalTaxPaid = ['myfunction', 'personalTaxPaid', '已纳个人所得税'];
var calculateTax = ['myfunction_1', 'calculateTax', '计算个人所得税'];

var folder_salary = [annualMonthlyTaxableSalary, annualAllowance, annualChildrenEducation, annualContinuingEducation, annualSeriousIllnessTreatment, annualMortgageInterest, annualHousingRent];
var folder_tax = [annualSupportForElderly, annualSpecialDeductionAdjustment, personalTaxPaid, calculateTax];
//内置函数数据
var N_Function = [
    {
        allData: [
            { code: 'annualMonthlyTaxableSalary', customFlag: 'N', groupCode: '', name: '年度月薪计算工资', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'annualSpecialDeductionAdjustment', customFlag: 'N', groupCode: '', name: '年度专项扣减调整', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'personalTaxPaid', customFlag: 'N', groupCode: '', name: '已纳个人所得税', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'calculateTax', customFlag: 'N', groupCode: '', name: '计算个人所得税', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 1 },
            { code: 'annualHousingRent', customFlag: 'N', groupCode: '', name: '年度住房租金', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'annualSupportForElderly', customFlag: 'N', groupCode: '', name: '年度赡养老人', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'annualAllowance', customFlag: 'N', groupCode: '', name: '年度免税额', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'annualChildrenEducation', customFlag: 'N', groupCode: '', name: '年度子女教育', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 },
            { code: 'annualMortgageInterest', customFlag: 'N', groupCode: '', name: '年度房贷利息', defaultType: '3', orgId: 'AEA82BC80D3C441198C0DB4792C69D57', paramNum: 0 }
        ],
        group: '内置函数'
    }
]
//工资科目数据
var salarySubject = [
    {
        allData: [
            { code: "C10001", name: "工资科目1", effecttiveDate: 1600100000000, paramNum: 0, customFlag: 'subject'},
            { code: "C10002", name: "工资科目2", effecttiveDate: 1600200000000, paramNum: 0, customFlag: 'subject' }
        ],
        group: '工资科目'
    }
]

function getFuncData() {
    var data = N_Function.concat(salarySubject);
    // var funcData = folder_salary.concat(folder_tax);
    return data;
};
function getVariablesData() {
    var variablesData = [['工资标准', 'salaryStandard'], ['执行系数', 'factor'], ['本月工资', 'monthSalary'], ['计税基数', 'taxBase'], ['应纳个人所得税', 'personalTaxPayable'], ['工资个人所得税', 'personalTaxOnWages']];
    return variablesData;
};
