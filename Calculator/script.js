function clearScreen()
{
    document.getElementById("result").value = "";
}
// displaying
function display(value)
{
    document.getElementById("result").value += value;
}
//Evaluates and return the value
function calculate()
{
    var p = document.getElementById("result").value;
    var q = eval(p);
    document.getElementById("result").value = q;
}