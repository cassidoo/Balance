var weekNums = [];

function populateWeeks()
{
    for(var i = 0; i < 32; i++)
    {
        weekNums[i] = i + 1;
        document.getElementById("weeks").innerHTML += "<span>" + weekNums[i] + "</span>";
    }
}

function setProgress(id, level)
{
    var bar = document.getElementById(id);

    bar.innerHTML = '<div class="level"><div class="bub"></div></div>';

    var levelBar = $("#" + id + " .level");

    levelBar.css('width', level + '%');

    if(level > 65)
    {
        levelBar.addClass("high");
    }
    else if(level >= 35)
    {
        levelBar.addClass("medium");
    }
    else
    {
        levelBar.addClass("low");
    }
}