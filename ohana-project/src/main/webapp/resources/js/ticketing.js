let cartSubTotal = 0, cartTotal = 0;
let subTotal, total;
let dynamicAmount = document.getElementsByClassName('dynamicAmount');
let fixedAmount = document.getElementsByClassName('fixedAmount');

function invokeCommandLink(string) {
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}

function increment(string1, string2) {
    let cartSubTotalMax = 0, cartTotalMax = 0;

    for (let amount of fixedAmount) {
        cartSubTotalMax += parseFloat(document.getElementById(`preTax_${string1}`).value) * string2;
        cartTotalMax += parseFloat(document.getElementById(`postTax_${string1}`).value) * string2;
    }

    for (let amount of dynamicAmount) {
        if (amount.id === string1) {
            amount.stepUp();
            assign(string1);
        }

        if (cartSubTotal > cartSubTotalMax) {
            cartSubTotal = cartSubTotalMax;
            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
        } else {
            cartSubTotal += parseFloat(document.getElementById(`preTax_${string1}`).value) * amount.value;
            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
        }

        if (cartTotal > cartTotalMax) {
            cartTotal = cartTotalMax;
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();
        } else {
            cartTotal += parseFloat(document.getElementById(`postTax_${string1}`).value) * amount.value;
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();
        }
    }
}

function decrement(string1, string2) {
    for (let amount of dynamicAmount) {
        if (amount.id === string1) {
            amount.stepDown();
            assign(string1);
        }

        if (cartSubTotal <= 0) {
            cartSubTotal = parseFloat(document.getElementById(`preTax_${string1}`).value);
            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
        } else {
            cartSubTotal -= parseFloat(document.getElementById(`preTax_${string1}`).value) * amount.value;
            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
        }

        if (cartTotal <= 0) {
            cartTotal -= parseFloat(document.getElementById(`postTax_${string1}`).value);
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();
        } else {
            cartTotal -= parseFloat(document.getElementById(`postTax_${string1}`).value) * amount.value;
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();
        }
    }
}

function assign(string) {
    document.getElementById(`subTotal_${string}`).innerHTML = (parseFloat(document.getElementById(string).value)
        * parseFloat(document.getElementById(`preTax_${string}`).value)).toString();
    document.getElementById(`total_${string}`).innerHTML = (parseFloat(document.getElementById(string).value)
        * parseFloat(document.getElementById(`postTax_${string}`).value)).toString();
}

function getVars(string1, string2) {
    document.getElementById("test:subTotal").value = string1;
    document.getElementById("test:total").value = string2;
    const jsfCommandLink = document.getElementById("test:link");
    jsfCommandLink.click();
}
