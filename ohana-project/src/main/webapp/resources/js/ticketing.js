function invokeCommandLink(string) {
    console.log(string);
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}

function increment() {
    document.getElementById('byAmount').stepUp();
    document.getElementById("subTotal").innerHTML = parseFloat(document.getElementById("byAmount").value)
        * parseFloat(document.getElementById("preTax").value);
    document.getElementById("total").innerHTML = parseFloat(document.getElementById("byAmount").value)
        * parseFloat(document.getElementById("postTax").value);
}
function decrement() {
    document.getElementById('byAmount').stepDown();
    document.getElementById("subTotal").innerHTML = parseFloat(document.getElementById("byAmount").value)
        * parseFloat(document.getElementById("preTax").value);
    document.getElementById("total").innerHTML = parseFloat(document.getElementById("byAmount").value)
        * parseFloat(document.getElementById("postTax").value);;
}

function getVars() {
    document.getElementById("test:hiddenTotal").value = parseFloat(document.getElementById("byAmount").value)
        * parseFloat(document.getElementById("postTax").value);
}

