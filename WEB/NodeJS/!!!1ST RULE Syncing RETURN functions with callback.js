//_________problem ERROR script______________//

console.log(myFunc(x));

function myFunc(x)
{
	connect to something(x).....
		return 'abbbbb';
}
	// results will be 'undefined', main process kept running

//__________WITH CALLBACK function__________________//

myFunc(x,function(result){ console.log(result); });

function myFunc(x,callBackFunction)
{
	connect to something(x).....
		callBackFunction('abbbbb');
}