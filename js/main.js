var weekNums = [];

/*function setLogo()
{
    var w = $(window).width();
    if(w > 1600) w = 1600;
    var position = (w / 2) - ($("#logoimage").width());
    $("#logoimage").css("left", position);
    console.log("positioned");
}*/

function populateWeeks()
{
    for(var i = 0; i < 32; i++)
    {
        weekNums[i] = i + 1;
        document.getElementById("weeks").innerHTML += "<span>" + weekNums[i] + "</span>";
    }
}

function ending()
{
    if(week >= 33)
    {
        $("#stuff").fadeOut("slow", function()
        {
            if(loan > 0)
            {
                $(".declaration").css("display", "block");
            }
            else
            {
                $(".declarationw").css("display", "block");
            }
        });
    }
}

function nextWeek()
{
    $("#weeks").children().first().fadeOut("fast", function()
    {
        $("#weeks").children().first().remove();
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