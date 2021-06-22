let status = document.getElementById('status');

let user = document.getElementsByName('txtusername')[0];
let pass = document.getElementsByName('txtpassword')[0];

document.getElementsByClassName('btn-custom submit')[0].onclick = function(
		event) {
	event.preventDefault();
	duyetData(user.value, pass.value);
}

function duyetData(user, pass) {
	status.setAttribute("class", "log login");

	if (user.length == 0) {
		status.innerHTML = "ユーザーIDを入力してください。";
		status.classList.toggle("faild");
	}

	else if (pass.length == 0) {
		status.innerHTML = "パスワードを入力してください。";
		status.classList.toggle("faild");
	} else {
		document.getElementById("formlogin").submit();
	}

}

document.getElementsByClassName('btn-custom clear')[0].onclick = function(event) {
	status.innerHTML = "";
	clear();
}

function clear() {
	let x = document.getElementsByClassName('text-field');

	for (let i = 0; i < x.length; i++) {
		x[i].value = "";
	}
}
