function validateform(){
	alert(2)
	let model = document.getElementById('model').value;
	let color = document.getElementById('color').value;
	let quantity = document.getElementById('quantity').value;
	let price = document.getElementById('price').value;
	
	if(model.length===0)
	{
		document.getElementById("modelerror").style.display = 'block';
					
	}
	
}