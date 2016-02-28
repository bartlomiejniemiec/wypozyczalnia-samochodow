$(document).ready(function () {
  $("#totalPrice").click(function (event) {
    var oneDayInMs = 1000 * 60 * 60 * 24;
    var beginDate = new Date($("#beginDate").val());
    var endDate = new Date($("#endDate").val());
    var beginMS = beginDate.getTime();
    var endMs = endDate.getTime();
    var days = Math.round((endMs-beginMS)/oneDayInMs);
    $("#totalPrice").text(days * $("#pricePerDay").val());
  });
});