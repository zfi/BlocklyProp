/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var client_available = false;

$(document).ready(function () {
    check_client();
    $.get($("#client-instructions").data('url'), function (data) {
        $("#client-instructions").html(data);
    });
});

check_client = function () {
    $.get($("#client-actions").data('client'), function (data) {
        console.log(data);

        if (data.clients.length > 0) {
            client_available = true;
            $("#client-available").removeClass("hidden");
            $("#client-unavailable").addClass("hidden");
        } else {

            client_available = false;
            $("#client_status").text($("#client_status").data('not-available')).removeClass("available").addClass("not_available");
            $("#client-available").addClass("hidden");
            $("#client-unavailable").removeClass("hidden");
        }
        setTimeout(check_client, 20000);
    }).fail(function () {
        client_available = false;
        $("#client_status").text($("#client_status").data('not-available')).removeClass("available").addClass("not_available");
        $("#client-available").addClass("hidden");
        $("#client-unavailable").removeClass("hidden");
        setTimeout(check_client, 2000);
    });
};


check_com_ports = function () {
    if (client_url !== undefined) {
        var selected_port = $("#comPort").val();
        $.get(client_url + "ports.json", function (data) {
            $("#comPort").empty();
            data.forEach(function (port) {
                $("#comPort").append($('<option>', {
                    text: port
                }));
            });
            select_com_port(selected_port);
            client_available = true;
        }).fail(function () {
            $("#comPort").empty();
            $("#comPort").append($('<option>', {
                text: 'COM1'
            }));
            $("#comPort").append($('<option>', {
                text: 'COM3'
            }));
            $("#comPort").append($('<option>', {
                text: 'COM4'
            }));
            select_com_port(selected_port);
            client_available = false;
        });
    }
};


select_com_port = function (com_port) {
    if (com_port !== null) {
        $("#comPort").val(com_port);
    }
    if ($("#comPort").val() === null && $('#comPort option').size() > 0) {
        $("#comPort").val($('#comPort option:first').text());
    }
};

getComPort = function () {
    return $('#comPort').find(":selected").text();
};


function serial_console() {
    var newTerminal = false;
    if (term === null) {
        term = new Terminal({
            cols: 80,
            rows: 24,
            useStyle: true,
            screenKeys: true
        });

        newTerminal = true;
    }

    if (client_available) {
        var url = client_url + 'serial.connect';
        url = url.replace('http', 'ws');
        var connection = new WebSocket(url);

        // When the connection is open, open com port
        connection.onopen = function () {
            connection.send('+++ open port ' + getComPort());

        };
        // Log errors
        connection.onerror = function (error) {
            console.log('WebSocket Error ' + error);
            console.log(error);
            term.destroy();
        };
        // Log messages from the server
        connection.onmessage = function (e) {
            //console.log('Server: ' + e.data);
            term.write(e.data);
        };

        term.on('data', function (data) {
            //console.log(data);
            connection.send(data);
        });

        if (newTerminal) {
            term.open(document.getElementById("serial_console"));
        } else {
            term.reset();
        }
        connection.onClose = function () {
            //  term.destroy();
        };

        $('#console-dialog').on('hidden.bs.modal', function () {
            connection.close();
        });
    } else {
        term.on('data', function (data) {
            data = data.replace('\r', '\r\n');
            term.write(data);
        });

        if (newTerminal) {
            term.open(document.getElementById("serial_console"));
            term.write("Simulated terminal because you are in demo mode\n\r");

            term.write("Connection established with: " + getComPort() + "\n\r");
        }
    }

    $('#console-dialog').modal('show');
}