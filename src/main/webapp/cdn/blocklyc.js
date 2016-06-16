var BlocklyProp = {};

/**
 * List of tab names.
 * @private
 */
var TABS_ = ['blocks', 'propc', 'xml'];

var selected = 'blocks';

var term = null;

var codePropC = null;
var codeXml = null;

/**
 * Switch the visible pane when a tab is clicked.
 * @param {string} id ID of tab clicked.
 */
function tabClick(id) {
    // If the XML tab was open, save and render the content.
    /* if (document.getElementById('tab_xml').className == 'active') {
     var xmlTextarea = document.getElementById('textarea_xml');
     var xmlText = xmlTextarea.value;
     var xmlDom = null;
     try {
     xmlDom = Blockly.Xml.textToDom(xmlText);
     } catch (e) {
     var q =
     window.confirm('Error parsing XML:\n' + e + '\n\nAbandon changes?');
     if (!q) {
     // Leave the user on the XML tab.
     return;
     }
     }
     if (xmlDom) {
     Blockly.mainWorkspace.clear();
     Blockly.Xml.domToWorkspace(Blockly.mainWorkspace, xmlDom);
     }
     }*/

    // Deselect all tabs and hide all panes.
    for (var x in TABS_) {
        if (document.getElementById('tab_' + TABS_[x])) {
            document.getElementById('tab_' + TABS_[x]).className = 'taboff';
        }
        document.getElementById('content_' + TABS_[x]).style.display = 'none';
    }

    // Select the active tab.
    selected = id.replace('tab_', '');
    document.getElementById(id).className = 'active';
    // Show the selected pane.
    var content = document.getElementById('content_' + selected);
    content.style.display = 'block';
    renderContent();
}

/**
 * Populate the currently selected pane with content generated from the blocks.
 */
function renderContent() {
    var content = document.getElementById('content_' + selected);
    // Initialize the pane.
    if (content.id == 'content_blocks') {
        Blockly.mainWorkspace.render();
    } else if (content.id == 'content_xml') {
        var xmlDom = Blockly.Xml.workspaceToDom(Blockly.mainWorkspace);
        var xmlText = Blockly.Xml.domToPrettyText(xmlDom);
        codeXml.setValue(xmlText);
        codeXml.gotoLine(0);
    } else if (content.id == 'content_propc') {
        codePropC.setValue(Blockly.propc.workspaceToCode(Blockly.mainWorkspace));
        codePropC.gotoLine(0);
    }
}

/**
 * Initialize Blockly.  Called on page load.
 * @param {!Blockly} blockly Instance of Blockly from iframe.
 */
function init(blockly) {
    codePropC = ace.edit("code-propc");
    codePropC.setTheme("ace/theme/chrome");
    codePropC.getSession().setMode("ace/mode/c_cpp");
    codePropC.setReadOnly(true);

    codeXml = ace.edit("code-xml");
    codeXml.setTheme("ace/theme/chrome");
    codeXml.getSession().setMode("ace/mode/xml");
    codeXml.setReadOnly(true);

    window.Blockly = blockly;

    // Make the 'Blocks' tab line up with the toolbox.
    if (Blockly.Toolbox) {
        window.setTimeout(function () {
            document.getElementById('tab_blocks').style.minWidth =
                    (Blockly.Toolbox.width - 38) + 'px';
            // Account for the 19 pixel margin and on each side.
        }, 1);
    }

    loadProject();
}

function cloudCompile(text, action, successHandler) {
    $("#compile-dialog-title").text(text);
    $("#compile-console").val('');
    $('#compile-dialog').modal('show');

    var propcCode = Blockly.propc.workspaceToCode(Blockly.mainWorkspace);
    var terminalNeeded = propcCode.indexOf("SERIAL_TERMINAL USED") > -1;
    $.ajax({
        'method': 'POST',
        'url': baseUrl + 'rest/compile/c/' + action + '?id=' + idProject,
        'data': {"code": propcCode}
    }).done(function (data) {
        if (data.error) {
            alert(data['message']);
        } else {
            if (data.success) {
                $("#compile-console").val(data['compiler-output'] + data['compiler-error']);
                successHandler(data, terminalNeeded);
            } else {
                $("#compile-console").val(data['compiler-output'] + data['compiler-error']);
            }
        }
    }).fail(function (data) {
        alert(data);
    });
}

/**
 *
 */
function compile() {
    cloudCompile('Compile', 'compile', function (data, terminalNeeded) {

    });
}

/**
 *
 */
function loadIntoRam() {
    if (client_available) {
        cloudCompile('Load into ram', 'bin', function (data, terminalNeeded) {
            $.post(client_url + 'load.action', {action: "RAM", binary: data.binary, extension: data.extension, "comport": getComPort()}, function (loaddata) {
                $("#compile-console").val($("#compile-console").val() + loaddata.message);
                console.log(loaddata);
                if (terminalNeeded && loaddata.success) {
                    serial_console();
                }
            });
        });
    } else {
        alert("BlocklyPropClient not available to communicate with a microcontroller");
    }
}

/**
 *
 */
function loadIntoEeprom() {
    if (client_available) {
        cloudCompile('Load into eeprom', 'eeprom', function (data, terminalNeeded) {
            $.post(client_url + 'load.action', {action: "EEPROM", binary: data.binary, extension: data.extension, "comport": getComPort()}, function (loaddata) {
                $("#compile-console").val($("#compile-console").val() + loaddata.message);
                console.log(loaddata);
                if (terminalNeeded && loaddata.success) {
                    serial_console();
                }
            });
        });
    } else {
        alert("BlocklyPropClient not available to communicate with a microcontroller");
    }
}
