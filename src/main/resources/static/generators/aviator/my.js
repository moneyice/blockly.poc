/**
 * @license
 * Copyright 2012 Google LLC
 * SPDX-License-Identifier: Apache-2.0
 */

/**
 * @fileoverview Generating Aviator for colour blocks.
 * @author fraser@google.com (Neil Fraser)
 */
'use strict';

goog.provide('Blockly.Aviator.mys');

goog.require('Blockly.Aviator');


var data = getFuncData();
var funclist = data.folder_salary.concat(data.folder_tax);
var funclists = [];
for (var index = 0; index < funclist.length; index++) {
  if (funclist[index][0] == 'myfunction') {
    funclists.push(funclist[index])
  }
}

Blockly.Aviator['my_function'] = function (block) {
  // Define a procedure with a return value.
  var funcName = block.getFieldValue('NAME')
  for (var i = 0; i < funclists.length; i++) {
    if (funcName == funclists[i][2]) {
      funcName = funclists[i][1]
    }
  }

  var code = [funcName + '()', Blockly.Aviator.ORDER_FUNCTION_CALL]
  return code;
};

var funclists_1 = [];
for (var index = 0; index < funclist.length; index++) {
  if (funclist[index][0] == 'myfunction_1') {
    funclists_1.push(funclist[index])
  }
}

Blockly.Aviator['my_function_1'] = function (block) {
  // Define a procedure with a return value.
  var funcName = block.getFieldValue('NAME')
  for (var i = 0; i < funclists_1.length; i++) {
    if (funcName == funclists_1[i][2]) {
      funcName = funclists_1[i][1]
    }
  }
  var argument0 = Blockly.Aviator.valueToCode(block, 'FIRST',
    Blockly.Aviator.ORDER_MODULUS) || '0';
  var code = [funcName + '(' + argument0 + ')', Blockly.Aviator.ORDER_FUNCTION_CALL]
  return code;
};

/**
* Construct the blocks required by the flyout for the colours category.
* @param {!Blockly.Workspace} workspace The workspace this flyout is for.
* @return {!Array.<!Element>} Array of XML block elements.
*/

