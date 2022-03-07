//https://www.bezkoder.com/node-js-csv-mysql/
const fs = require("fs");
const mysql = require("mysql");
const fastcsv = require("fast-csv");

let stream = fs.createReadStream("DataToUpload.csv");

let csvData = [];

let csvStream = fastcsv.parse().on("data", function(data) {
  //prints out each line of data
  //could sort through data line by line (merging the names and verifying good data)
  // console.log("data1 "+data);
  var line = toString(data);
  var dataArray = line.split(","); //array of columns in one row

  console.log(dataArray);

  csvData.push(data);
});

csvStream.on("end", function() {
    csvData.shift();
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
          "INSERT INTO States (State) VALUES ?";
        connection.query(query, [csvData], (error, response) => {
          console.log(error || response);
        });
      }
    });
  });
stream.pipe(csvStream);