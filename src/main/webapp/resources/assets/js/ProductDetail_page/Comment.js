const ds_cmt = document.querySelectorAll('.ds_cmt');
const rep_cmt = document.querySelectorAll('.rep_cmt');
const date = document.querySelectorAll('.date i');
ds_cmt.forEach((cmt,i) => {
    if(cmt.childElementCount < 1){
        rep_cmt[i].remove();
    }else{
        date[i].classList.add("check_rep");    
    }
});



