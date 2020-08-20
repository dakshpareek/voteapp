$(function () {


   $("#siteCall").click(function () {
        console.log($('#username').val());
         var $form = $(this);
             var formData = {
                userName: $('#username').val(),
                siteId: 101
             };

      $.ajax({
         url: "/api/vote",
         type: "POST",
         contentType: "application/json; charset=utf-8",
         data: JSON.stringify(formData),
         dataType: "json",
         success: function (data, textStatus, jqXHR) {
            console.log(data);
            window.location.href = data.url;
         },
         error: function (jqXHR, textStatus, errorThrown) {
            showResponse(jqXHR.status, jqXHR.responseJSON)
         }
      });
   });


});
