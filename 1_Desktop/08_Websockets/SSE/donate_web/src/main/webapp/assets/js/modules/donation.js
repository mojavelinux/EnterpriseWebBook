define(function() {
	var donateBotton = document.getElementById('donate-botton');
	var donationAddress = document.getElementById('donation-address');
	var donateFormContainer = document.getElementById('donate-form-container');
	var customAmount = document.getElementById('customAmount');
	var donateForm = document.forms['_xclick'];
	var donateLaterLink = document.getElementById('donate-later-link');
	var checkedInd = 2;

	function showDotationForm() {
		donationAddress.style.display = "none";
		donateFormContainer.style.display = "block";
	}


	donateBotton.addEventListener('click', showDotationForm, false);

	//uncheck selected radio buttons if custom amount was choosen
	function onCustomAmountFocus() {
		for (var i = 0; i < donateForm.length; i++) {
			if (donateForm[i].type == 'radio') {
				donateForm[i].onclick = function() {
					customAmount.value = '';
				}
			}
			if (donateForm[i].type == 'radio' && donateForm[i].checked == true) {
				checkedInd = i;
				donateForm[i].checked = false;
			}
		}
	}


	customAmount.addEventListener('focus', onCustomAmountFocus, false);

	function onCustomAmountBlur() {
		var value = customAmount.value;
		if (value == '') {
			donateForm[checkedInd].checked = true;
		}
	}


	customAmount.addEventListener('blur', onCustomAmountBlur, false);

	function donateLater() {
		donationAddress.style.display = "block";
		donateFormContainer.style.display = "none";
	}


	donateLaterLink.addEventListener('click', donateLater, false);
	
	console.log('donation module was loaded');
}); 