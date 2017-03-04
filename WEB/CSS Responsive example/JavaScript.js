window.onload = setMenuHeights;
$(window).resize(setMenuHeights);

function setMenuHeights()
{
    var height = $('.container').height();
    $('#w').html('width : ' + Math.floor($('body').width()));
        // some browsers have a -30 delay <= 738 for edge,chrome
    if (Math.floor($('body').width()) <= 768)
        height = 'auto';
    $('[class*="bod-"]').css('height', height);
}