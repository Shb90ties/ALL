module.exports = 
{
    Cfloor: function () { return Math.floor(Math.random() * 170); },
    printGame: function (Game)
    {
        for (var i = 0; i < 16; i++)
            console.log(i + ')' + Game.nums[i] + ' , ' + Game.colrs[i]);
        console.log('EmptyID = ' + Game.emptyID);
    },
    GetRedGreebBlue: function (rgbColor)
    {
        var color = new Object();
        rgbColor = rgbColor.replace(/[^\d,]/g, '').split(',');
        color.red = parseInt(rgbColor[0]); color.green = parseInt(rgbColor[1]); color.blue = parseInt(rgbColor[2]);
        return color;
    },
    GetAverageColor: function (ColorA, ColorB)
    {
        var red = (Math.floor((ColorA.red + ColorB.red) / 2));
        var green = (Math.floor((ColorA.green + ColorB.green) / 2));
        var blue = (Math.floor((ColorA.blue + ColorB.blue) / 2));
        return 'rgb('+red+', '+green+', '+blue+')';
    }
};
