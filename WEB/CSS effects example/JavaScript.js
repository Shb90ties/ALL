window.onload = installMenus;

function installMenus() {
    $('.my-bar div:nth-child(1)').click(function () {
        $('.my-bar div:nth-child(1) >div').slideToggle('fast');
    });
    $('.my-bar div:nth-child(2)').click(function () {
        $('.my-bar div:nth-child(2) >div').slideToggle('fast');
    });
    $('.my-bar div:nth-child(3)').click(function () {
        $('.my-bar div:nth-child(3) >div').slideToggle('fast');
    });

    $('.my-jumping').click(function () {
        $('html,body').animate({
            scrollTop: $('.my-info').offset().top
        });
    });

    //$( selector ).mouseenter( handlerIn ).mouseleave( handlerOut );
    $(document).on('mousemove', function (e) { TrackEvent(e); });

    $('.my-info img').mouseover(function (e) {
        TrackEvent = function (e) {
            $('.my-info-float').css({
                'display': 'block',
                'left': e.pageX,
                'top': e.pageY
            });
        }
    });

    $('.my-info img').mouseleave(function () {
        TrackEvent = function (e) { }
        $('.my-info-float').css('display', 'none');
    });
}

var TrackEvent = function(e){}