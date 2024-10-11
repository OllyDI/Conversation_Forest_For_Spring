$(document).ready(function () {
    $("#email").on("focusout", function (e) {
        var id = $("#email").val();
        if (id == '' || id.length == 0) { return false; }

        //Ajax로 전송
        $.ajax({
            url: '/duplicate',
            data: {
                email: id
            },
            type: 'POST',
            datatype: 'json',
            success: function (result) {
                if (result == true) {
                    $("#reg").attr("type", "submit");
                    $("#lEmail").css("color", "black").text("사용 가능한 ID 입니다.");
                } else {
                    $("#reg").attr("type", "button");
                    $("#lEmail").css("color", "red").text("사용 불가능한 ID 입니다.");
                }
            }
        });
    });
})
