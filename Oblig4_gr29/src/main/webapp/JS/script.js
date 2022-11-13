
class Paamelding {

	#passwordInputElement = document.getElementById('passord');
	#repeatedPasswordInputElement = document.getElementById('passordRepetert');
	constructor() {
		const passWordRepeated = this.#repeatedPasswordInputElement;
		const password = this.#passwordInputElement;

		password.addEventListener("input", this.#checkPasswordStrength.bind(this));
		password.addEventListener("change", this.#doesMatch.bind(this));
		passWordRepeated.addEventListener("change", this.#doesMatch.bind(this));


	}
	/**
	 *	This method will check the password strength by comparing the input password, in real-time,
	 * 	with regex expressions that determine whether a password is sufficiently strong.
	 */
	#checkPasswordStrength() {
		//the password contains more than 6 characters, both lower and upper case letters, as well as a number
		let mediumPassword = new RegExp('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{6,})')
		//additionally checks if the password is more than eigth characters, and if it contains special characters
		let strongPassword = new RegExp('(?=.*[a-z])(?=.*[A-Z])(?=.*[^A-Za-z0-9])(?=.{8,})')
		this.#passwordInputElement.oninput = function() {
			const passwordValue = this.value;

			if (passwordValue.match(mediumPassword)) {
				this.classList.add("mediumPassword");
			}
			if (passwordValue.match(strongPassword)) {
				this.classList.remove("mediumPassword");
			}
		}
	}

	


	#doesMatch() {
		const passWordRepeated = this.#repeatedPasswordInputElement;
		const password = this.#passwordInputElement;
		if (passWordRepeated.value === password.value) {
			passWordRepeated.setCustomValidity("");
		} else {
			passWordRepeated.setCustomValidity("Passwords do not match");
		}
	};

}

function init() {
	new Paamelding();
}

/**
 * Runs the script -> same as addEventListener('DOMContentLoaded', init());
 */

init();