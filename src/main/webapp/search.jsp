<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>جستجو</title>
	<script>
		function byType() {
			if (document.getElementById('fieldsByType').childElementCount > 0){
				var oldFields = document.getElementById('fieldsByType').children;
				for (i = 0; i < oldFields.length; i++) {
					document.getElementById('fieldsByType').removeChild(oldFields[i]);
				}
			}
			if (document.getElementById("customerType").value == "natural"){
				var fields = document.createElement('select');
				fields.id = "fields";
				fields.tagName = "fields";
				fields.innerHTML = "<option selected disabled hidden style='display: none' value=''></option>\n<option id='field1' value=\"firstName\">نام</option>\n<option id='field2' value=\"lastName\">نام خانوادگی</option>\n<option id='field3' value=\"idCoe\">کد ملی</option>\n<option id='field4' value=\"id\">شماره مشتری</option>";
				document.getElementById("fieldsByType").appendChild(fields);
			}
			else if (document.getElementById("customerType").value == "legal"){
				var fields = document.createElement('select');
				fields.id = "fields";
				fields.tagName = "fields";
				fields.innerHTML = "<option selected disabled hidden style='display: none' value=''></option>\n<option id='field1' value=\"name\">نام شرکت</option>\n<option id='field2' value=\"eCode\">کد اقتصادی</option>\n<option id='field3' value=\"id\">شماره مشتری</option>";
				document.getElementById("fieldsByType").appendChild(fields);
			}
		}
		
		function addInput() {
			var input = document.createElement('input');
			input.type = "text"
			input.name = "value";
			document.getElementById("input").appendChild(input);

			var bottun = document.createElement('input');
			bottun.type = "submit"
			bottun.value = "جستجو";
			document.getElementById("input").appendChild(bottun);
		}
	</script>
</head>
<body>
<form id="search">
	<div id="type" name="type">
		<p>نوع مشتری:</p>
		<select id="customerType" name="customerType" onchange="byType()">
			<option selected disabled hidden style='display: none' value=''></option>
			<option value="natural">مشتری حقیقی</option>
			<option value="legal">مشتری حقوقی</option>
		</select>
	</div>

	<div id="fieldsByType" name="field" onchange="addInput()">
	</div>

	<p id="input" class="center"></p>

</form>
</body>
</html>
