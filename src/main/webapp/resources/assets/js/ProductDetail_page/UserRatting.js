/*
width của ratting bằng tổng số lượng đánh giá chia 100%

tham số truyền vào là số lượng ratting của từng *

sau khi lấy được tổng số ratting thì lấy tổng số ratting chia cho 500

sau đó tìm được width tương đối

sau đó set width cho mỗi ratting *

amount_of_ratting_start




*/


/**
 * bây h là phải push vào array bao nhiêu phần trăm
 * phân trăm được tính bằng số phẩn tử chia cho tổng *100 
 * 
 */

const actual_rat = 500;
const text_amountStar = document.querySelectorAll(".amount_of_ratting_star");
var amountStar = 0
const rat_width = document.querySelectorAll(".rat");
const list_startAmount = [];
const list_startAmount_per = [];
const figure__Average = document.querySelector(".figure__average");


function getPercent(amount, total) {
	return Math.round(amount * 100 / total);
}





var totalAmountOfRat = 0;
text_amountStar.forEach(element => {

    let amount_txt = element.textContent;
    amount = Number.parseInt(amount_txt);

    totalAmountOfRat += amount;

    list_startAmount.push(amount);

    amountStar += amount;


});




for (let index = 0; index < 5; index++) {
	list_startAmount_per[index] = getPercent(list_startAmount[index], amountStar);
}



if (totalAmountOfRat !== 0) {

    rat_width.forEach((rat, index) => {
        rat.style.width = `${list_startAmount_per[index] * 0.01 * actual_rat}px`;

    });
} else {
    rat_width.forEach((rat, index) => {
        rat.style.width = `0px`;

    });
}


// const average = Math.round(amoun)
// figure__average.innerHTML = 
let averageTemp = 0;
let y = 5;
list_startAmount.forEach((item, index) => {
	averageTemp += item * y;
	y--;

})

if (totalAmountOfRat === 0) {
    figure__Average.innerHTML = `<span class="fa fa-star checked"></span>`;
} else {
    averageFormal = (averageTemp / amountStar).toFixed(2);
    figure__Average.innerHTML = `${averageFormal}<span class="fa fa-star checked"></span>`;

    
}


$('.sendEvaluate').click(function() {
	$("#type_evaluate").slideToggle();
})





//handle đánh giá user

const user_cmt = document.querySelectorAll(".user__cmt");
const cmt_evaluator = document.querySelector(".cmt__evaluate");
const btn_more_cmt = document.querySelector(".btn-morecmt");



let tempLoop = user_cmt.length;
let times = 0;
if (tempLoop > 5) {
	tempLoop = tempLoop - 5;
	cmt_evaluator.innerHTML = "";

	for (let index = 0; index < 5; index++) {
		cmt_evaluator.appendChild(user_cmt[index]);
	}

	times++;
} else {
	btn_more_cmt.remove();
}


function getMoreComment() {
	if (tempLoop > 0) {
		tempLoop = tempLoop - 5;
		times++;

		cmt_evaluator.innerHTML = "";
		if (tempLoop > 0) {
			for (let index = 0; index < times * 5; index++) {
				cmt_evaluator.appendChild(user_cmt[index]);

			}
		} else {
			for (let index = 0; index < times * 5 + tempLoop; index++) {
				cmt_evaluator.appendChild(user_cmt[index]);

			}
		}
	}

	if (tempLoop < 0) {
		btn_more_cmt.remove();
	}

}












