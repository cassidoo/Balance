var cash = 5000;
var happy = 100;
var grades = 100;
var energy = 100;
var loan = 12000;
var week = 0;
var message = "";
var errorMessage = "";
var workType = 0;
var takeE = false;

function payLoan(num)
{
    if(num < 0)
    {
        $("#message h3").text("You can't pay a negative amount, silly!");
    }
    else if(num >= cash)
    {
        $("#message h3").text("Paid $" + cash + " towards your loan.");
        loan -= cash;
        cash = 0;
    }
    else
    {
        $("#message h3").text("Paid $" + num + " towards your loan.");
        loan -= num;
        cash -= num;
    }
}

function changeMessage(msg)
{
    $("#message h3").append(msg);
}

function pay()
{
    var amount = document.getElementById("payloan").value;
    console.log("Before paying: " + getLoan());
    payLoan(amount);
    console.log("After paying: " + getLoan());
    var div = document.getElementById("loanNum");
    div.innerHTML = "<h2>$" + getLoan() + "</h2>";

    setProgress("moneybar", 100, getCash());
    setProgress("gradebar", getGrades(), getGrades());
    setProgress("happybar", getHappy(), getHappy());
    setProgress("energybar", getEnergy(), getEnergy());
    //amount.value = "";
}

function updateFirst(type, answerIndex)
{
    switch (type)
    {
        case 0:
            if(answerIndex === 0)
            {
                cash -= 2500;
                happy += 10;
            }
            else if(answerIndex === 1)
            {
                cash -= 1500;
                energy -= 15;
                happy -= 10;
            }
            break;
        case 1:
            if(answerIndex === 0)
            {
                cash -= 1000;
                happy += 10;
                energy += 5;
                // 16 weeks per semester, 12 weeks during summer
                cash -= constantExpenses(32, 10);

            }
            else if(answerIndex === 1)
            {
                cash -= 150;
                energy -= 5;
                happy -= 5;
            }
            break;
        case 2:
            if(answerIndex === 0)
            {

                grades += 3;
                //weekly paid
                cash += constantExpenses(21, 7);
                workType = 1;
            }
            else if(answerIndex === 1)
            {
                grades -= 3;
                energy -= 10;
                cash += constantExpenses(35, 9);
                workType = 2;
            }
            break;
        case 3:
            if(answerIndex === 0)
            {
                cash -= 250;
                grades += 20;
            }
            else if(answerIndex === 1)
            {
                grades -= 20;
            }
            break;
        case 4:
            if(answerIndex === 0)
            {
                cash -= 750;
                grades += 10;
                happy += 10;
            }
            else if(answerIndex === 1)
            {
                grades -= 5;
            }
            break;

        default:
            break;
    }
    checkStatus();
    noOverload();
}

function updateRan(type, answerIndex)
{
    message = "";
    errorMessage = "";
    var x = takeExam();
    if(takeE)
    {
        return x;
    }
    else
    {
        //week++;
        switch (type)
        {
            case 0:
                if(answerIndex === 0)
                {
                    happy += 15;
                    energy -= 5;
                }
                else if(answerIndex === 1)
                {
                    happy -= 3;
                    energy += 1;
                }
                break;
            case 1:
                if(answerIndex === 0)
                {
                    grades -= 10;
                    energy += 7;
                    happy += 5;
                }
                else if(answerIndex === 1)
                {
                    grades += 7;
                    energy -= 3;
                }
                break;
            case 2:
                if(answerIndex === 0)
                {
                    cash -= 100;
                    grades -= 5;
                    energy += 5;
                    happy += 5;
                }
                else if(answerIndex === 1)
                {
                    grades -= 5;
                    energy -= 5;
                    happy -= 5;
                }
                break;
            case 3:
                if(answerIndex === 0)
                {
                    cash -= 75;
                    grades -= 2;
                    energy -= 15;
                    happy += 15;
                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy += 10;
                    happy -= 5;
                }
                break;
            case 4:
                if(answerIndex === 0)
                {
                    cash -= 35;
                    energy += 15;
                    happy += 15;
                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy += 10;
                    happy -= 10;
                }
                break;
            case 5:
                if(answerIndex === 0)
                {
                    cash -= 25;
                    happy += 5;
                }
                else if(answerIndex === 1)
                {
                    happy -= 5;
                }
                break;
            case 6:
                if(answerIndex === 0)
                {
                    cash += 10;
                    happy += 10;
                }
                else if(answerIndex === 1)
                {
                    happy -= 5;
                }
                break;
            case 7:
                if(answerIndex === 0)
                {
                    cash -= 500;
                    happy += 30;
                }
                else if(answerIndex === 1)
                {
                    happy -= 15;
                }
                break;
            case 8:
                if(answerIndex === 0)
                {
                    cash -= 250;
                    happy += 5;
                    grades += 15;
                }
                else if(answerIndex === 1)
                {
                    grades -= 5;
                }
                break;
            case 9:
                if(answerIndex === 0)
                {
                    grades += 10;
                    happy += 3;
                }
                else if(answerIndex === 1)
                {
                    cash += 50;
                    grades -= 3;
                    happy -= 3;
                }
                break;
            case 10:
                if(answerIndex === 0)
                {
                    cash -= 500;
                }
                else if(answerIndex === 1)
                {
                    cash -= constantExpenses(33 - week, 100);
                }
                break;
            case 11:
                if(answerIndex === 0)
                {
                    cash -= 100;
                }
                else if(answerIndex === 1)
                {
                    cash -= 50;
                    grades -= 5;
                    happy -= 5;
                    energy -= 5;
                }
                break;
            case 12:
                if(answerIndex === 0)
                {
                    cash -= 50;
                    happy += 10;
                    energy -= 5;
                }
                else if(answerIndex === 1)
                {
                    happy -= 10;
                }
                break;
            case 13:
                if(answerIndex === 0)
                {
                    cash -= 25;
                    happy += 10;
                    energy -= 5;
                }
                else if(answerIndex === 1)
                {
                    happy -= 10;
                }
                break;
            case 14:
                if(answerIndex === 0)
                {
                    energy -= 15;
                    grades += 5;
                    happy -= 7;
                }
                else if(answerIndex === 1)
                {
                    energy += 10;
                    grades -= 10;
                    happy += 3;
                }
                break;
            case 15:
                if(answerIndex === 0)
                {
                    energy -= 15;
                    grades += 5;
                    happy -= 7;
                }
                else if(answerIndex === 1)
                {
                    energy += 10;
                    grades -= 10;
                    happy += 3;
                }
                break;
            case 16:
                if(answerIndex === 0)
                {
                    energy -= 5;
                    grades += 5;
                    happy -= 10;
                }
                else if(answerIndex === 1)
                {
                    grades -= 10;
                    happy += 10;
                }
                break;
            case 17:
                if(answerIndex === 0)
                {
                    energy -= 5;
                    grades += 5;
                    happy -= 10;
                }
                else if(answerIndex === 1)
                {
                    energy -= 5;
                    grades -= 10;
                    happy += 10;
                }
                break;
            case 18:
                if(answerIndex === 0)
                {
                    cash -= 50;
                    grades += 5;
                    energy += 5;
                    happy += 5;
                }
                else if(answerIndex === 1)
                {
                    energy -= 10;
                    grades += 10;
                    happy -= 10;
                }
                break;
            case 19:
                if(answerIndex === 0)
                {
                    cash += 50;
                    grades += 5;
                    energy -= 15;
                }
                else if(answerIndex === 1)
                {
                    energy += 10;
                    happy -= 2;
                }
                break;
            case 20:
                if(answerIndex === 0)
                {
                    cash -= 15;
                    grades -= 5;
                    energy -= 15;
                    happy += 10;
                }
                else if(answerIndex === 1)
                {
                    energy += 10;
                    happy -= 10;
                    grades += 5;
                }
                break;
            case 21:
                if(answerIndex === 0)
                {
                    cash -= 300;
                    energy += 5;
                    happy += 10;
                }
                else if(answerIndex === 1)
                {
                    energy -= 20;
                    happy -= 20;
                }
                break;
            case 22:
                if(answerIndex === 0)
                {
                    cash += 20;
                    energy -= 7;
                    happy += 7;
                }
                else if(answerIndex === 1)
                {
                    energy += 5;
                    happy -= 5;
                }
                break;
            case 23:
                if(answerIndex === 0)
                {
                    happy -= 15;
                }
                else if(answerIndex === 1)
                {
                    cash -= 25;
                    happy += 10;
                }
                break;
            case 24:
                if(answerIndex === 0)
                {
                    grades += 10;
                    happy -= 5;
                    energy -= 10;
                }
                else if(answerIndex === 1)
                {
                    energy += 7;
                }
                break;
            case 25:
                if(answerIndex === 0)
                {
                    grades -= 15;
                    happy += 15;
                    energy += 15;
                    cash -= 500;
                }
                else if(answerIndex === 1)
                {
                    energy -= 5;
                    grades += 7;
                    happy -= 25;
                }
                break;
            case 26:
                if(answerIndex === 0)
                {
                    grades += 10;
                    happy -= 15;
                    energy -= 15;
                }
                else if(answerIndex === 1)
                {
                    energy += 10;
                    happy += 15;
                    grades -= 5;
                }
                break;
            case 27:
                if(answerIndex === 0)
                {
                    cash += 15;
                    happy -= 5;
                }
                else if(answerIndex === 1)
                {
                    happy -= 2;
                }
                break;
            case 28:
                if(answerIndex === 0)
                {
                    cash -= 350;
                    happy += 20;
                }
                else if(answerIndex === 1)
                {
                    happy -= 20;
                }
                break;
            case 29:
                if(answerIndex === 0)
                {
                    cash -= 150;
                    grades += 5;
                }
                else if(answerIndex === 1)
                {
                    grades -= 10;
                }
                break;
            case 30:
                if(answerIndex === 0)
                {
                    cash += 150;
                    grades -= 10;
                    energy -= 15;
                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy -= 15;
                }
                break;
            case 31:
                if(answerIndex === 0)
                {
                    cash += 50;
                    happy += 10;
                    energy -= 20;
                }
                else if(answerIndex === 1)
                {
                    grades += 5;
                    energy += 5;
                }
                break;
            case 32:
                if(answerIndex === 0)
                {
                    cash -= 500;
                    happy -= 10;
                }
                else if(answerIndex === 1)
                {
                    grades -= 10;
                    cash -= 250;
                    happy -= 10;
                }
                break;
            case 33:
                if(answerIndex === 0)
                {
                    cash += Math.floor((Math.random() * 50) + 1);
                    happy += 5;
                    energy -= 7;
                }
                else if(answerIndex === 1)
                {
                    grades += 5;
                    energy -= 5;
                }
                break;

            default:
                break;
        }//switch
        var hw = weeklyHW();
        weeklyPaid();
        checkStatus();
        noOverload();
        return hw;
    }
}

function updateDepend(type, answerIndex)
{
    message = "";
    errorMessage = "";
    var z = takeExam();
    if(takeE)
    {
        return z;
    }
    else
    {
        //week++;
        switch (type)
        {
            case 0:
                if(answerIndex === 0)
                {
                    if(grades >= 95)
                    {
                        var x = 500 + Math.floor((Math.random() * 4500) + 1);
                        cash += x;
                        happy += 20;
                        //message = "You won a $" + x + " scholarship, congrats!";
                        changeMessage("You won a $" + x + " scholarship, congrats!");
                    }
                    else if(grades >= 90)
                    {
                        var x = 500 + Math.floor((Math.random() * 1500) + 1);
                        cash += x;
                        happy += 15;
                        //message = "You won a $" + x + " scholarship, congrats!";
                        changeMessage("You won a $" + x + " scholarship, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        //message = "You didn't get the scholarship, you feel depressed from defeat.";
                        changeMessage("You didn't get the scholarship, you feel depressed from defeat.");
                    }
                }
                else if(answerIndex === 1)
                {
                    grades += 15;
                    energy -= 7;
                }
                break;
            case 1:
                if(answerIndex === 0)
                {
                    if(grades >= 85)
                    {
                        grades += 15;
                        happy += 10;
                        //message = "You got into the honors college, congrats!";
                        changeMessage("You got into the honors college, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        //message = "You didn't get into the honors college, you feel depressed from defeat.";
                        changeMessage("You didn't get into the honors college, you feel depressed from defeat.");
                    }

                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy -= 7;
                }
                break;
            case 2:
                if(answerIndex === 0)
                {
                    if(energy >= 85 && happy >= 85)
                    {
                        happy += 10;
                        energy -= 5;
                        //message = "You got the spot on the team, congrats!";
                        changeMessage("You got the spot on the team, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        energy -= 10;
                        //message = "You didn't get the spot on the team, you feel depressed from defeat.";
                        changeMessage("You didn't get the spot on the team, you feel depressed from defeat.");
                    }
                }
                else if(answerIndex === 1)
                {
                    energy -= 10;
                    happy += 5;
                }
                break;
            case 3:
                if(answerIndex === 0)
                {
                    if(grades >= 75 && happy >= 80)
                    {
                        happy += 10;
                        //message = "You got the position, congrats!";
                        changeMessage("You got the position, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        //message = "You didn't get the position, you feel depressed from defeat.";
                        changeMessage("You didn't get the position, you feel depressed from defeat.");
                    }
                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy -= 7;
                }
                break;
            case 4:
                if(answerIndex === 0)
                {
                    if(happy >= 70)
                    {
                        happy += 10;
                        cash += 10;
                        energy += 7;
                        message = "You won the contest, congrats!";
                        //changeMessage("You won the contest, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        energy -= 2;
                        //message = "You lost the contest, you feel depressed from defeat.";
                        changeMessage("You lost the contest, you feel depressed from defeat.");
                    }
                }
                else if(answerIndex === 1)
                {
                    happy += 10;
                }
                break;
            case 5:
                if(answerIndex === 0)
                {
                    if(grades >= 95)
                    {
                        var x = 500 + Math.floor((Math.random() * 4500) + 1);
                        cash += x;
                        happy += 20;
                        //message = "You won a $" + x + " scholarship, congrats!";
                        changeMessage("You won a $" + x + " scholarship, congrats!");
                    }
                    else if(grades >= 90)
                    {
                        var x = 500 + Math.floor((Math.random() * 1500) + 1);
                        cash += x;
                        happy += 15;
                        //message = "You won a $" + x + " scholarship, congrats!";
                        changeMessage("You won a $" + x + " scholarship, congrats!");
                    }
                    else
                    {
                        happy -= 10;
                        //message = "You didn't get the scholarship, you feel depressed from defeat.";
                        changeMessage("You didn't get the scholarship, you feel depressed from defeat.");
                    }
                }
                else if(answerIndex === 1)
                {
                    grades += 10;
                    energy -= 7;
                }
                break;
            default:
                break;

        }//switch
        var hw = weeklyHW();
        weeklyPaid();
        checkStatus();
        noOverload();
        return hw;
    }
}

function getCash()
{
    return cash;
}

function getGrades()
{
    return grades;
}

function getHappy()
{
    return happy;
}

function getEnergy()
{
    return energy;
}

function getWeek()
{
    return week;
}

function getLoan()
{
    return loan;
}

function addCash(x)
{
    cash += x;
}

function addHappy(x)
{
    happy += x;
}

function addGrades(x)
{
    grades += x;
}

function addEnergy(x)
{
    energy += x;
}

function addWeek(x)
{
    week += x;
}

function getMsg()
{
    return message + '\n' + errorMessage;
}

function constantExpenses(num, updateNum)
{
    return updateNum * num;
}

function takeExam()
{
    var y = "";

    takeE = false;
    if(week === 4 || week === 9 || week === 15 || week === 19 || week === 24 || week === 31)
    {
        if(grades >= 90)
        {
            grades += 5;
            happy += 5;
            y = "raised";
        }
        else if(grades >= 80)
        {
            grades += 3;
            happy += 3;
            y = "raised";
        }
        else if(grades >= 70)
        {
            // stay the same
        }
        else if(grades >= 65)
        {
            grades -= 3;
            happy -= 3;
            y = "lowered";
        }
        else
        {
            grades -= 10;
            happy -= 10;
            y = "lowered";
        }
        energy -= 15;
        //week++;

        checkStatus();
        noOverload();
        takeE = true;
        return "You had an exam this week. Your grade " + y + " to " + grades + "%.";
    }
    return y;
}

function checkStatus()
{
    if(grades <= 30)
    {
        cash -= 250;
        grades += 40;
        energy -= 15;
        errorMessage += "Your grades are too low, so you hired a tutor for $250." + '\n';
    }
    if(energy <= 20)
    {
        energy += 35;
        grades -= 25;
        errorMessage += "Your energy is too low, so you slept through your classes." + '\n';
    }
    if(happy <= 20)
    {
        cash -= 250;
        happy += 25;
        errorMessage += "Your happiness is too low, so you bought anti-depressants for $250." + '\n';
    }
    if(cash < 0)
    {
        loan += 1000;
        cash += 1000;
        errorMessage += "You do not have enough money, so you take out a $1,000 loan.";
    }
}

function noOverload()
{
    if(happy >= 100)
    {
        happy = 100;
    }
    if(energy >= 100)
    {
        energy = 100;
    }
    if(grades >= 100)
    {
        grades = 100;
    }
}

function weeklyPaid()
{
    if(workType === 1)
    {
        updateFirst(2, 0);

    }
    else if(workType === 2)
    {
        updateFirst(2, 1);
    }
}

function weeklyHW()
{
    var ranScore = Math.floor((Math.random() * 35) + 1);

    var HWGrade = 55 + ranScore;
    if(HWGrade <= 60)
    {
        grades -= 15;
    }
    else if(HWGrade <= 70 && HWGrade >= 61)
    {
        grades -= 7;
    }
    else if(HWGrade <= 80 && HWGrade >= 71)
    {
        grades += 3;
    }
    else if(HWGrade <= 90 && HWGrade >= 81)
    {
        grades += 7;
    }
    else
    {
        grades += 15;
    }
    return "You got " + HWGrade + "% on your homework for Week " + week;
}

var firstMap = [];
var firstArray = ["Do you want live on or off campus?", "Do you want a car, a bike, or to just walk campus?", "Time to pick a job", "Classes start soon, you need books for class", "Do you want a laptop for school?"];
var arr0 = ["On ($2500)", "Off ($1500)"];
var arr1 = ["Car ($1000, $10/week)", "Bike ($150)"];
var arr2 = ["On-campus: Tutor ($7/hour, 3 hours/day)", "Off-campus: Restaurant Server ($9/hour 5 hours/day)"];
var arr3 = ["Buy books ($350)", "Don't buy books"];
var arr4 = ["Buy laptop ($750)", "Don't buy laptop"];
firstMap[0] = arr0;
firstMap[1] = arr1;
firstMap[2] = arr2;
firstMap[3] = arr3;
firstMap[4] = arr4;

var randMap = [];
var randArray = ["There is a volunteer opportunity on campus this week.", "You have an assignment due for your hardest class.", "You are very sick.", "You have a free night tonight!", "You have a free weekend!", "Club Fest is on campus!", "Your best friend asks you to borrow money for a book.", "Someone lovely asks you out on a date", "There is a conference in town that could benefit your career", "There is a research opportunity this weekend for students in your major", "You have run out of meals on your meal plan.", "You borrowed your friend's car for the weekend and got a speeding ticket", "Your friend got engaged, and they are having party!", "Your friends birthday is tonight, and they are having party!", "After a late night hanging out with friends, you don't have enough time to sleep before class", "You stayed up too late marathoning your favorite TV show, you don't have enough time to sleep before class", "Your crush invites you to breakfast during your morning class!", "Your favorite band is playing at the local bar during your night class", "You forgot to do an assignment due tomorrow, and your neighbor has it done", "Your friend forgot to do an assignment due tomorrow, and you have it done", "The midnight premiere for Hunger Games: Mocking Jay is Thursday night.", "You slip on ice running to class and think you broke your arm", "Your friend is moving and offers you $20 to help!", "Your significant other wants to break up with you", "Your teacher offers you extra credit if you write a research paper", "Your friends want to take a vacation this weekend, missing two days of class", "You got snowed in, it's a snowpocalypse", "The psychology club is offering $15 to students who participate in their research", "Beyonce is in town and is playing a concert for one night only", "You lost your calculator and need to buy a new one for class", "Your boss asks you to work the weekend. You have a study group planned for your project.", "Your friends wants you to join their band- they have a gig tonight that pays $50 each", "You left your backpack unattended at the library and it was stolen", "You haven't called your parents in a while... Maybe they will give you cash?"];
var arr00 = ["Volunteer", "Don't volunteer"];
var arr01 = ["Don't do it", "Study for 3 hours"];
var arr02 = ["Go to Doctor ($100)", "Stay sick"];
var arr03 = ["Go out and PARTY ($75)", "Stay in and study"];
var arr04 = ["Go home to visit your parents ($35)", "Stay and study all weekend"];
var arr05 = ["Join clubs! ($25)", "Be antisocial"];
var arr06 = ["Give it up ($10)", "Reject them"];
var arr07 = ["Have a love life ($500)", "Be single"];
var arr08 = ["Go to conference ($250)", "Skip the conference"];
var arr09 = ["Research", "Work extra hours this weekend"];
var arr010 = ["Buy meals for the semester ($500)", "Buy meals by the week ($100/week)"];
var arr011 = ["Pay the ticket ($100)", "Contest in court and miss class ($50)"];
var arr012 = ["Buy them a present ($50)", "Skip the party"];
var arr013 = ["Buy them a present ($25)", "Skip the party"];
var arr014 = ["Go to class", "Skip class"];
var arr015 = ["Go to class", "Skip class"];
var arr016 = ["Go to class", "Skip class"];
var arr017 = ["Go to class", "Skip class"];
var arr018 = ["Pay them to do it ($50)", "Stay up all night to do it"];
var arr019 = ["Offer to do it for $50", "Go to bed"];
var arr020 = ["Go watch the spectacle ($15)", "Stay in and study"];
var arr021 = ["Pay Hospital bill ($300)", "Ignore the pain"];
var arr022 = ["Help out", "Stay in and nap"];
var arr023 = ["Let them go", "Buy them a gift to stay ($25)"];
var arr024 = ["Write it", "Don't do it"];
var arr025 = ["Go on vacation! ($500)", "Stay behind and study"];
var arr026 = ["Weather the storm", "Stay in and skip class"];
var arr027 = ["Participate", "Don't go"];
var arr028 = ["Buy a ticket ($350)", "Miss out"];
var arr029 = ["Buy it ($150)", "Don't buy it"];
var arr030 = ["Go work ($150)", "Go study"];
var arr031 = ["Rock out", "Stay in and study"];
var arr032 = ["Replace everything ($500)", "Replace only the essentials ($250)"];
var arr033 = ["Call Mom and Dad", "Go study"];

randMap[0] = arr00;
randMap[1] = arr01;
randMap[2] = arr02;
randMap[3] = arr03;
randMap[4] = arr04;
randMap[5] = arr05;
randMap[6] = arr06;
randMap[7] = arr07;
randMap[8] = arr08;
randMap[9] = arr09;
randMap[10] = arr010;
randMap[11] = arr011;
randMap[12] = arr012;
randMap[13] = arr013;
randMap[14] = arr014;
randMap[15] = arr015;
randMap[16] = arr016;
randMap[17] = arr017;
randMap[18] = arr018;
randMap[19] = arr019;
randMap[20] = arr020;
randMap[21] = arr021;
randMap[22] = arr022;
randMap[23] = arr023;
randMap[24] = arr024;
randMap[25] = arr025;
randMap[26] = arr026;
randMap[27] = arr027;
randMap[28] = arr028;
randMap[29] = arr029;
randMap[30] = arr030;
randMap[31] = arr031;
randMap[32] = arr032;
randMap[33] = arr033;

var dependMap = [];
var dependArray = ["Your guidance councelor emailed you a scholarship application", "The honors college is looking for senior applicants.", "The intramural sports team has one spot open!", "There is a leadership position open in your major.", "There is a pie-eating contest on central campus- winner gets $10!", "Your guidance councelor emailed you a scholarship application"];
var arr10 = ["Apply", "Study"];
var arr11 = ["Apply", "Study"];
var arr12 = ["Try out!", "Practice"];
var arr13 = ["Apply", "Study"];
var arr14 = ["Eat!", "Just watch"];
var arr15 = ["Apply", "Study"];
dependMap[0] = arr10;
dependMap[1] = arr11;
dependMap[2] = arr12;
dependMap[3] = arr13;
dependMap[4] = arr14;
dependMap[5] = arr15;

function getQuestion(type, index)
{
    switch(type)
    {
        case 1:
            return firstArray[index];
        case 2:
            return randArray[index];
        case 3:
            return dependArray[index];
        default:
            return randArray[index];
    }
}

function getAnswer(type, index)
{
    switch(type)
    {
        case 1:
            return firstMap[index];
        case 2:
            return randMap[index];
        case 3:
            return dependMap[index];
        default:
            return randMap[index];
    }
}

var weekNums = [];
var firstIndex = -1;
//Button stuff
function hide(type)
{
    var div = document.getElementById(type);
    div.style.display = 'none';
}

function show(type)
{
    var div = document.getElementById(type);
    div.style.display = 'block';
}

function determine(butt)
{
    ending();
    if(firstIndex == -1)
    {
        current_week = 0;
        setText(1, 0, "change");
        setButtons(1, 0, "left", "center", "right");
        firstIndex++;

    }
    else if(firstIndex == 0)
    {
        updateFirst(firstIndex, butt);

        setProgress("moneybar", 100, getCash());
        setProgress("gradebar", getGrades(), getGrades());
        setProgress("happybar", getHappy(), getHappy());
        setProgress("energybar", getEnergy(), getEnergy());
        firstIndex++;
        setText(1, firstIndex, "change");
        setButtons(1, firstIndex, "left", "center", "right");
    }
    else if(firstIndex < 4)
    {
        current_week = 0;
        if(firstIndex == 2)
        {
            var div = document.getElementById("job");
            var answer = getAnswer(1, firstIndex);
            div.innerHTML = "<h2>" + answer[butt] + "</h2>";
        }

        updateFirst(firstIndex, butt);

        setProgress("moneybar", 100, getCash());
        setProgress("gradebar", getGrades(), getGrades());
        setProgress("happybar", getHappy(), getHappy());
        setProgress("energybar", getEnergy(), getEnergy());
        firstIndex++;
        setText(1, firstIndex, "change");
        setButtons(1, firstIndex, "left", "center", "right");
    }
    else
    {
        updateFirst(firstIndex, butt);

        setProgress("moneybar", 100, getCash());
        setProgress("gradebar", getGrades(), getGrades());
        setProgress("happybar", getHappy(), getHappy());
        setProgress("energybar", getEnergy(), getEnergy());

        var current_week = 1;
        var choose;
        var depRand;
        var randRand;

        if(current_week < 33)
        {
            current_week++;
            choose = Math.floor((Math.random() * 10));
            depRand = Math.floor((Math.random() * 5));
            randRand = Math.floor((Math.random() * 32));
            if(choose < 3)
            {
                setText(3, depRand, "change");
                setButtons(3, depRand, "left", "center", "right");
                updateDepend(depRand, butt);
                //getMsg();
                $("#message h2").text("");
                $("#message h3").text(updateRan(randRand, butt) + '\n' + getMsg());
                nextWeek();
            }
            else
            {
                setText(2, randRand, "change");
                setButtons(2, randRand, "left", "center", "right");
                updateRan(depRand, butt);
                //getMsg();
                $("#message h2").text("");
                $("#message h3").text(updateRan(randRand, butt) + '\n' + getMsg());
                nextWeek();
            }

            setProgress("moneybar", 100, getCash());
            setProgress("gradebar", getGrades(), getGrades());
            setProgress("happybar", getHappy(), getHappy());
            setProgress("energybar", getEnergy(), getEnergy());
        }
        addWeek(1);
    }
}

function setText(kind, index, type)
{
    var div = document.getElementById(type);

    div.innerHTML = getQuestion(kind, index);
}

function setButtons(kind, index, type1, type2, type3)
{
    var div1 = document.getElementById(type1);
    var div2 = document.getElementById(type2);
    var div3 = document.getElementById(type3);

    var answer = getAnswer(kind, index);
    var size = answer.length;

    if(size === 2)
    {
        hide(type2);
        show(type1);
        show(type3);
        div1.innerHTML = answer[0];
        div3.innerHTML = answer[1];
    }
    else
    {
        show(type1);
        show(type2);
        show(type3);
        div1.innerHTML = answer[0];
        div2.innerHTML = answer[1];
        div3.innerHTML = answer[2];
    }
}
