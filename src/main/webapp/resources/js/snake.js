var isPaused = true;
var canvas;
var scoreLabel;
var snakeHead;
var apple;
var width = 1000;
var height = 500;
var snakeHeadPositionX = 0;
var snakeHeadPositionY = 0;
var applePositionX = 0;
var applePositionY = 0;
var direction;
var score = 0;

window.onload = function (event) {
	document.addEventListener("keydown", move);
	init();
	setInterval(loop, 90);
};

function init() {
	canvas = document.getElementById("canvas");
	scoreLabel = createScoreLabel();
	snakeHead = document.getElementById("snakeHead");
	apple = createApple();
	
	canvas.style.width = width + "px";
	canvas.style.height = height + "px";
	canvas.style.boxShadow = "0 0 0 1px rgba(150, 150, 150, 1)";
	canvas.style.display = "flex";
	
	snakeHeadPositionX = 300;
	snakeHeadPositionY = 100;
	snakeHead.style.left = snakeHeadPositionX + "px";
	snakeHead.style.top = snakeHeadPositionY + "px";
}

function loop() {
	if (!isPaused) {
		switch (direction) {
			case "left":
				snakeHead.style.left = snakeHeadPositionX - 20 + "px";
				snakeHeadPositionX = parseInt(snakeHead.style.left.slice(0, -2));
				break;
			case "top":
				snakeHead.style.top = snakeHeadPositionY - 20 + "px";
				snakeHeadPositionY = parseInt(snakeHead.style.top.slice(0, -2));
				break;
			case "right":
				snakeHead.style.left = snakeHeadPositionX + 20 + "px";
				snakeHeadPositionX = parseInt(snakeHead.style.left.slice(0, -2));
				break;
			case "down":
				snakeHead.style.top = snakeHeadPositionY + 20 + "px";
				snakeHeadPositionY = parseInt(snakeHead.style.top.slice(0, -2));
				break;
			default:
				break;
		}
	}
	
	if (snakeHeadPositionX < 0) {
		snakeHead.style.left = width - 20 + "px";
		snakeHeadPositionX = parseInt(snakeHead.style.left.slice(0, -2));
	}
	if (snakeHeadPositionY < 0) {
		snakeHead.style.top = height - 20 + "px";
		snakeHeadPositionY = parseInt(snakeHead.style.top.slice(0, -2));
	}
	if (snakeHeadPositionX >= width) {
		snakeHead.style.left = 0 + "px";
		snakeHeadPositionX = parseInt(snakeHead.style.left.slice(0, -2));
	}
	if (snakeHeadPositionY >= height) {
		snakeHead.style.top = 0 + "px";
		snakeHeadPositionY = parseInt(snakeHead.style.top.slice(0, -2));
	}
	
	if (snakeHeadPositionX === applePositionX && snakeHeadPositionY === applePositionY) {
		generateApplePosition(apple);
		score++;
		scoreLabel.innerText = "SCORE: " + score;
	}
}

function move(event) {
	if (event.keyCode === 37 && direction !== "right") { // left arrow
		isPaused = false;
		direction = "left";
	}
	if (event.keyCode === 38 && direction !== "down") { // top arrow
		isPaused = false;
		direction = "top";
	}
	if (event.keyCode === 39 && direction !== "left") { // right arrow
		isPaused = false;
		direction = "right";
	}
	if (event.keyCode === 40 && direction !== "top") { // down arrow
		isPaused = false;
		direction = "down";
	}
	if (event.keyCode === 80) { // 'p'
		isPaused = true;
		direction = "";
	}
}

function createScoreLabel() {
	var scoreLabel = document.createElement("span");
	scoreLabel.style.position = "relative";
	scoreLabel.style.left = "5px";
	scoreLabel.style.top = "5px";
	scoreLabel.style.padding = "5px";
	scoreLabel.style.height = "22px";
	scoreLabel.style.fontFamily = "Courier New";
	scoreLabel.style.fontSize = "12px";
	scoreLabel.style.lineHeight = "12px";
	scoreLabel.style.color = "rgba(255, 255, 255, 1)";
	scoreLabel.style.borderRadius = "5px";
	scoreLabel.style.backgroundColor = "rgba(255, 255, 255, 0.2)";
	scoreLabel.innerText = "SCORE: 0";
	canvas.appendChild(scoreLabel);
	return scoreLabel;
}

function createApple() {
	var apple = document.createElement("div");
	apple.style.position = "absolute";
	apple.style.width = "20px";
	apple.style.height = "20px";
	apple.style.borderRadius = "10px";
	apple.style.backgroundColor = "rgba(255, 50, 50, 1)";
	canvas.appendChild(apple);
	generateApplePosition(apple);
	return apple;
}

function generateApplePosition(apple) {
	var randomX = Math.floor(Math.random() * width / 20);
	var randomY = Math.floor(Math.random() * height / 20);
	applePositionX = randomX * 20;
	applePositionY = randomY * 20;
	apple.style.left = applePositionX + "px";
	apple.style.top = applePositionY + "px";
}
