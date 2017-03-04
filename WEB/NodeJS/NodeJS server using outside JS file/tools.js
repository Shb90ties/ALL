module.exports =
{
    Void_function: function () {
        console.log("simple void function()");
    },
    Return_function: function () {
        return 5542;
    },
    FunctionCallFunction: function () {
        console.log(do_Complicated_things());
    },
    FunctionGetsVirable: function (x, y) {
        return (x + y);
    },
	OutsideFunction: outside_Function()
};

function do_Complicated_things()
{
    var sum = 0;
    for (var i = 0; i < 15; i++)
        sum = sum + i;
    return sum;
}

function outside_Function()
{
	return 'outside';
}