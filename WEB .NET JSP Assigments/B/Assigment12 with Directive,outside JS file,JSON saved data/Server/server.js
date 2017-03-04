var express = require('express');
var app = express();
var port = 12345;
app.listen(port);
console.log('Server running on port ' + port);
var Game;

var tools = require('./tools.js');
var file = __dirname + '\\data.json';
var jsonFile = require('jsonfile');
var fs = require('fs');

GetGame();
setTimeout(function () { tools.printGame(Game); }, 500);


app.get('/', function (request, response)
{
    console.log('Request came in ' + request.query.action);
    switch (request.query.action)
    {
        case 'GetGame':
            response.send(JSON.stringify(Game));
            break;
        case 'Move':
            MoveRequest(response, JSON.parse(request.query.Virbls));
            break;
    }
});

function GetGame()
{
    fs.readFile('data.json', 'utf8', function (err, data)
    {
        if (err)
            MakeGame();
        else
            Game = JSON.parse(data);
    });
}

function MakeGame()
{
    Game = new Object();
    Game.nums = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0];
    Game.colrs = new Array(16);
    for (var i = 0; i < 16; i++)
    {
        var a = Math.floor((Math.random() * 15));
        var b = Math.floor((Math.random() * 15));
        var temp = Game.nums[a];
        Game.nums[a] = Game.nums[b];
        Game.nums[b] = temp;
        Game.colrs[i] = 'rgb(' + tools.Cfloor() + ',' + tools.Cfloor() + ',' + tools.Cfloor() + ')';
    }
    Game.emptyID = 15;
    SaveFile();
}

function MoveRequest(response, virables)
{
    console.log(virables.id + ':' + virables.BG);
    var myID = parseInt(virables.id); var empty = parseInt(Game.emptyID);
    var answer = new Object(); answer.Winner = 'false';
    if (myID + 4 == empty || myID - 4 == empty || (myID + 1 == empty && (myID + 1) % 4 != 0) || (myID - 1 == empty && (myID) % 4 != 0))
    {
        answer.verdict = 'Move';
        answer.myID = myID; answer.empty = empty;
        var ColorA = tools.GetRedGreebBlue(Game.colrs[myID]);
        var ColorB = tools.GetRedGreebBlue(virables.BG);
        answer.color = tools.GetAverageColor(ColorA, ColorB);
        switch_(myID, empty);
        answer.Winner = checkWinner();
        response.send(JSON.stringify(answer));
    }
    else
    {
        answer.verdict = 'unMovable';
        response.send(JSON.stringify(answer));
    }
}

function switch_(myID,empty)
{
    var tempN = Game.nums[myID]; var tempC = Game.colrs[myID];
    Game.nums[myID] = Game.nums[empty]; Game.colrs[myID] = Game.colrs[empty];
    Game.nums[empty] = tempN; Game.colrs[empty] = tempC;
    Game.emptyID = myID;
    SaveFile();
}

function SaveFile()
{
    jsonFile.writeFile(file, Game, function (err)
    {
        if (err)
            console.log('failed to save data ' + err);
    });
}

function checkWinner()
{
    if (parseInt(Game.nums[0]) == 1 && parseInt(Game.nums[1]) == 2)
    {
        MakeGame();
        tools.printGame(Game);
        return 'true';
    }
    return 'false';
}
