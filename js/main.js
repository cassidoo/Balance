var weekNums = [];

function populateWeeks()
{
    for(var i = 0; i < 32; i++)
    {
        weekNums[i] = i+1; 
        document.getElementById("weeks").innerHTML += "<span>" + weekNums[i] + "</span>";
    } 
}

