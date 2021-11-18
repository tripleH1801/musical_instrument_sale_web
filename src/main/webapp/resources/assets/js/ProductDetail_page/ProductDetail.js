const arrows__right = document.querySelectorAll('.arrow--right');
const arrows__left = document.querySelectorAll('.arrow--left');
const slider__image = document.querySelectorAll('.slider__image');
let clickCounter = 0;

const main_image = document.querySelector(".image img");
const sliders = document.querySelectorAll(".slider__image__frame");


sliders.forEach((slider, index) => {


    slider.addEventListener("click", () => {
        const image = slider.getElementsByClassName("slider__image__frame--detail")[0].getAttribute('src');
        main_image.src = image;



    })
})




arrows__right.forEach((arrow, index) => {
    const itemNumer = slider__image[index].querySelectorAll(".slider__image__frame").length;

    arrow.addEventListener("click", () => {
        clickCounter++;
        if (itemNumer - (3 + clickCounter) >= 0) {
            console.log(slider__image[index].computedStyleMap().get("transform"))
            slider__image[index].style.transform = `translateX(${slider__image[index].computedStyleMap().get("transform")[0].x.value
                - 116}px)`;
            arrows__left[index].style.opacity = "1";


        } else {
            slider__image[index].style.transform = "translateX(0)";

            clickCounter = 0;

            arrows__left[index].style.opacity = "0";
        }

    });

})


arrows__left.forEach((arrow, index) => {


    arrow.addEventListener("click", () => {

        clickCounter--;
        if (clickCounter === 0) {
            arrows__left[index].style.opacity = "0";
        }

        if (clickCounter < 0) {
            clickCounter = 0;
        } else {
            slider__image[index].style.transform = `translateX(${slider__image[index].computedStyleMap().get("transform")[0].x.value + 116}px)`;
        }

    });
})



const color = $(".color");

color.each(function (index) {


    $(this).click(function () {


        color.removeClass("selected__color");
        $(this).addClass("selected__color");

    })



})


// xem thêm chi tiết sản phẩm

const btn_more = document.getElementById("readmore");
const info = document.querySelector(".info__specific .info");
const fade = document.querySelector("#gradientback");

const heightDefaultCss = "500px";
const heightDefault = 500;

const height = info.clientHeight;
const actualHeight = height;

console.log(height)

if (height < heightDefault) {
    btn_more.style.display = "none";
    fade.style.display = "none";
} else {
    info.style.height = heightDefaultCss;
    btn_more.style.bottom = 0;

}


moreInfo = () => {
    info.style.height = null;
    btn_more.style.display = "none";
    fade.style.display = "none";
}