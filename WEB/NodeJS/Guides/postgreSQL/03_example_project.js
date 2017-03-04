var pg = require('pg');
var ReadWriteLock = require('rwlock');
var lock = new ReadWriteLock();


// work with host //_______________________________
var DatabaseURL = 'postgres://userNameINhost:passwordINhost@serverAddressINhost/DATABASEnameINhost';
pg.defaults.ssl = true;

// work with localhost // __________________________
var DatabaseURL = 'postgres://userNAME:01235@localhost:5432/myDataBase';

//לבחור רק אחד ^

    // Database function
function DB(SQLscript, CallbackFunction) {
    lock.readLock(function (release) {
        pg.connect(DatabaseURL, function (err, client, done) {
            if (err) { CallbackFunction('Database connection error'); done(); release(); return; }
            client.query(SQLscript, function (err, result) {
                if (err) {
                    CallbackFunction('SQL Command error'); done(); release(); return;
                }
                if (result.rows[0]) {
                    CallbackFunction(result.rows); done(); release(); return;
                }
                CallbackFunction('No results found'); done(); release(); return;
            });
        });
    });
}



//_________GET_from_Database(args)_______________//

function function_(args...) {
    var SQL = "SQL command Insert/SELECT/.....";
    DB(SQL, function (result) {
        print result
		print result[0]...
    });
}