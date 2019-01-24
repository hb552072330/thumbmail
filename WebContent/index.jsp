<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>上传文件</title>
</head>
<body>
	<div>
		<div>
			<h2>--图片上传--</h2>
		</div>
		<div>
			<form id="upload_form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/thumbnail" method="post">
				<h2>请选择上传的图片</h2>
				<div>
					<input type="file" name="image" id="image"/>
					<input type="submit" value="上传"/>
				</div>
			</form>
		</div>
	</div>
</body>
</html>