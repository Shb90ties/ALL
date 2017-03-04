$(document).ready(onLoad);

function onLoad()
{
    $("li").click(function () {
        $(".changers").css({
            'background-color': 'black',
            'color': 'aqua'
        });
        $(".changers").mouseover(function () {
            $("li").css({
                'background-color': 'red',
                'color': 'brown'
            });
        });
        $(".changers").mouseout(function () {
            $('li').attr("class", "changers");
        });
    });
    $("form").on("submit", onSubmit);
}

function onSubmit() {
    var txt = $('input[type=text]').val(); 
    var lastLi = $('ul li').html();
    var string = txt + '<br>' + lastLi;

    var $newLi = $('<li>' + string + '</li>');
    $('ul').append($newLi);
}