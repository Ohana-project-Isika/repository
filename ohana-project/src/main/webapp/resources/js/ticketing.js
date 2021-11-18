function invokeCommandLink(string) {
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}

function getVars(string1, string2) {
    document.getElementById("test:subTotal").value = string1;
    document.getElementById("test:total").value = string2;
    const jsfCommandLink = document.getElementById("test:link");
    jsfCommandLink.click();
}

function getCardInfo(cardNumber, fullName, expiry, cvc) {
    document.getElementById("card:cardNumber").value = cardNumber;
    document.getElementById("card:fullName").value = fullName;
    document.getElementById("card:expiryDate").value = expiry;
    document.getElementById("card:cvcNumber").value = cvc;
    const jsfCommandLink = document.getElementById("card:link");
    jsfCommandLink.click();
}

function myFunction() {
    var x = document.getElementById("idf");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}

function returnCommandlink() {
    document.getElementById("return:url").value = "http://localhost:3000/return";
    const jsfCommandLink = document.getElementById("test:link");
    jsfCommandLink.click();
}
