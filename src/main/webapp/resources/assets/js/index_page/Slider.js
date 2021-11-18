const arrows = document.querySelectorAll('.arrow');
const arrows__left = document.querySelectorAll('.arrow--left');
const product__list = document.querySelectorAll('.product__option__list');
let clickCounter = 0;




arrows.forEach((arrow, index) => {
    const value = product__list[index].querySelectorAll("img").length;
    const itemNumer = Math.ceil(value / 5);
    
    console.log(product__list);
    console.log(value);
    console.log(itemNumer);


    arrow.addEventListener("click", () => {
        clickCounter++;
        console.log("add ", clickCounter)
        if (itemNumer - (1 + clickCounter) >= 0) {
            product__list[index].style.transform = `translateX(${product__list[index].computedStyleMap().get("transform")[0].x.value
                - 1140}px)`;
            arrows__left[index].style.opacity = "0.5";

        } else {
            product__list[index].style.transform = "translateX(0)";

            clickCounter = 0;

            arrows__left[index].style.opacity = "0";
        }

    });

})


arrows__left.forEach((arrow, index) => {
    const itemNumer = product__list[index].querySelectorAll("img").length;

    arrow.addEventListener("click", () => {

        clickCounter--;
        if (clickCounter === 0) {
            arrows__left[index].style.opacity = "0";
        }

        if (clickCounter < 0) {
            clickCounter = 0;
        } else {
            product__list[index].style.transform = `translateX(${product__list[index].computedStyleMap().get("transform")[0].x.value + 1140}px)`;
        }

    });
})



