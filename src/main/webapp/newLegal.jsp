<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>مشتری حقوقی جدید</title>
</head>
<body>

<h3 class="center">اطلاعات مورد نیاز: </h3>

<div>
	<form action="newCustomer">
		<table class="center">
			<tr>
				<td>نام شرکت:</td>
				<td><input type="text" name="name"><br></td>
			</tr>
			<tr>
				<td>تاریخ ثبت:</td>
				<td><input type="date" name="regDate"></td>
			</tr>
			<tr>
				<td>کد اقتصادی:</td>
				<td><input type="text" name="code"></td>
			</tr>
		</table>
		<input type="hidden" name="customerType" value="legal">
		<input type="submit" value="ثبت">
	</form>
</div>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
