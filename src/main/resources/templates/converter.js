function showDate() {
    document.getElementById("date_block").style.display = 'block';
    document.getElementById("date_label").style.display = 'block';
}
function hideDate() {
    document.getElementById("date_block").style.display = 'none';
    document.getElementById("date_label").style.display = 'none';
}

function numberKeys(event) {
    return !(event.charCode < 48 || event.charCode > 57);
}
