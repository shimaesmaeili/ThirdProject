<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>مشتری حقیقی جدید</title>
</head>
<body>
<div>
	<form action="newCustomer">
		<table class="center">
			<tr>
				<th>اطلاعات مورد نیاز:</th>
				<th></th>
			</tr>
			<tr>
				<td>نام:</td>
				<td><input type="text" name="firstName"><br></td>
			</tr>
			<tr>
				<td>نام خانوادگی:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>نام پدر:</td>
				<td><input type="text" name="fatherName"></td>
			</tr>
			<tr>
				<td>تاریخ تولد:</td>
				<td><input type="date" name="birthDate"></td>
			</tr>
			<tr>
				<td>کد ملی:</td>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="ثبت"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>
