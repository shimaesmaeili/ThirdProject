<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<title>ویرایش</title>
</head>
<body>
<div>
	<h3 class="center">
		شماره مشتری:
		${customer.id}
	</h3>
</div>
<div>
	<form action="update">
		<table class="center">
			<c:if test="${customerType=='natural'}">
				<tr>
					<td>نام:</td>
					<td><input type="text" id="first" name="firstName" value=${customer.firstName}><br></td>
				</tr>
				<tr>
					<td>نام خانوادگی:</td>
					<td><input type="text" name="lastName" value=${customer.lastName}></td>
				</tr>
				<tr>
					<td>نام پدر:</td>
					<td><input type="text" name="fatherName" value=${customer.fatherName}></td>
				</tr>
				<tr>
					<td>تاریخ تولد:</td>
					<td><input type="date" name="birthDate" value=${customer.birthDate}></td>
				</tr>
				<tr>
					<td>کد ملی:</td>
					<td><input type="text" name="idCode" value=${customer.code}></td>
				</tr>
			</c:if>
			<c:if test="${customerType=='legal'}">
				<tr>
					<td>نام شرکت:</td>
					<td><input type="text" name="name" value=${customer.name}><br></td>
				</tr>
				<tr>
					<td>تاریخ ثبت:</td>
					<td><input type="date" name="regDate" value=${customer.regDate}></td>
				</tr>
				<tr>
					<td>کد اقتصادی:</td>
					<td><input type="text" name="eCode" value=${customer.code}></td>
				</tr>
			</c:if>
			<tr>
				<td></td>
				<td>
					<input type="hidden" name="customerType" value=${customerType}>
					<input type="hidden" name="id" value=${customer.id}>
					<input type="submit" value="ثبت">
				</td>
			</tr>
		</table>
	</form>
</div>
<br><br>
<a href="/index.jsp" class="link">صفحه اصلی</a>
</body>
</html>
