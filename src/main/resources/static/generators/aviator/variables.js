/**
 * @license
 * Copyright 2012 Google LLC
 * SPDX-License-Identifier: Apache-2.0
 */

/**
 * @fileoverview Generating Aviator for variable blocks.
 * @author fraser@google.com (Neil Fraser)
 */
'use strict';

goog.provide('Blockly.Aviator.variables');

goog.require('Blockly.Aviator');

//获得MyData
var VariablesData = getVariablesData();
Blockly.Aviator['variables_get'] = function (block) {
  // Variable getter.
  var variablesName = Blockly.Aviator.variableDB_.getName(block.getFieldValue('VAR'),
    Blockly.VARIABLE_CATEGORY_NAME);
  return [variablesName, Blockly.Aviator.ORDER_ATOMIC];
};


Blockly.Aviator['variables_set'] = function (block) {
  // Variable setter.
  var argument0 = Blockly.Aviator.valueToCode(block, 'VALUE',
    Blockly.Aviator.ORDER_ASSIGNMENT) || '0';
  var varName = Blockly.Aviator.variableDB_.getName(
    block.getFieldValue('VAR'), Blockly.VARIABLE_CATEGORY_NAME);
  return 'let ' + varName + ' = ' + argument0 + ';\n';
};

