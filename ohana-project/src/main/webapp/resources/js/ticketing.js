function invokeCommandLink(string) {
    document.getElementById("form:region").value = string;
    const jsfCommandLink = document.getElementById("form:link");
    jsfCommandLink.click();
}
