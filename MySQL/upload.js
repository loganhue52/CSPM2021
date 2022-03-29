//https://www.bezkoder.com/node-js-csv-mysql/
const fs = require("fs");
const mysql = require("mysql");
const fastcsv = require("fast-csv");

let stream = fs.createReadStream("usersData.csv");

let csvData = [];

let csvStream = fastcsv.parse().on("data", function(data) {
  csvData.push(data);
});

csvStream.on("end", function() {
    // csvData.shift();
    // create a new connection to the database
    const connection = mysql.createConnection({
        host: "localhost",
        user: "sictc",
        password: "Pencil1",
        database: "IoT"
    });
    
    // open the connection
    connection.connect(error => {
      if (error) {
        console.error(error);
      } else {
        let query =
          "INSERT INTO Users (AccountId,Email,LastName,FirstName,Password) VALUES ?";
        connection.query(query, [csvData], (error, response) => {
          console.log(error || response);
        });
      }
    });
  });
stream.pipe(csvStream);