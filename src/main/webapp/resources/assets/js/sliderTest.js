const arrows = document.querySelectorAll('.arrow');
const arrows__left = document.querySelectorAll('.arrow--left');
const movieList = document.querySelectorAll('.movie__list');
let clickCounter = 0;




arrows.forEach((arrow, index) => {
    const itemNumer = movieList[index].querySelectorAll("img").length;


    arrow.addEventListener("click", () => {
        clickCounter++;
        console.log("add ", clickCounter)
        if (itemNumer - (5 + clickCounter) >= 0) {
            movieList[index].style.transform = `translateX(${movieList[index].computedStyleMap().get("transform")[0].x.value
                - 300}px)`;
            arrows__left[index].style.opacity = "0.5";

        } else {
            movieList[index].style.transform = "translateX(0)";

            clickCounter = 0;

            arrows__left[index].style.opacity = "0";
        }

    });

})


arrows__left.forEach((arrow, index) => {
    const itemNumer = movieList[index].querySelectorAll("img").length;

    arrow.addEventListener("click", () => {

        clickCounter--;
        if (clickCounter === 0) {
            arrows__left[index].style.opacity = "0";
        }

        if (clickCounter < 0) {
            clickCounter = 0;
        } else {
            movieList[index].style.transform = `translateX(${movieList[index].computedStyleMap().get("transform")[0].x.value + 300}px)`;
        }

    });
})



