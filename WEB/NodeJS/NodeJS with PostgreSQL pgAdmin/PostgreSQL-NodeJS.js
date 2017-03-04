
var pg = require('pg');
var connect = 'postgres://UserName:Password@localhost:5432/DataBaseName';

pg.connect(connect, function (err, client, done)
{
    if (err) { console.log(err); return; }
    client.query('SELECT * FROM public."NodeJSTable"', function (err, result)
    {
        if (err) { console.log(err); return; }
		if (!result.rows[0]) { console.log("No results"); return; }
        console.log(result.rows[0]);
                    // already in JSON form
        //var rowA = result.rows[0]; var rowB = result.rows[1];
        //console.log(rowA.NameP + ' , ' + rowB.NumberP);
        done();
    });
});

	// find by NameP
pg.connect(connect, function (err, client, done) {
    if (err) { console.log(err); return; }
    client.query('Select * from "TestingTable" where "NameP" = \'KOK\'', function (err, result) {
        if (err) { console.log(err); return; }
        if (!result.rows[0]) { console.log("No results"); return; }
        console.log(result.rows[0]);
        done();
    });
});

	// insert to table
pg.connect(connect, function (err, client, done) {
    if (err) { console.log(err); return; }
    client.query('INSERT INTO public."TestingTable"("NameP", "NumberP")VALUES (\'PKG\', 500)', function (err, result) {
        if (err) { console.log(err); return; }
        if (!result.rows[0]) { console.log("No results"); return; }
        console.log(result.rows[0]);
        done();
    });
});

	// delete from table
pg.connect(connect, function (err, client, done) {
    if (err) { console.log(err); return; }
    client.query('DELETE FROM public."TestingTable" WHERE "NameP" = \'PGG\'', function (err, result) {
        if (err) { console.log(err); return; }
        if (!result.rows[0]) { console.log("No results"); return; }
        console.log(result.rows[0]);
        done();
    });
});