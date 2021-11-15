let cartSubTotal = 0, cartTotal = 0;
let subTotal, total;
let byAmount = document.getElementsByClassName('byAmount');

function invokeCommandLink(string) {
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}

function increment(string) {
    for (let amount of byAmount) {
        if (amount.id === string) {
            amount.stepUp();
            assign(string);

            cartSubTotal += parseFloat(document.getElementById(string).value)
                * parseFloat(document.getElementById(`preTax_${string}`).value);
            cartTotal += parseFloat(document.getElementById(string).value)
                * parseFloat(document.getElementById(`postTax_${string}`).value);

            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();

            break;
        }
    }
}

function decrement(string) {
    for (let amount of byAmount) {
        if (amount.id === string) {
            amount.stepDown();
            assign(string);

            cartSubTotal -= parseFloat(document.getElementById(string).value)
                * parseFloat(document.getElementById(`preTax_${string}`).value);
            cartTotal -= parseFloat(document.getElementById(string).value)
                * parseFloat(document.getElementById(`postTax_${string}`).value);

            if (cartSubTotal <= 0 || cartSubTotal <= 0) {
                cartSubTotal = (parseFloat(document.getElementById(string).value)
                    * parseFloat(document.getElementById(`preTax_${string}`).value)).toString();
                cartTotal = document.getElementById(`total_${string}`).innerHTML = (parseFloat(document.getElementById(string).value)
                    * parseFloat(document.getElementById(`postTax_${string}`).value)).toString();
            }

            document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();
            document.getElementById("cartTotal").innerHTML = cartTotal.toString();

            break;
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
