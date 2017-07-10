<%@page pageEncoding="UTF-8" language="java" %>
<%@page contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<META http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>مشتری حقیقی جدید</title>

	<script>
		function Validate() {
			var frm = document.naturalForm;
			if (frm.firstName.value == "") {
				alert("وارد کردن نام الزامی است!");
				return false;
			} else if (frm.lastName.value == "") {
				alert("وارد کردن نام خانوادگی الزامی است!");
				return false;
			} else if (frm.fatherName.value == "") {
				alert("وارد کردن نام پدر الزامی است!");
				return false;
			} else if (frm.birthDate.value == "") {
				alert("وارد کردن تاریخ تولد الزامی است!");
				return false;
			} else if (frm.code.value == "") {
				alert("وارد کردن کد ملی الزامی است!");
				return false;
			}
			return true;
		}
		function Clicked(){
			if (Validate()){
				document.naturalForm.submit();
			}
		}
	</script>
</head>
<body>
<h3 class="center">اطلاعات مورد نیاز: </h3>
<div>
	<form action="newCustomer" name="naturalForm">
		<table>
			<tr>
				<td>نام:</td>
				<td><input type="text" id="first" name="firstName" class="fixed"><br></td>
			</tr>
			<tr>
				<td>نام خانوادگی:</td>
				<td><input type="text" name="lastName" class="fixed"></td>
			</tr>
			<tr>
				<td>نام پدر:</td>
				<td><input type="text" name="fatherName" class="fixed"></td>
			</tr>
			<tr>
				<td>تاریخ تولد:</td>
				<td><input type="date" name="birthDate" class="fixed"></td>
			</tr>
			<tr>
				<td>کد ملی:</td>
				<td><input type="text" name="code" class="fixed"></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<input type="hidden" name="customerType" value="natural">
					<input type="button" value="ثبت" onclick="Clicked()">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br><br><br>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
