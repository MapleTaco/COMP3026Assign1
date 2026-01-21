<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Student Name: Daniel Perusse
	 Student ID: 200551990
	 Student Email: 200551990@student.georgianc.on.ca
	 COMP3026 - Application Security Programming
	  -->
<html>
<head>
<meta charset="UTF-8">
<title>Registration Form</title>
</head>
<body>

	<h1>Registration Form</h1>

	<form onsubmit="return validateCheckboxes(event)"
		action="<%=request.getContextPath()%>/RegisterServlet" method="post">
		<table>
			<tr>
				<!-- Required and must be of length 5 to 12 -->
				<td>User Id:</td>
				<td><input type="text" name="userId" minlength="5"
					maxlength="12" required /></td>
			</tr>
			<tr>
				<!-- Required and must be of length 7 to 12 -->
				<td>Password:</td>
				<td><input type="text" name="password" required /></td>
			</tr>
			<tr>
				<!-- Required and alphabet only -->
				<td>Name:</td>
				<td><input type="text" name="name" pattern="[A-Za-z]+" required /></td>
			</tr>
			<tr>
				<!-- Optional -->
				<td>Address:</td>
				<td><input type="text" name="address" /></td>
			</tr>
			<tr>
			<tr>
				<!-- Required and must select a country -->
				<td>Country:</td>
				<td><select name="country" required>
						<option hidden disabled selected value>-- select a
							country --</option>
						<option value="canada">Canada</option>
						<option value="us">US</option>
						<option value="other">Other</option>
				</select></td>
			</tr>
			<tr>
				<!-- Required and must follow pattern -->
				<td>Postal Code:</td>
				<td><input type="text" name="postal"
					pattern="[A-Za-z]{1}[0-9]{1}[A-Za-z]{1}[0-9]{1}[A-Za-z]{1}[0-9]{1}"
					required /></td>
			</tr>
			<tr>
				<!-- Required and must be an email -->
				<td>Email:</td>
				<td><input type="email" name="email" required /></td>
			</tr>
			<tr>
				<!-- Required -->
				<td>Sex:</td>
				<td><label> <input type="radio" name="sex" value="male"
						required /> Male
				</label> <label> <input type="radio" name="sex" value="female" />
						Female
				</label></td>
			</tr>
			<tr>
				<!-- Required, this actually needs a script since checkbox lacks functionality like radio buttons do -->
				<td>Language:</td>
				<td>
				<!-- Error message for missing checkbox. Is not pretty but it works -->
				<p class="error" id="error-message" style="display:none">At least one checkbox must
					be selected.</p>
				<label> <input type="checkbox" name="language"
						value="english" /> English
				</label> <label> <input type="checkbox" name="language"
						value="non english" /> Non English
				</label></td>
			</tr>
			<tr>
				<!-- Optional -->
				<td>About:</td>
				<td><textarea name="about" rows="8" cols="25"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

	<!-- Script for checkbox validity -->
	<script type="text/javascript">
		function validateCheckboxes(event) {
			//first we get out checkboxes
			const checkboxes = document
					.querySelectorAll('input[name="language"]');

			//loop to see if anything is checked
			for (let i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					//return true to proceed as normal
					return true;
				}
			}

			//If none is checked then prevent submission
			document.getElementById('error-message').style.display = 'block';
			event.preventDefault();
			return false;
		}
	</script>

</body>
</html>