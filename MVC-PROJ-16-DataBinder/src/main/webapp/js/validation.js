
function validate(frm){

document.getElementById("cnameErr").innerHTML="";
document.getElementById("caddErr").innerHTML="";
document.getElementById("camtErr").innerHTML="";

let name=frm.cname.value;
let addrs=frm.cadd.value;
let amt=frm.camt.value;

let flag=true;

if(name==""){
document.getElementById("cnameErr").innerHTML="Customer name is requierd";
flag=false;
}
else if(name.length<5){
document.getElementById("cnameErr").innerHTML="customer name should contain more than 5 letter";
flag=false;
}
if(addrs==""){
document.getElementById("caddErr").innerHTML="Customer address must requierd";
flag=false;
}
else if(addrs.length<5){
document.getElementById("caddErr").innerHTML="Customer address length greater than 5 letter";
flag=false;
}
if(amt==""){
document.getElementById("camtErr").innerHTML="Amount must be Field";
flag=false;
}
else if(amt<0){
document.getElementById("camtErr").innerHTML="Amount must be positive";
flag=false;
}
else if(isNaN(amt)){
document.getElementById("camtErr").innerHTML="Only neumeric value allowed"
flag=false;
}

frm.vflag.value="yes";
return flag;
}