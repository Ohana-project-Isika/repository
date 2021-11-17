let subTotal, total;
let dynamicAmount = document.getElementsByClassName('dynamicAmount');
let fixedAmount = document.getElementsByClassName('fixedAmount');

if (document.readyState == 'loading') {
    document.addEventListener('DOMContentLoaded', ready)
} else {
    ready();
}

function ready() {
    let removeButtons = document.getElementsByClassName('remove');
    for (let removeButton of removeButtons) {
        let removeButtonId = removeButton.id.substring(removeButton.id.indexOf('_') + 1);
        console.log("id", removeButtonId)
        console.log("id", removeButton.value)
        for (let amount of dynamicAmount) {
            if (amount.id === removeButtonId)
                removeButton.addEventListener('click', removeEvent);
        }
    }
}

function removeEvent(event) {
    let buttonClicked = event.target;
    buttonClicked.parentElement.parentElement.remove();
    updateTotal();
}

function updateTotal(eventId, eventQuantity) {
    let cartSubTotal = 0, cartTotal = 0;

    if (eventId === undefined) {
        console.log("remove", document.getElementById(eventId))
        document.getElementById("cartSubTotal").innerHTML = "";
        document.getElementById("cartTotal").innerHTML = "";
    } else {
        for (let amount of fixedAmount) {
            let subTotal = parseFloat(document.getElementById(`preTax_${eventId}`).value);
            let total = parseFloat(document.getElementById(`postTax_${eventId}`).value);

            cartSubTotal += subTotal * eventQuantity;
            cartTotal += total * eventQuantity;
        }

        cartSubTotal = Math.round(total * 100) / 100;
        document.getElementById("cartSubTotal").innerHTML = cartSubTotal.toString();

        cartTotal = Math.round(total * 100) / 100;
        document.getElementById("cartTotal").innerHTML = cartSubTotal.toString();
    }
}

function invokeCommandLink(string) {
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}

function increment(eventId, ticketQuantity) {
    for (let amount of dynamicAmount) {
        if (amount.id === eventId) {
            amount.stepUp();
            innerJSF(eventId, amount);
            updateTotal(eventId, ticketQuantity);
            break;
        }
    }
}

function decrement(eventId, ticketQuantity) {
    for (let amount of dynamicAmount) {
        if (amount.id === eventId) {
            amount.stepDown();
            innerJSF(eventId, amount);
            updateTotal(eventId, ticketQuantity);
            break;
        }
    }
}

function innerJSF(eventId, amount) {
    console.log(document.getElementById(`subTotal_${eventId}`), document.getElementById(`preTax_${eventId}`));
    document.getElementById(`subTotal_${eventId}`).innerHTML = (amount.value
        * parseFloat(document.getElementById(`preTax_${eventId}`).value)).toString();
    document.getElementById(`total_${eventId}`).innerHTML = (amount.value
        * parseFloat(document.getElementById(`postTax_${eventId}`).value)).toString();
}

function getVars(string1, string2) {
    document.getElementById("test:subTotal").value = string1;
    document.getElementById("test:total").value = string2;
    const jsfCommandLink = document.getElementById("test:link");
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
