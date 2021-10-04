const newDate = new Date();
const date = `${newDate.getFullYear()}/${newDate.getMonth()+1}/${newDate.getDate()}`
const hours = `${newDate.getHours()}:${newDate.getMinutes()}:${newDate.getSeconds()}`
document.querySelector("#fill-date").innerHTML = `${date}`;
document.querySelector("#fill-hours").innerHTML = `${hours}`;