<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>جستجو</title>
</head>

<body>
<form id="search" action="/search">
	<fieldset class="center">
		نوع مشتری: <br>
		<select id="customerType" name="customerType" onchange="byType(this.value)" class="fixed">
			<option selected disabled hidden style='display: none' value=''></option>
			<option value="natural">مشتری حقیقی</option>
			<option value="legal">مشتری حقوقی</option>
		</select>

		<br>جستجو بر اساس: <br>
		<select id="customerField" name="customerField" selected="id" class="fixed">
			<option data-option="natural" value="firstName">نام</option>
			<option data-option="natural" value="lastName">نام خانوادگی</option>
			<option data-option="natural" value="idCode">کد ملی</option>
			<option data-option="natural" value="id">شماره مشتری</option>
			<option data-option="legal" value="name">نام شرکت</option>
			<option data-option="legal" value="eCode">کد اقتصادی</option>
			<option data-option="legal" value="id">شماره مشتری</option>
		</select>

		<br>مقدار مورد نظر:<br>
		<input type="text" name="field" class="fixed">
		<br>
		<input type="submit" value="جستجو">

		<script type="text/javascript">
			var sel1 = document.querySelector('#customerType');
			var sel2 = document.querySelector('#customerField');
			var options2 = sel2.querySelectorAll('option');

			function byType(selValue) {
				sel2.innerHTML = '';
				for (var i = 0; i < options2.length; i++) {
					if (options2[i].dataset.option == selValue) {
						sel2.appendChild(options2[i]);
					}
				}
			}
			byType(sel1.value);
		</script>
	</fieldset>
</form>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
