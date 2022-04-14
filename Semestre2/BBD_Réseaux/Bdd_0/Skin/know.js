
function showDiv(idDiv)
{
    document.getElementById("actDiv" + idDiv.toString() + "_1").style.display = "block";
    document.getElementById("actDiv" + idDiv.toString() + "_0").style.display = "none";
}

function hideDiv(idDiv)
{
    document.getElementById("actDiv" + idDiv.toString() + "_1").style.display = "none";
    document.getElementById("actDiv" + idDiv.toString() + "_0").style.display = "block";
}