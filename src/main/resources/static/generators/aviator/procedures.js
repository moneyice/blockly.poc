/**
 * @license
 * Copyright 2012 Google LLC
 * SPDX-License-Identifier: Apache-2.0
 */

/**
 * @fileoverview Generating Aviator for procedure blocks.
 * @author fraser@google.com (Neil Fraser)
 */
'use strict';

goog.provide('Blockly.Aviator.procedures');

goog.require('Blockly.Aviator');


Blockly.Aviator['procedures_defreturn'] = function (block) {
  // Define a procedure with a return value.
  var funcName = Blockly.Aviator.variableDB_.getName(
    block.getFieldValue('NAME'), Blockly.PROCEDURE_CATEGORY_NAME);
  var xfix1 = '';
  ////////test
  
  if (Blockly.Aviator.STATEMENT_PREFIX) {
    xfix1 += Blockly.Aviator.injectId(Blockly.Aviator.STATEMENT_PREFIX,
      block);
  }
  if (Blockly.Aviator.STATEMENT_SUFFIX) {
    xfix1 += Blockly.Aviator.injectId(Blockly.Aviator.STATEMENT_SUFFIX,
      block);
  }
  if (xfix1) {
    xfix1 = Blockly.Aviator.prefixLines(xfix1, Blockly.Aviator.INDENT);
  }
  var loopTrap = '';
  //////test

  if (Blockly.Aviator.INFINITE_LOOP_TRAP) {
    loopTrap = Blockly.Aviator.prefixLines(
      Blockly.Aviator.injectId(Blockly.Aviator.INFINITE_LOOP_TRAP,
        block), Blockly.Aviator.INDENT);
  }
  var branch = Blockly.Aviator.statementToCode(block, 'STACK');
  var returnValue = Blockly.Aviator.valueToCode(block, 'RETURN',
    Blockly.Aviator.ORDER_NONE) || '';
  var xfix2 = '';
  if (branch && returnValue) {
    // After executing the function body, revisit this block for the return.
    xfix2 = xfix1;
  }
  if (returnValue) {
    returnValue = Blockly.Aviator.INDENT + 'return ' + returnValue + ';\n';
  }
  var args = [];
  var variables = block.getVars();
  for (var i = 0; i < variables.length; i++) {
    args[i] = Blockly.Aviator.variableDB_.getName(variables[i],
      Blockly.VARIABLE_CATEGORY_NAME);
  }
  var code = 'function ' + funcName + '(' + args.join(', ') + ') {\n' +
    xfix1 + loopTrap + branch + xfix2 + returnValue + '}';
  // code = Blockly.Aviator.scrub_(block, code);
  // Add % so as not to collide with helper functions in definitions list.
  // Blockly.Aviator.definitions_['%' + funcName] = code
  return null;
};

// Defining a procedure without a return value uses the same generator as
// a procedure with a return value.
Blockly.Aviator['procedures_defnoreturn'] =
  Blockly.Aviator['procedures_defreturn'];

Blockly.Aviator['procedures_callreturn'] = function (block) {
  // Call a procedure with a return value.
  var funcName = Blockly.Aviator.variableDB_.getName(
    block.getFieldValue('NAME'), Blockly.PROCEDURE_CATEGORY_NAME);
  var args = [];
  var variables = block.getVars();
  for (var i = 0; i < variables.length; i++) {
    args[i] = Blockly.Aviator.valueToCode(block, 'ARG' + i,
      Blockly.Aviator.ORDER_COMMA) || 'null';
  }
  var code = funcName + '(' + args.join(', ') + ')';
  return [code, Blockly.Aviator.ORDER_FUNCTION_CALL];
};

Blockly.Aviator['procedures_callnoreturn'] = function (block) {
  // Call a procedure with no return value.
  // Generated code is for a function call as a statement is the same as a
  // function call as a value, with the addition of line ending.
  var tuple = Blockly.Aviator['procedures_callreturn'](block);
  return tuple[0] + ';\n';
};

Blockly.Aviator['procedures_ifreturn'] = function (block) {
  // Conditionally return value from a procedure.
  var condition = Blockly.Aviator.valueToCode(block, 'CONDITION',
    Blockly.Aviator.ORDER_NONE) || 'false';
  var code = 'if (' + condition + ') {\n';
  if (Blockly.Aviator.STATEMENT_SUFFIX) {
    // Inject any statement suffix here since the regular one at the end
    // will not get executed if the return is triggered.
    code += Blockly.Aviator.prefixLines(
      Blockly.Aviator.injectId(Blockly.Aviator.STATEMENT_SUFFIX, block),
      Blockly.Aviator.INDENT);
  }
  if (block.hasReturnValue_) {
    var value = Blockly.Aviator.valueToCode(block, 'VALUE',
      Blockly.Aviator.ORDER_NONE) || 'null';
    code += Blockly.Aviator.INDENT + 'return ' + value + ';\n';
  } else {
    code += Blockly.Aviator.INDENT + 'return;\n';
  }
  code += '}\n';
  return code;
};
