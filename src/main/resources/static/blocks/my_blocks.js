    ////设置my 自定义块
    Blockly.Blocks['my_return'] = {
        init: function () {
          this.appendValueInput('VALUE')
            .setCheck('Number')
            .appendField('返回', 'NAME');
          this.setPreviousStatement(true, 'Number');
          // this.setOutput(true, 'Number');
          this.setColour(210);
          this.setTooltip('返回');
          this.setHelpUrl('return');
        }
      };
      //my-function   .appendField('getHome');
      Blockly.Blocks['my_function'] = {
        init: function () {
          this.appendDummyInput()
            .setAlign(Blockly.ALIGN_RIGHT)
            .appendField(new Blockly.FieldLabelSerializable(''), 'NAME');
          this.setOutput(true, 'Number');
          this.setColour("#FFC0CB");
          this.setTooltip('函数');
          this.setHelpUrl('');
        }
      }
      //带一个参数的函数  块样式配置
      Blockly.Blocks['my_function_1'] = {
        init: function () {
          this.appendValueInput("FIRST")
            .setCheck(null)
            .appendField(new Blockly.FieldLabelSerializable(""), "NAME");
          this.appendDummyInput();
          this.setOutput(true, null);
          this.setColour("#FFFF00");
          this.setTooltip("");
          this.setHelpUrl("");
        }
      };