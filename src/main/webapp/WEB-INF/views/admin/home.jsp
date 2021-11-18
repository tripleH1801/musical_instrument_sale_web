<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-4">
				<div class="form-group">
					<label for="exampleInputEmail1">Tìm kiếm</label> <input
						type="email" class="form-control" id="exampleInputEmail1"
						aria-describedby="emailHelp" placeholder="Nhập tên sản phẩm">

				</div>
			</div>

		</div>


		<div class="row">

			<table class="table">

				<thead class="thead-light">
					<tr>
						<th>STT</th>
						<th>Tên sản phẩm</th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Loại sản phẩm</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Xuất Xứ</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th><select class="form-control"
							id="exampleFormControlSelect1">
								<option>Thương Hiệu</option>
								<option>2</option>
								<option>3</option>
								<option>4</option>
								<option>5</option>
						</select></th>
						<th>Số lượng</th>
						<th></th>
					</tr>
				</thead>

				<tbody>
					<tr>
						<td>1</td>
						<td>Kem bôi trơn</td>
						<td>Durex</td>
						<td>Châu Phi</td>
						<td>Durex</td>
						<td>C12</td>
						<td><button type="button" class="btn btn-primary table__btn">Chi
								tiết</button></td>
					</tr>

				</tbody>
			</table>

		</div>



	</div>
	<!-- /.container-fluid -->
</body>
</html>