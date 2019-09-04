/*
	method: get | post
	url:
	data:
	
*/
function myAjax(method, url, data, deal200, deal404, deal500, async) {
	// ajax
	var ajax = getAjax();

	// onreadystatechange
	ajax.onreadystatechange = function() {
		// readyState
		if (ajax.readyState == 4) {
			// status
			if (ajax.status == 200) {
				if (deal200) {
					deal200(ajax);
				}
			} else if (ajax.status == 404) {
				if (deal404) {
					deal404(ajax);
				}
			} else if (ajax.status == 500) {
				if (deal500) {
					deal500(ajax);
				}
			}
		}
	}

	if (async == null) {
		async = true;
	}

	// open, send
	if (method == "get") {
		ajax.open(method, url + (data == null ? "" : "?" + data), async);
		ajax.send(null);
	} else if (method == "post") {
		ajax.open(method, url, async);
		ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		ajax.send(data);
	} else {

	}

}

function getAjax() {
	var ajax;
	if(window.XMLHttpRequest) {
		ajax = new XMLHttpRequest();
	} else if(window.ActiveXObject) {
		ajax = new ActiveXObject();
	}
	
	return ajax;
}


