				// npm install readline
const readline = require("readline");

const RL = readline.createInterface({ input: process.stdin, output: process.stdout });

RL.question('type something : ', function (answer) { console.log(answer); RL.close(); });

     // (answer) => { }/  short cut for function(answer){ }
//RL.question('type something ', (answer) => {
//    console.log('you typed ', answer)
//    RL.close();
//});


