var weekNums = [];

function populateWeeks()
{
    for(var i = 0; i < 32; i++)
    {
        weekNums[i] = i + 1;
        document.getElementById("weeks").innerHTML += "<span>" + weekNums[i] + "</span>";
    }
}

function nextWeek()
{
    $("#weeks").children().first().fadeOut("slow", function()
    {
        //$("#weeks").children().first().remove();
    });
    weekNums.splice(0, 1);
}

function setProgress(id, level, val)
{
    var bar = document.getElementById(id);

    bar.innerHTML = '<div class="level"><div class="bub"></div>';

    if( typeof val != "undefined")
    {
        bar.innerHTML += '<span class="pval">' + val + '</span>';
    }

    bar.innerHTML += '</div>';
    console.log(bar.innerHTML);

    var levelBar = $("#" + id + " .level");

    levelBar.css('width', level + '%');

    if(level > 65)
    {
        levelBar.addClass("high");
    }
    else if(level >= 45)
    {
        levelBar.addClass("medium");
    }
    else
    {
        levelBar.addClass("low");
    }
}