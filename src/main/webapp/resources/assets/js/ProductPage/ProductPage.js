const popular = $(".checked--popular");
const selling = $(".checked--selling");
const new_bar = $(".checked--new");

const bar_popular = $(".bar--popular");
const bar_new = $(".bar--new");
const bar_selling = $(".bar--selling");

if (bar_popular.hasClass("active")) {

    (popular).on({
        click: function (event) {

            bar_popular.addClass("active");
            bar_new.removeClass("active");
            bar_selling.removeClass("active");


            console.log("ádfsafasfasdf");
            event.preventDefault();
        }
    });
}


if (!bar_new.hasClass("active")) {

    (new_bar).on({
        click: function (event) {

            bar_new.addClass("active");
            bar_popular.removeClass("active");
            bar_selling.removeClass("active");


            event.preventDefault();
        }
    });
}


if (!bar_selling.hasClass("active")) {

    (selling).on({
        click: function (event) {

            bar_selling.addClass("active");
            bar_popular.removeClass("active");
            bar_new.removeClass("active");

            event.preventDefault();

        }
    });
}








