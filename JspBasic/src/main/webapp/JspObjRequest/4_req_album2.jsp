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
		border: 0px solid #000000;
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

		<table>
			<tr>
				<th>앨범 커버</th>
				<th>가수</th>
				<th>영상</th>
				<th>업로드일</th>
			</tr>
			<tr>
				<td><img alt="오리" src="duck.jpg"></td>
				<td>오리</td>
					<td>
						<a href="4_req_album_movie.jsp?pick=sel1">오리 힐링 영상</a>
					</td>
				<td>2021.4.30.</td>
			</tr>
			<tr>	
				<td><img alt="HamBoy" src="hamboy.jpg?pick=sel2"> </td>
				<td>Cover 함원진</td>
					<td>
						<a href="4_req_album_movie.jsp">Hype Boy</a>
					</td>
				<td>2022.4.12.</td>
			</tr>
		</table>



</body>
</html>