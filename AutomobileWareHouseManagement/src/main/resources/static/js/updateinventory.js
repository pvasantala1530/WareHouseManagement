function validateform() {
			let model = document.getElementById('model').value;
			let color = document.getElementById('color').value;
			let quantity = document.getElementById('quantity').value;
			let price = document.getElementById('price').value;

			if (model.length == 0) {
				let element = document.getElementById("modelerror");
				element.removeAttribute("hidden");
			}
			else
				document.getElementById('modelerror').hidden = true
				
			if (color.length == 0) {
				let element = document.getElementById("colorerror");
				element.removeAttribute("hidden");
			}
			else
				document.getElementById('colorerror').hidden = true
			
			if (quantity <= 0) {
				let element = document.getElementById("quantityerror");
				element.removeAttribute("hidden");
			}
			else if(isNaN(quantity))
			{
				let element = document.getElementById("quantitynanerror");
				element.removeAttribute("hidden");
			}
			else if(quantity>5)
			{
				let element = document.getElementById("quantitylogerror");
				element.removeAttribute("hidden");
			}
			else
				{
					document.getElementById('quantityerror').hidden = true
					document.getElementById('quantitynanerror').hidden = true
					document.getElementById('quantitylogerror').hidden = true
				}
			
			if (price <= 0) {
				let element = document.getElementById("priceerror");
				element.removeAttribute("hidden");
			}
			else if(isNaN(price))
			{
				let element = document.getElementById("pricenanerror");
				element.removeAttribute("hidden");
			}
			else
			{
				document.getElementById('priceerror').hidden = true
				document.getElementById('pricenanerror').hidden = true
				
			}
			
			if(model.length>0 && color.length>0 && quantity>0 && quantity<6 && price>0)
			{
				const form = document.getElementById("updateinv");
				form.submit();
			}

		}
