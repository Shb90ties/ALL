var mongoose = require('mongoose');

mongoose.connect('mongodb://localhost/DataBaseName');
var db = mongoose.connection;

db.on('error', function (err) { console.log('connection error', err); });
db.on('open', function () { console.log('connected.'); });
db.on('close', function () { console.log('closed.'); });

    // new Table structure
var mySchema = new mongoose.Schema(
{
    firstName: String,
    lastName: String
}, {collection:'TableName'});

    // Create Collection/Table ^
mongoose.model('TableName', mySchema);
    // Create a ROW format for the table
var ROW = mongoose.model('TableName');

//insertRow("Bii", "BomBom");

function insertRow(firstName_, lastName_)
{
    var newRow = ROW({ firstName: firstName_, lastName: lastName_ });
    newRow.save();
}

//selectALL();

function selectALL()
{
    ROW.find(function (err, data)
    {
        if (err) { console.log(err); return; }
        console.log(data);
        console.log('Row 1 first name = '+data[0].firstName);
    });
}

//selectByFirstName("Bob");

function selectByFirstName(firstName_)
{
    ROW.find({ firstName: firstName_ }, function (err, data)
    {
        if (err) { console.log(err); return; }
        console.log(data);
        console.log('First row found with the name('+firstName_+') = ' + data[0]);
    });
}

//updateByFirstName("Bob");

function updateByFirstName(firstName_)
{
    ROW.update({ firstName: firstName_ }, { $set: { lastName: 'AAAAAA' } }).exec();
}

//removeByFirstName("Bii"); NOT WORKING

function removeByFirstName(firstName_)
{
    ROW.remove({ firstName: firstName_ }, function (err, data)
    {
        if (err) { console.log(err); return; }
        console.log(data);
    });
}



