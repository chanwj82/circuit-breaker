const http = require('http');
const server = http.createServer(async (req, res) => {
  console.log("Request is received! date : ", new Date());

  await new Promise(resolve => setTimeout(resolve, 10000));
  res.write('Hello World!');
  res.end();
});
server.listen(9090);
server.timeout = 2000;