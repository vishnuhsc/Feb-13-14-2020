let app = require("express")();
app.get("/hello", (req, res) => {
	res.send("Hello NodeJS");
});
app.listen(3000);
console.log("Server started in 3000");