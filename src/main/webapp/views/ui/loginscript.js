document.getElementById(show-signup).addEventListener('click',function (e){
 e.preventDefault();
 document.getElementById('loginform').style.display='none';
 document.getElementById('signupform').style.display='block';
});

document.getElementById('show-login').addEventListener('click',function(e){
    e.preventDefault();
    document.getElementById('signupform').style.display='none';
    document.getElementById('loginform').style.display='block';
});