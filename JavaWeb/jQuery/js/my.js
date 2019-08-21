// 声明对象，全局的
// var wendao = {};

// wendao.test = function(){
	// console.log("test from my.js");
	
// }



// 使用工厂模式
(function (obj){
	// var wendao = {}; // 局部的
	
	obj.test = function(){
		console.log("工厂 test from my.js");
	}
	
	console.log("匿名自调用");
})(window); // 函数的匿名自调用

// window 为实参，obj为形参。
// 通过闭包，将test函数作为属性给与 window

// (function(形参) {})(实参);

