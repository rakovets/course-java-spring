function hide(object) {
    if ($(object).css('display') === 'none') {
        $(object).animate({height: 'show'}, 400);
    } else {
        $(object).animate({height: 'hide'}, 200);
    }
}