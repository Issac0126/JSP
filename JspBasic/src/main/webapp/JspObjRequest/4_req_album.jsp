<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	
	<style>
	
		table{
		text-align: center;
		padding: 2px;
		margin: 0 auto;
		border: 1px solid #000000;
		}
		th, td, tr{
		border: 1px solid lightblue;
		padding: 0 5px;
		}
		th{
		width: 120px;
		}
		
		img{
		width: 140px
		}
		tr:nth-child(1) {
			background-color: lightblue;
		}
	
	</style>

<body>
	<form action="4_req_album_movie.jsp">
		<table>
			<tr>
				<td></td>
				<th>앨범 커버</th>
				<th>가수</th>
				<th>영상</th>
				<th>업로드일</th>
			</tr>
			<tr>
				<td><input type="radio" name="pick" value="sel1"></td>
				<td><img alt="오리" src="duck.jpg"></td>
				<td>오리</td>
				<td>오리 힐링 영상</td>
				<td>2021.4.30.</td>
			</tr>
			<tr>
				<td><input type="radio" name="pick" value="sel2"></td>
				<td><img alt="HamBoy" src="hamboy.jpg"> </td>
				<td>Cover 함원진</td>
				<td>Hype Boy</td>
				<td>2022.4.12.</td>
			</tr>
			<tr> <td colspan="5"> <input type="submit" name="선택" value="선택"></td> </tr>
		</table>
	</form>
	


</body>
</html>