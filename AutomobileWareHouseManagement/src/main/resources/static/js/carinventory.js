
		function gotoAddInventory(warehouseId) {

			var ele = document.getElementsByName('add_inv');
			let flag = 0;
			for (i = 0; i < ele.length; i++) {
				if (ele[i].checked) {
					flag = 1;
					let carmake = document.getElementById(ele[i].value).value;
					window.location.href = "new/" + warehouseId + "/" + ele[i].value + "/" + carmake;
				}
			}
			if (flag == 0)

				alert('Select Car Brand to add Inventory');
		}

		function gotoAddMake(warehouseId) {


			var carmake = document.getElementById('newcarmake').value;

			if (carmake.length == 0) {
				alert('Car Make cannot be empty');
			}

			if (carmake.length > 0) {
				window.location.href = "newmake/" + warehouseId + "/" + carmake;
			}
		}

		function showinventorydetails(carmakeId, warehouseId) {

			let xhr = new XMLHttpRequest();

			let resp;
			// Making our connection 
			let url = 'showinventorydetails/' + carmakeId;
			xhr.open("GET", url, true);

			// function executes after request is successful
			xhr.onreadystatechange = function () {
				if (this.readyState == 4 && this.status == 200) {

					resp = JSON.parse(this.responseText);
					console.log(resp);
					let text = "";

					let formatting_options = {
						style: 'currency',
						currency: 'USD',
						minimumFractionDigits: 0,
					}
					
					let dollarString = new Intl.NumberFormat("en-US", formatting_options);
						

					resp.forEach(function (item, index) {
						
						let finalPrice = dollarString.format(item.price);
						
						text = text + "<tr><td>" + item.model + "</td>" +
							"<td> " + item.color + "</td>" +
							"<td>" + finalPrice + "</td>" +
							"<td>" + item.quantity + "</td>" +
							"<td><a href='/autoinventorycontrol/inventory/edit/" +
							item.inventoryid + "/" +
							item.carmakeid + "/" +
							item.carmake + "/" +
							"' class='btn btn-primary'>Update</a>" +
							"<span>    </span>" +
							"<a href='/autoinventorycontrol/deleteinventory/" +
							item.inventoryid + "/" +warehouseId+  "/" +
							"' class='btn btn-danger'>Delete</a>" +

							"</td></tr><tr>";
					});

					document.getElementById("inventoryDets").innerHTML = text;
					let element = document.getElementById("inventoryDetstab");
					let hidden = element.getAttribute("hidden");
					if (hidden) {
						element.removeAttribute("hidden");

					}
				}
			}
			// Sending our request
			xhr.send();
		}
