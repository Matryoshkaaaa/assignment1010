$().ready(function () {
  $("#email").on("keyup", function () {
    $.get(
      "/member/regist/available",
      { email: $(this).val() },
      function (response) {
        // 응답이 없을 때 function으로 돌려받는다.
        var email = response.email;
        var available = response.available;

        console.log(email);
        console.log(available);

        if (available) {
          $("#email").addClass("available");
          $("#email").removeClass("unusable");
          //   $("input[type=submit]").removeAttr("disabled");
        } else {
          $("#email").addClass("unusable");
          $("#email").removeClass("available");
          //   $("input[type=submit]").Attr("disabled", "disabled");
        }
      }
    );
  });
});
